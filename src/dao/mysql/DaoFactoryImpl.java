package dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import pool.ConnectionFactory;
import dao.Dao;
import dao.DaoFactory;
import domain.AbstractEntity;
import domain.Dictionary;
import domain.Word;

public class DaoFactoryImpl implements DaoFactory{

    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/ewl";
    private ConnectionFactory connectionFactory = null;
    private static final Map<Class<? extends Dao<? extends AbstractEntity>>, 
            Class<? extends Dao<? extends AbstractEntity>>> 
               classes = new ConcurrentHashMap<Class<? extends Dao<? extends AbstractEntity>>, 
                                               Class<? extends Dao<? extends AbstractEntity>>>();
    static {
        
    }
    
    @Override
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Word getWordDao() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dictionary getDictionary() {
        // TODO Auto-generated method stub
        return null;
    }

}
