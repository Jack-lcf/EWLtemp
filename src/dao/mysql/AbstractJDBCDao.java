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
            statement = connection.prepareStatement(query);
            int count = statement.executeUpdate();
            if(count != 1) {
                throw new DaoException("Count of records for update is " + count);
            }
        } catch (SQLException e) {
            Log.error("Connection error: " + e);
            throw new DaoException(e);
        }
        
        // Get a just inserted record
        Integer id = null;
        query = getSelectQuery() + " WHERE id = last_insert_id();";
        statement = null;
        ResultSet resultSet = null;
        try{
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            List<T> result = parseResultSet(resultSet);
            if(result == null || result.size() != 1) {
                throw new DaoException("Exception on find by id new persist data");
            }
        } catch (SQLException e) {
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
        return id;
    }

    @Override
    public T getById(Integer id) throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> getAll() throws DaoException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(T object) throws DaoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Integer id) throws DaoException {
        // TODO Auto-generated method stub
        
    }
    
    
}
