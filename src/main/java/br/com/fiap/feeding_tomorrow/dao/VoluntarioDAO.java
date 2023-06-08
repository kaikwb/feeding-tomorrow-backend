package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.Voluntario;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class VoluntarioDAO extends DAO<Voluntario> {
    static final String tableName = "VOLUNTARIO";
    static final String idColumn = "ID_VOLUNTARIO";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("NOME", "Nome");
        put("EMAIL", "Email");
        put("TELEFONE", "Telefone");
    }};

    /**
     * Cria um DAO para a entidade Voluntario.
     *
     * @param connection conexão com o banco de dados.
     */
    public VoluntarioDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Voluntario.class);
    }
}

