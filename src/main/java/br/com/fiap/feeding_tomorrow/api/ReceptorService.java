package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.Receptor;
import br.com.fiap.feeding_tomorrow.dao.ReceptorDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/receptador")
public class ReceptorService extends Service<Receptor> {

    public ReceptorService() throws SQLException {
        super(new ReceptorDAO(DatabaseConnection.getConnection()));
    }
}
