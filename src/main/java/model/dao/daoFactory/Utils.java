package model.dao.daoFactory;

import connection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Utils {

    public static int getMaxId(String query) {
        int result = 0;
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
        }
        return result;
    }
}
