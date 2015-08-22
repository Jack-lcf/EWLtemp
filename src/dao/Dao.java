package dao;

import java.util.List;

public interface Dao<T> {
    
    public Integer create(T object) throws DaoException;
    
    public T getById(Integer id) throws DaoException;
    
    public List<T> getAll() throws DaoException;
    
    public void update(T object) throws DaoException;
    
    public void delete(Integer id) throws DaoException;
}
