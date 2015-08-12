package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.Dao;
import dao.DaoException;
import domain.AbstractEntity;

public abstract class AbstractJDBCDao<T extends AbstractEntity> implements Dao<T> {

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
        Connection connection = 
        return null;
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
