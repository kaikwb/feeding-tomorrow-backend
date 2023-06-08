package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.Doador;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DoadorDAO extends DAO<Doador> {
    static final String tableName = "DOADOR";
    static final String idColumn = "ID_DOADOR";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("NOME", "Nome");
        put("EMAIL", "Email");
        put("TELEFONE", "Telefone");
    }};

    /**
     * Cria um DAO para a entidade Doador.
     *
     * @param connection conexão com o banco de dados.
     */
    public DoadorDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Doador.class);
    }
}
