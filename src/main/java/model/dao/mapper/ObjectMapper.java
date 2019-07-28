package model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ObjectMapper<T> {
    T extractFromResultSet(ResultSet rs) throws SQLException;
}
