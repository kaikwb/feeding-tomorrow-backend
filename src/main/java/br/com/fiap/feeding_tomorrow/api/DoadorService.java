package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.Doador;
import br.com.fiap.feeding_tomorrow.dao.DoadorDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/doador")
public class DoadorService extends Service<Doador> {

    public DoadorService() throws SQLException {
        super(new DoadorDAO(DatabaseConnection.getConnection()));
    }
}
