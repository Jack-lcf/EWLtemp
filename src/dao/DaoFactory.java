package dao;

import java.sql.Connection;
import java.sql.SQLException;

import domain.Dictionary;
import domain.Word;

public interface DaoFactory {
    
    public Connection getConnection() throws SQLException;
    
    public Word getWordDao();
    
    public Dictionary getDictionary();

}
