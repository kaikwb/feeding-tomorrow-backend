package br.com.fiap.feeding_tomorrow.dao;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.fiap.feeding_tomorrow.beans.CentroDistribuicao;

public class CentroDistribuicaoDAO extends DAO<CentroDistribuicao> {
    static final String tableName = "CENTRO_DISTRIBUICAO";
    static final String idColumn = "ID_CENTRO";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("NOME", "Nome");
        put("ENDERECO", "Endereco");
        put("RESPONSAVEL", "Responsavel");
        put("CAPACIDADE_MAXIMA", "CapacidadeMaxima");
    }};

    /**
     * Cria um DAO para a entidade CentroDistribuicao.
     *
     * @param connection conexão com o banco de dados.
     */
    public CentroDistribuicaoDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, CentroDistribuicao.class);
    }
}
