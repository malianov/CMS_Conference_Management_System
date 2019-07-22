package connection;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ConnectionPool {
    private static volatile DataSource dataSource;

    private static DataSource getDataSource() {
        System.out.println("ConnectionPool.java -> inside DataSource");
        if (dataSource == null) {
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ResourceBundle resource = ResourceBundle.getBundle("db");
                    ds.setDriverClassName(resource.getString("MYSQL_DB_DRIVER_CLASS"));
                    ds.setUrl(resource.getString("MYSQL_DB_URL"));
                    ds.setUsername(resource.getString("MYSQL_DB_USERNAME"));
                    ds.setPassword(resource.getString("MYSQL_DB_PASSWORD"));
                    ds.setMinIdle(Integer.valueOf(resource.getString("MYSQL_DB_MIN")));
                    ds.setMaxIdle(Integer.valueOf(resource.getString("MYSQL_DB_MAX")));
                    ds.setMaxOpenPreparedStatements(Integer.valueOf(resource.getString("MYSQL_DB_STATEMENTS")));
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection()  {
        System.out.println("ConnectionPool.java -> inside getConnection");
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Thare is no connection with database");
        }
    }
}
