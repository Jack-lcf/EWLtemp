package dao;

import java.util.List;

import domain.AbstractEntity;

public interface Dao<T extends AbstractEntity> {
    
    public Integer create() throws DaoException;
    
    public T getById(Integer id) throws DaoException;
    
    public List<T> getAll() throws DaoException;
    
    public void update(T object) throws DaoException;
    
    public void delete(Integer id) throws DaoException;
}
