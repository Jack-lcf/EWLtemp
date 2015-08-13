package dao.mysql;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import logger.Log;
import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;
import dao.WordDao;
import domain.AbstractEntity;

public class DaoFactoryImpl implements DaoFactory {

    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/ewl";
    private ConnectionFactory connectionFactory = null;
    private static final Map<Class<? extends Dao<? extends AbstractEntity>>, 
                             Class<? extends Dao<? extends AbstractEntity>>>
                                    classes = new ConcurrentHashMap
                                             <Class<? extends Dao<? extends AbstractEntity>>, 
                                              Class<? extends Dao<? extends AbstractEntity>>>();
    static {
        classes.put(WordDao.class, WordDaoImpl.class);
    }
    
    public DaoFactoryImpl() throws DaoException {
        try {
            connectionFactory = new ConnectionFactory(url, user, password);
        } catch (ClassNotFoundException e) {
            Log.error(Messages.CONNECTION_POOL_CREATE_ERROR);
            throw new DaoException(e);
        }
    }

    @Override
    public <T extends Dao<AbstractEntity>> T createDao(Class<T> key) {
        // TODO Auto-generated method stub
        return null;
    }

}
