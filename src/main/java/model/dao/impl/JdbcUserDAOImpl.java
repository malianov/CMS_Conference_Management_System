package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.UserDao;
import model.dao.impl.queries.UserSQL;
import model.entity.Role;
import model.entity.User;
import model.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDAOImpl implements UserDao {
    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword");

        User user = null;
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword = inside try");
            PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY.getQUERY());
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword = after ResultSet rs = ps.executeQuery();");
            if (rs.next()) {
                do {
                    user = new User();
                    user.setId(rs.getInt("u_id"));
                    user.setLogin(rs.getString("u_login"));
                    user.setName(rs.getString("u_name"));
                    user.setSurname(rs.getString("u_surname"));
                    user.setEmail(rs.getString("u_email"));
                    user.setRole(Role.getRoleById(rs.getInt("u_role")));
                    user.setIsActive(rs.getInt("u_isActive"));
                    user.setPassword(rs.getString("u_password"));
                } while (rs.next());
            } else {
                //logger
            }
        } catch (SQLException e) {
            //logger
        }
        System.out.println("UserDaoImpl.java -> user - " + user);
        return user;
    }

    @Override
    public List<User> findAllUsers() throws DAOException, SQLException {
        List<User> list = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_ALL_USERS_QUERY.getQUERY());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    User user = new User();
                    user.setId(rs.getInt("u_id"));
                    user.setLogin(rs.getString("u_login"));
                    user.setName(rs.getString("u_name"));
                    user.setSurname(rs.getString("u_surname"));
                    user.setEmail(rs.getString("u_email"));
                    user.setRole(Role.getRoleById(rs.getInt("u_role")));
                    user.setIsActive(rs.getInt("u_isActive"));
                    list.add(user);
                } while (rs.next());
            } else {
                //logger
            }
        } catch (SQLException e) {
            //logger
        }
        System.out.println(list);
        return list;
    }


}
