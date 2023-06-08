package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.Alimento;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AlimentoDAO extends DAO<Alimento> {
    static final String tableName = "ALIMENTO";
    static final String idColumn = "ID_ALIMENTO";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("NOME", "Nome");
        put("TIPO", "Tipo");
        put("VALIDADE", "Validade");
    }};

    /**
     * Cria um DAO para a entidade Alimento.
     *
     * @param connection conexão com o banco de dados.
     */
    public AlimentoDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Alimento.class);
    }
}

