package br.com.fiap.feeding_tomorrow.beans;

import jakarta.annotation.Nullable;

public class News {
    private Integer id;
    private String title;
    @Nullable
    private String description;
    private String source;
    private String link;
    @Nullable
    private String thumbnail;


    /**
     * Cria um objeto de notícia sem dados.
     */
    public News() {
    }

    /**
     * Cria um objeto de notícia com os dados informados.
     *
     * @param id          identificador da notícia.
     * @param title       título da notícia.
     * @param description descrição da notícia.
     * @param source      fonte da notícia.
     * @param link        link da notícia.
     * @param thumbnail   link da imagem da notícia.
     */
    public News(Integer id, String title, String description, String source, String link, String thumbnail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.source = source;
        this.link = link;
        this.thumbnail = thumbnail;
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
     * Retorna o link da imagem da notícia.
     *
     * @return link da imagem da notícia.
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * Define o link da imagem da notícia.
     *
     * @param thumbnail link da imagem da notícia.
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
