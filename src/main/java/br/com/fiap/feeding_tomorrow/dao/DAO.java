package br.com.fiap.feeding_tomorrow.dao;

import jakarta.ws.rs.NotFoundException;

import java.lang.reflect.Method;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class DAO<T> {
    public final Connection connection;
    public final String tableName;
    public final String idColumn;
    public final Map<String, String> columnAttrMap;
    public final Class<T> clazz;

    /**
     * Cria um DAO para a entidade T.
     *
     * @param connection    conexão com o banco de dados.
     * @param tableName     nome da tabela no banco de dados.
     * @param idColumn      nome da coluna de identificação da tabela.
     * @param columnAttrMap mapa de colunas e atributos da entidade T.
     * @param clazz         classe da entidade T.
     */
    DAO(Connection connection, String tableName, String idColumn, Map<String, String> columnAttrMap, Class<T> clazz) {
        this.connection = connection;
        this.tableName = tableName;
        this.idColumn = idColumn;
        this.columnAttrMap = columnAttrMap;
        this.clazz = clazz;
    }

    /**
     * Formata uma string em pascal case.
     *
     * @param input string a ser formatada.
     * @return string em pascal case.
     */
    public static String pascalCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    /**
     * Obtém um atributo da entidade T.
     *
     * @param obj        entidade T.
     * @param methodName nome do método get do atributo.
     */
    public Object getAttrFromEntity(T obj, String methodName) throws Exception {
        Method method = clazz.getMethod(methodName);
        return method.invoke(obj);
    }

    /**
     * Define um atributo da entidade T.
     *
     * @param methodName nome do método set do atributo.
     * @param valueClass classe do valor do atributo.
     * @param value      valor do atributo.
     * @param obj        entidade T.
     */
    public void setAttrFromEntity(String methodName, Class valueClass, Object value, T obj) throws Exception {
        Method method = clazz.getMethod(methodName, valueClass);
        method.invoke(obj, value);
    }

    /**
     * Obtém a classe de um atributo da entidade T.
     *
     * @param attrName nome do atributo.
     * @return classe do atributo.
     * @throws Exception caso o atributo não exista.
     */
    public Class getAttrClass(String attrName) throws Exception {
        Method method = clazz.getMethod("get" + attrName);
        return method.getReturnType();
    }

    /**
     * Define todos os campos de uma entidade T em um PreparedStatement.
     *
     * @param ps     PreparedStatement.
     * @param entity entidade T.
     * @throws Exception caso ocorra algum erro ao definir os campos.
     */
    public void setAllFields(PreparedStatement ps, T entity) throws Exception {
        int i = 0;
        for (String column : this.columnAttrMap.keySet()) {
            String attr = this.columnAttrMap.get(column);
            Object attrValue = getAttrFromEntity(entity, "get" + attr);
            Class attrClass = getAttrClass(attr);

            if (attrClass.equals(String.class)) {
                if (attrValue == null) {
                    ps.setNull(++i, Types.VARCHAR);
                } else {
                    ps.setString(++i, (String) attrValue);
                }
            } else if (attrClass.equals(Integer.class)) {
                if (attrValue == null) {
                    ps.setNull(++i, Types.INTEGER);
                } else {
                    ps.setInt(++i, (Integer) attrValue);
                }
            } else if (attrClass.equals(Double.class)) {
                if (attrValue == null) {
                    ps.setNull(++i, Types.DOUBLE);
                } else {
                    ps.setDouble(++i, (Double) attrValue);
                }
            } else if (attrClass.equals(Boolean.class)) {
                if (attrValue == null) {
                    ps.setNull(++i, Types.BOOLEAN);
                } else {
                    ps.setBoolean(++i, (Boolean) attrValue);
                }
            } else if (attrClass.equals(LocalDateTime.class)) {
                if (attrValue == null) {
                    ps.setNull(++i, Types.TIMESTAMP);
                } else {
                    ps.setTimestamp(++i, Timestamp.valueOf((LocalDateTime) attrValue));
                }
            }
        }
    }

    /**
     * Cria uma entidade T a partir de um ResultSet.
     *
     * @param rs ResultSet.
     * @return entidade T.
     * @throws Exception caso ocorra algum erro ao criar a entidade.
     */
    public T createFromResult(ResultSet rs) throws Exception {
        T obj = clazz.getConstructor().newInstance();

        for (String column : this.columnAttrMap.keySet()) {
            String attr = this.columnAttrMap.get(column);
            Class attrClass = getAttrClass(attr);

            if (attrClass.equals(Boolean.class)) {
                setAttrFromEntity("set" + attr, attrClass, rs.getBoolean(column), obj);
            } else if (attrClass.equals(LocalDateTime.class)) {
                setAttrFromEntity("set" + attr, attrClass, rs.getTimestamp(column).toLocalDateTime(), obj);
            } else if (attrClass.equals(Double.class)) {
                setAttrFromEntity("set" + attr, attrClass, rs.getDouble(column), obj);
            } else if (attrClass.equals(Integer.class)) {
                setAttrFromEntity("set" + attr, attrClass, rs.getInt(column), obj);
            } else if (attrClass.equals(String.class)) {
                setAttrFromEntity("set" + attr, attrClass, rs.getString(column), obj);
            }
        }

        setAttrFromEntity("set" + pascalCase(idColumn), Integer.class, rs.getInt(idColumn), obj);

        return obj;
    }

    /**
     * Obtém o código SQL para criar uma entidade T.
     *
     * @return código SQL.
     */
    public String getCreateSQL() {
        String columns = String.join(", ", columnAttrMap.keySet());
        String values = String.join(", ", Collections.nCopies(columnAttrMap.size(), "?"));

        return String.format("INSERT INTO %s (%s) VALUES (%s)", this.tableName, columns, values);
    }

    /**
     * Obtém o código SQL para selecionar uma entidade T.
     *
     * @return código SQL.
     */
    public String getSingleSelectSQL() {
        return String.format("SELECT * FROM %s WHERE %s = ?", tableName, idColumn);
    }

    /**
     * Obtém o código SQL para selecionar todas as entidades T.
     *
     * @return código SQL.
     */
    public String getAllSelectSQL() {
        return String.format("SELECT * FROM %s", tableName);
    }

    /**
     * Obtém o código SQL para atualizar uma entidade T.
     *
     * @return código SQL.
     */
    public String getUpdateSQL() {
        String values = String.join(", ", Collections.nCopies(columnAttrMap.size(), "%s = ?"));
        return String.format(String.format("UPDATE %s SET %s WHERE %s = ?", tableName, values, idColumn), columnAttrMap.keySet().toArray());
    }

    /**
     * Obtém o código SQL para deletar uma entidade T.
     *
     * @return código SQL.
     */
    public String getDeleteSQL() {
        return String.format("DELETE FROM %s WHERE %s = ?", tableName, idColumn);
    }

    /**
     * Cria uma entidade T.
     *
     * @param entity entidade T.
     * @return entidade T criada.
     * @throws Exception caso ocorra algum erro ao criar a entidade.
     */
    public T create(T entity) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String[] returnId = {this.idColumn};
            ps = connection.prepareStatement(getCreateSQL(), returnId);
            setAllFields(ps, entity);
            ps.execute();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                setAttrFromEntity("set" + pascalCase(this.idColumn), Integer.class, rs.getInt(1), entity);
            }

            return entity;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Cria uma entidade T.
     *
     * @param entity           entidade T.
     * @param attributeToCheck atributo a ser verificado se existe na tabela.
     * @throws Exception caso ocorra algum erro ao criar a entidade.
     */
    public void create(T entity, String attributeToCheck) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            if (attributeExistsInTable(attributeToCheck.toUpperCase(), getAttrFromEntity(entity, "get" + attributeToCheck))) {
                return;
            }

            String[] returnId = {this.idColumn};
            ps = connection.prepareStatement(getCreateSQL(), returnId);
            setAllFields(ps, entity);
            ps.execute();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                setAttrFromEntity("set" + pascalCase(this.idColumn), Integer.class, rs.getInt(1), entity);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Seleciona uma entidade T.
     *
     * @param id ID da entidade T.
     * @return entidade T selecionada.
     * @throws Exception caso ocorra algum erro ao selecionar a entidade.
     */
    public T get(int id) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(getSingleSelectSQL());
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return createFromResult(rs);
            }

            throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
    }

    /**
     * Seleciona todas as entidades T.
     *
     * @param orderBy      coluna para ordenar.
     * @param ascending    se a ordenação é ascendente.
     * @param page         página a ser selecionada.
     * @param itemsPerPage quantidade de itens por página.
     * @return lista de entidades T.
     * @throws Exception caso ocorra algum erro ao selecionar as entidades.
     */
    public List<T> get(String orderBy, Boolean ascending, Integer page, Integer itemsPerPage) throws Exception {
        StringBuilder sqlBuilder = new StringBuilder(getAllSelectSQL());

        if (orderBy == null) {
            orderBy = idColumn;
        }

        if (ascending == null) {
            ascending = true;
        }

        if (page == null) {
            page = 1;
        }

        if (itemsPerPage == null) {
            itemsPerPage = 500;
        }

        if (orderBy != null) {
            String order = ascending ? "ASC" : "DESC";
            sqlBuilder.append(" ORDER BY ").append(orderBy).append(" ").append(order);
        }

        int offset = (page - 1) * itemsPerPage;
        sqlBuilder.append(" OFFSET ").append(offset).append(" ROWS FETCH NEXT ").append(itemsPerPage).append(" ROWS ONLY");

        try (PreparedStatement ps = connection.prepareStatement(sqlBuilder.toString())) {
            List<T> entityList = new ArrayList<>();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                entityList.add(createFromResult(rs));
            }

            return entityList;
        }
    }

    /**
     * Atualiza uma entidade T.
     *
     * @param id     ID da entidade T.
     * @param entity entidade T.
     * @throws Exception caso ocorra algum erro ao atualizar a entidade.
     */
    public void update(int id, T entity) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(getUpdateSQL())) {
            setAllFields(ps, entity);
            ps.setInt(this.columnAttrMap.size() + 1, id);
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
            }
        }
    }

    /**
     * Deleta uma entidade T.
     *
     * @param id ID da entidade T.
     * @throws Exception caso ocorra algum erro ao deletar a entidade.
     */
    public void delete(int id) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(getDeleteSQL())) {
            ps.setInt(1, id);
            int rowAffected = ps.executeUpdate();

            if (rowAffected == 0) {
                throw new NotFoundException(String.format("%s ID %d not found.", clazz.getSimpleName(), id));
            }
        }
    }

    /**
     * Verifica se um atributo existe na tabela.
     *
     * @param attributeName  nome do atributo.
     * @param attributeValue valor do atributo.
     * @return true se o atributo existe na tabela, false caso contrário.
     * @throws SQLException caso ocorra algum erro ao verificar se o atributo existe na tabela.
     */
    private boolean attributeExistsInTable(String attributeName, Object attributeValue) throws SQLException {
        String sql = String.format("SELECT COUNT(*) FROM %s WHERE %s = ?", tableName, attributeName);
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, attributeValue);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    }
}
