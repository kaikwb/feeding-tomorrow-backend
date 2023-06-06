package br.com.fiap.feeding_tomorrow.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDateTime;

public class News {
    private Integer id;
    private String title;
    private String description;
    private String source;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime pubDate;
    private String link;
    private String guid;


    /**
     * Cria um objeto de notícia sem dados.
     */
    public News() {
    }


    /**
     * Cria um objeto de notícia com dados.
     *
     * @param id          identificador da notícia.
     * @param title       título da notícia.
     * @param description descrição da notícia.
     * @param source      fonte da notícia.
     * @param pubDate     data de publicação da notícia.
     * @param link        link da notícia.
     * @param guid        identificador da notícia.
     */
    public News(Integer id, String title, String description, String source, LocalDateTime pubDate, String link, String guid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.source = source;
        this.pubDate = pubDate;
        this.link = link;
        this.guid = guid;
    }

    /**
     * Retorna o identificador da notícia.
     *
     * @return identificador da notícia.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da notícia.
     *
     * @param id identificador da notícia.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o título da notícia.
     *
     * @return título da notícia.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define o título da notícia.
     *
     * @param title título da notícia.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a descrição da notícia.
     *
     * @return descrição da notícia.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição da notícia.
     *
     * @param description descrição da notícia.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna a fonte da notícia.
     *
     * @return fonte da notícia.
     */
    public String getSource() {
        return source;
    }

    /**
     * Define a fonte da notícia.
     *
     * @param source fonte da notícia.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Retorna a data de publicação da notícia.
     *
     * @return data de publicação da notícia.
     */
    public LocalDateTime getPubDate() {
        return pubDate;
    }

    /**
     * Define a data de publicação da notícia.
     *
     * @param pubDate data de publicação da notícia.
     */
    public void setPubDate(LocalDateTime pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * Retorna o link da notícia.
     *
     * @return link da notícia.
     */
    public String getLink() {
        return link;
    }

    /**
     * Define o link da notícia.
     *
     * @param link link da notícia.
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * Retorna o identificador da notícia.
     *
     * @return identificador da notícia.
     */
    public String getGuid() {
        return guid;
    }

    /**
     * Define o identificador da notícia.
     *
     * @param guid identificador da notícia.
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }
}
