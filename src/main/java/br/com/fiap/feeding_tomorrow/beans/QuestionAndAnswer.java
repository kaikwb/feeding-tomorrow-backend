package br.com.fiap.feeding_tomorrow.beans;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbNillable;

import java.time.LocalDateTime;

public class QuestionAndAnswer {
    private Integer id;
    private String question;
    private String askedBy;
    @JsonbNillable()
    private String answer;
    private String mail;
    @JsonbNillable()
    private String answeredBy;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * Cria uma pergunta e resposta sem dados.
     */
    public QuestionAndAnswer() {
    }

    /**
     * Cria uma pergunta e resposta com dados.
     *
     * @param id         identificador da pergunta e resposta.
     * @param question   pergunta.
     * @param askedBy    quem perguntou.
     * @param answer     resposta.
     * @param mail       email.
     * @param answeredBy quem respondeu.
     * @param createdAt  data de criação.
     */
    public QuestionAndAnswer(Integer id, String question, String askedBy, String answer, String mail, String answeredBy, LocalDateTime createdAt) {
        this.id = id;
        this.question = question;
        this.askedBy = askedBy;
        this.answer = answer;
        this.mail = mail;
        this.answeredBy = answeredBy;
        this.createdAt = createdAt;
    }

    /**
     * Retorna o identificador da pergunta e resposta.
     *
     * @return identificador da pergunta e resposta.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da pergunta e resposta.
     *
     * @param id identificador da pergunta e resposta.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna a pergunta.
     *
     * @return pergunta.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Define a pergunta.
     *
     * @param question pergunta.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retorna quem perguntou.
     *
     * @return quem perguntou.
     */
    public String getAskedBy() {
        return askedBy;
    }

    /**
     * Define quem perguntou.
     *
     * @param askedBy quem perguntou.
     */
    public void setAskedBy(String askedBy) {
        this.askedBy = askedBy;
    }

    /**
     * Retorna a resposta.
     *
     * @return resposta.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Define a resposta.
     *
     * @param answer resposta.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Retorna o email.
     *
     * @return email.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Define o email.
     *
     * @param mail email.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Retorna quem respondeu.
     *
     * @return quem respondeu.
     */
    public String getAnsweredBy() {
        return answeredBy;
    }

    /**
     * Define quem respondeu.
     *
     * @param answeredBy quem respondeu.
     */
    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    /**
     * Retorna a data de criação.
     *
     * @return data de criação.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Define a data de criação.
     *
     * @param createdAt data de criação.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
