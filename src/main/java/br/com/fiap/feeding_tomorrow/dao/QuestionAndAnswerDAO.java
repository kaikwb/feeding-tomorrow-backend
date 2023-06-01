package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.QuestionAndAnswer;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class QuestionAndAnswerDAO extends DAO<QuestionAndAnswer> {
    static final String tableName = "QUESTIONS_AND_ANSWERS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("QUESTION", "Question");
        put("ASKED_BY", "AskedBy");
        put("ANSWER", "Answer");
        put("ANSWERED_BY", "AnsweredBy");
        put("CREATED_AT", "CreatedAt");
    }};


    /**
     * Cria um DAO para a entidade @see QuestionAndAnswer.
     *
     * @param connection conexão com o banco de dados.
     */
    public QuestionAndAnswerDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, QuestionAndAnswer.class);
    }
}
