package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import logger.Log;
import dao.Dao;
import dao.DaoException;
import domain.AbstractEntity;

public abstract class AbstractJDBCDao<T extends AbstractEntity> implements Dao<T> {

    private ConnectionFactory connectionFactory = null;

    public AbstractJDBCDao(ConnectionFactory cf) {
        connectionFactory = cf;
    }

    /**
     * return sql query to get all records from table
     *
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * return sql query to insert new record into table
     *
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getInsertQuery();

    /**
     * return sql query to update record
     *
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * return sql query to delete record
     *
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * parses ResultSet and return list of objects that relevant content
     * ResultSet
     * 
     * @param rs
     *            ResultSet to parse
     * @return List<Entity>
     * @throws PersistException
     */
    protected abstract List<T> parseResultSet(ResultSet rs) throws DaoException;

    /**
     * sets the arguments Insert query in according to the value of the T object
     * 
     * @param statement
     * @param object
     * @throws PersistException
     */
    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws DaoException;

    /**
     * sets the arguments Update query in according to the value of the T object
     * 
     * @param statement
     * @param object
     * @throws PersistException
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws DaoException;

    @Override
    public Integer create(T object) throws DaoException {
        // insert new record to database
        String query = getInsertQuery();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("Count of records for update is " + count);
            }
            connection.commit();
        } catch (SQLException e) {            
            Log.error(Messages.CONNECTION_ERROR + e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                connection.rollback();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e);
            }
        }

        // Get a just inserted record
        Integer id = null;
        query = getSelectQuery() + " WHERE id = last_insert_id()";
        statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            List<T> result = parseResultSet(resultSet);
            if (result == null || result.size() != 1) {
                throw new DaoException(Messages.GET_BY_ID_ERROR);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                if (resultSet == null) {
                    Log.error("resultSet is null");
                } else {
                    resultSet.close();
                    Log.info("resultSet is ok");
                }
                statement.close();
                Log.info("statement is ok");
                connection.close();
                Log.info("connection is ok");
            } catch (SQLException | NullPointerException e) {
                Log.error("Fucking error " + e);
                throw new DaoException(e);
            }
        }
        return id;
    }

    @Override
    public T getById(Integer id) throws DaoException {
        List<T> result = null;
        String query = getSelectQuery() + " WHERE id = " + id;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            result = parseResultSet(resultSet);
            if (result == null || result.size() != 1) {
                throw new DaoException(Messages.GET_BY_ID_ERROR);
            }
        } catch (SQLException e) {
            Log.error(Messages.CONNECTION_ERROR + e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e);
            }
        }
        return result.iterator().next();
    }

    @Override
    public List<T> getAll() throws DaoException {
        List<T> result = null;
        String query = getSelectQuery();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            result = parseResultSet(resultSet);
        } catch (SQLException e) {
            Log.error(Messages.CONNECTION_ERROR + e);
            throw new DaoException(e);
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e);
            }
        }
        return result;
    }

    @Override
    public void update(T object) throws DaoException {
        String query = getUpdateQuery();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(query);
            prepareStatementForUpdate(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("Count of records for update is " + count);
            }
            connection.commit();
        } catch (SQLException e) {            
            Log.error(Messages.CONNECTION_ERROR + e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                connection.rollback();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e);
            }
        }
    }

    @Override
    public void delete(Integer id) throws DaoException {
        String query = getDeleteQuery();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1, id);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new DaoException("Count of records for delete is " + count);
            }
        } catch (SQLException e) {            
            Log.error(Messages.CONNECTION_ERROR + e);
            throw new DaoException(e);
        } finally {
            try {
                statement.close();
                connection.rollback();
                connection.close();
            } catch (SQLException | NullPointerException e) {
                throw new DaoException(e);
            }
        }
    }

}
