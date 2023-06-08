package br.com.fiap.feeding_tomorrow.api;

import br.com.fiap.feeding_tomorrow.beans.CentroDistribuicao;
import br.com.fiap.feeding_tomorrow.dao.CentroDistribuicaoDAO;
import br.com.fiap.feeding_tomorrow.database.DatabaseConnection;
import jakarta.ws.rs.Path;

import java.sql.SQLException;

@Path("/centrodistribuicao")
public class CentroDistribuicaoService extends Service<CentroDistribuicao> {

    public CentroDistribuicaoService() throws SQLException {
        super(new CentroDistribuicaoDAO(DatabaseConnection.getConnection()));
    }


}
