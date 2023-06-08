package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.Voluntario;
import br.com.fiap.feeding_tomorrow.dao.VoluntarioDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/voluntario")
public class VoluntarioService extends Service<Voluntario> {

    public VoluntarioService() throws SQLException {
        super(new VoluntarioDAO(DatabaseConnection.getConnection()));
    }
}
