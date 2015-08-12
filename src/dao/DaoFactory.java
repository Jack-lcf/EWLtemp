package dao;

import domain.AbstractEntity;

public interface DaoFactory {
    
    public <T extends Dao<AbstractEntity>> T createDao(Class<T> key);
}
