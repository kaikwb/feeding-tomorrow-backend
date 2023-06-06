package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.News;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class NewsDAO extends DAO<News> {
    static final String tableName = "NEWS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("TITLE", "Title");
        put("DESCRIPTION", "Description");
        put("SOURCE", "Source");
        put("PUB_DATE", "PubDate");
        put("LINK", "Link");
        put("GUID", "Guid");
    }};

    /**
     * Cria um DAO para a entidade @see News.
     *
     * @param connection conexão com o banco de dados.
     */
    public NewsDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, News.class);
    }
}
