package pool;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class ConnectionFactory {

    private MysqlConnectionPoolDataSource source;

    public ConnectionFactory(String url, String user, String password) throws ClassNotFoundException {
        source = new MysqlConnectionPoolDataSource();
        source.setUrl(url);
        source.setUser(user);
        source.setPassword(password);
        source.setAutoReconnect(true);
        source.setCachePreparedStatements(true);
    }

    /** attempts to establish a connection to database */
    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    /** attempts to close current connection */
    public void putConnection(Connection connection) throws SQLException {
        connection.close();
    }

}
