package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.Alimento;
import br.com.fiap.feeding_tomorrow.dao.AlimentoDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/alimento")
public class AlimentoService extends Service<Alimento> {

    public AlimentoService() throws SQLException {
        super(new AlimentoDAO(DatabaseConnection.getConnection()));
    }
}
