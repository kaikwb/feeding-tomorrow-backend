package br.com.fiap.feeding_tomorrow.tasks;

import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import br.com.fiap.feeding_tomorrow.news.GoogleNewsDownloader;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

@WebListener
public class NewsDownloaderScheduler implements ServletContextListener {
    private static final long TASK_PERIOD_MS = 1000 * 60 * 30; // 30 minutes
    private final String rssFeedUrl = "https://www.googleapis.com/customsearch/v1?key=AIzaSyChEZJVCb3w0Sq0_NfPCSHptaBsRxk7cqs&cx=b0e227d57b1ba4fea&q=combate%20a%20fome&siteSearch=g1.globo.com&siteSearchFilter=I&dateRestrict=d[7]&sort=date";

    private Timer timer;

    /**
     * Inicia o agendador de tarefas para baixar as notícias.
     *
     * @param sce evento de inicialização do contexto.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);

        timer = new Timer();
        TimerTask task = null;
        try {
            task = new NewsDownloaderTask(rssFeedUrl);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        timer.scheduleAtFixedRate(task, 0, TASK_PERIOD_MS);
    }

    /**
     * Finaliza o agendador de tarefas para baixar as notícias.
     *
     * @param sce evento de finalização do contexto.
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (timer != null) {
            timer.cancel();
        }

        ServletContextListener.super.contextDestroyed(sce);
    }

    /**
     * Tarefa para baixar as notícias.
     */
    private static class NewsDownloaderTask extends TimerTask {
        private final GoogleNewsDownloader newsDownloader;

        /**
         * Cria uma tarefa para baixar as notícias.
         *
         * @param rssFeedUrl URL do feed RSS.
         * @throws SQLException Exceção lançada em erros de conexão com o banco de dados.
         */
        public NewsDownloaderTask(String rssFeedUrl) throws SQLException {
            super();

            this.newsDownloader = new GoogleNewsDownloader(rssFeedUrl, DatabaseConnection.getConnection());
        }

        /**
         * Executa a tarefa de baixar as notícias.
         */
        @Override
        public void run() {
            try {
                this.newsDownloader.downloadNews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
