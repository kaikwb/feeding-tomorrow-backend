package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.Doacao;
import br.com.fiap.feeding_tomorrow.dao.DoacaoDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/doacao")
public class DoacaoService extends Service<Doacao> {

    public DoacaoService() throws SQLException {
        super(new DoacaoDAO(DatabaseConnection.getConnection()));
    }

}
