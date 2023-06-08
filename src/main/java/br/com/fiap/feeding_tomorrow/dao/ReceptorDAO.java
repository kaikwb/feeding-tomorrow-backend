package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.Receptor;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReceptorDAO extends DAO<Receptor> {
    static final String tableName = "RECEPTOR";
    static final String idColumn = "ID_RECEPTOR";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("NOME", "Nome");
        put("EMAIL", "Email");
        put("TELEFONE", "Telefone");
    }};

    /**
     * Cria um DAO para a entidade Receptor.
     *
     * @param connection conexão com o banco de dados.
     */
    public ReceptorDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Receptor.class);
    }
}
