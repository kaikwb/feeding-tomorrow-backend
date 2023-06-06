package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.News;
import br.com.fiap.feeding_tomorrow.dao.NewsDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/news")
public class NewsService extends Service<News> {

    /**
     * Cria um serviço para a entidade @see News.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public NewsService() throws SQLException {
        super(new NewsDAO(DatabaseConnection.getConnection()));
    }
}
