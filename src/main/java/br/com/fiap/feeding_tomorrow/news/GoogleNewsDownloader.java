package br.com.fiap.feeding_tomorrow.news;

import br.com.fiap.feeding_tomorrow.beans.News;
import br.com.fiap.feeding_tomorrow.dao.NewsDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GoogleNewsDownloader {
    private String rssFeedUrl;
    private NewsDAO newsDao;

    /**
     * Cria um downloader de notícias do Google News.
     *
     * @param rssFeedUrl         URL do feed RSS do Google News.
     * @param databaseConnection conexão com o banco de dados.
     */
    public GoogleNewsDownloader(String rssFeedUrl, Connection databaseConnection) {
        this.rssFeedUrl = rssFeedUrl;
        this.newsDao = new NewsDAO(databaseConnection);
    }

    /**
     * Faz o download das notícias do Google News e as salva no banco de dados.
     *
     * @throws IOException caso ocorra algum erro ao fazer o download das notícias.
     */
    public void downloadNews() throws IOException {
        Document doc = Jsoup.connect(rssFeedUrl).get();
        Elements items = doc.select("item");

        for (Element item : items) {
            String title = item.select("title").first().text();
            String description = item.select("description").first().text();
            String source = item.select("source").first().text();
            String pubDate = item.select("pubDate").first().text();
            String link = item.select("link").first().text();
            String guid = item.select("guid").first().text();

            LocalDateTime publicationDateTime = parsePubDate(pubDate);

            News news = new News(null, title, description, source, publicationDateTime, link, guid);

            try {
                newsDao.create(news, "Guid");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Converte uma data de publicação de uma notícia do formato RFC 1123 para LocalDateTime.
     *
     * @param pubDate data de publicação da notícia no formato RFC 1123.
     * @return data de publicação da notícia no formato LocalDateTime.
     */
    private LocalDateTime parsePubDate(String pubDate) {
        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.ENGLISH);
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(pubDate, formatter);
        return zonedDateTime.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }
}
