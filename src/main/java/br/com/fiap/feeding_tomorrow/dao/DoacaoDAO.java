package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.Doacao;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DoacaoDAO extends DAO<Doacao> {
    static final String tableName = "DOACAO";
    static final String idColumn = "ID_DOACAO";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("ID_DOADOR", "IdDoador");
        put("ID_RECEPTOR", "IdReceptor");
        put("DATA_DOACAO", "DataDoacao");
        put("STATUS", "Status");
    }};

    /**
     * Cria um DAO para a entidade Doacao.
     *
     * @param connection conexão com o banco de dados.
     */
    public DoacaoDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, Doacao.class);
    }
}
