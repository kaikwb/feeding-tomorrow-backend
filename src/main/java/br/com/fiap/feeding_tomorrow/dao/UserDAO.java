package br.com.fiap.feeding_tomorrow.dao;

import br.com.fiap.feeding_tomorrow.beans.User;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDAO extends DAO<User> {
    static final String tableName = "USERS";
    static final String idColumn = "ID";
    static final Map<String, String> columnAttrMap = new LinkedHashMap<>() {{
        put("FIRST_NAME", "FirstName");
        put("LAST_NAME", "LastName");
        put("MAIL", "Mail");
        put("PASSWORD", "Password");
        put("POSTAL_CODE", "PostalCode");
        put("ADDRESS", "Address");
        put("ADDRESS_NUMBER", "AddressNumber");
        put("ADDRESS2", "Address2");
        put("NEIGHBORHOOD", "Neighborhood");
        put("CITY", "City");
        put("STATE", "State");
    }};

    /**
     * Cria um DAO para a entidade @see User.
     *
     * @param connection conexão com o banco de dados.
     */
    public UserDAO(Connection connection) {
        super(connection, tableName, idColumn, columnAttrMap, User.class);
    }
}
