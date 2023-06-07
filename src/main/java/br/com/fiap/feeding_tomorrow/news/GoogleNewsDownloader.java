package br.com.fiap.feeding_tomorrow.news;

import br.com.fiap.feeding_tomorrow.beans.News;
import br.com.fiap.feeding_tomorrow.dao.NewsDAO;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class GoogleNewsDownloader {
    private final String rssFeedUrl;
    private final NewsDAO newsDao;

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
        try {
            URL url = new URL(rssFeedUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JsonObject root = Json.createReader(connection.getInputStream()).readObject();
                JsonArray items = root.getJsonArray("items");

                for (JsonObject item : items.getValuesAs(JsonObject.class)) {
                    JsonObject pageMap = item.getJsonObject("pagemap");
                    JsonObject metatags = pageMap.getJsonArray("metatags").getJsonObject(0);

                    String title = metatags.getString("title");

                    String description = null;
                    if (metatags.containsKey("og:description")) {
                        description = metatags.getString("og:description");
                    }

                    String source = item.getString("displayLink");
                    String urlNews = item.getString("link");

                    String imageUrl = null;
                    if (metatags.containsKey("og:image")) {
                        imageUrl = metatags.getString("og:image");
                    }

                    News news = new News(null, title, description, source, urlNews, imageUrl);
                    newsDao.create(news, "Link");
                }
            } else {
                System.out.println("Erro na requisição. Código de resposta: " + responseCode);
            }
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
