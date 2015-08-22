package dao;

import domain.AbstractEntity;

public interface DaoFactory {
    
    public <T extends Dao<? extends AbstractEntity>> T createDao(Class<T> key);
}
