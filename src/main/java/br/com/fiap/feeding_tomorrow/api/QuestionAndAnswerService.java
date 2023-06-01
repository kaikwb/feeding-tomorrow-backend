package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.QuestionAndAnswer;
import br.com.fiap.feeding_tomorrow.dao.QuestionAndAnswerDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/questions")
public class QuestionAndAnswerService extends Service<QuestionAndAnswer> {

    /**
     * Cria um serviço para a entidade @see QuestionAndAnswer.
     *
     * @throws SQLException caso ocorra algum erro com a conexão de dados.
     */
    public QuestionAndAnswerService() throws SQLException {
        super(new QuestionAndAnswerDAO(DatabaseConnection.getConnection()));
    }
}
