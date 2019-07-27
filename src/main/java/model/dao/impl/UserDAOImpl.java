package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.IUserDAO;
import model.dao.daoFactory.Utils;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends Utils implements IUserDAO {
    //private static final String FIND_ALL_USERS_QUERY        = "SELECT * FROM CMS.users";
    private static final String FIND_ALL_USERS_QUERY        = "SELECT * FROM CMS.users LIMIT 10 OFFSET 19";
    private static final String FIND_USER_BY_LOGIN_QUERY    = "SELECT * FROM LMS.users WHERE u_login = ?";
    private static final String FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY = "SELECT * FROM CMS.users WHERE u_login = ? AND u_password = ?";

    //private static final String FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY = "SELECT * FROM CMS.users WHERE u_login = ? AND u_password = ?";
    private static final String CHANGE_USER_ACTIVE_STATUS_BY_LOGIN_QUERY  = "UPDATE LMS.users SET u_is_active = ? WHERE l_login = ?";
    private static final String CREATE_USER_QUERY           = "INSERT INTO LMS.users (u_login, u_name, u_surname) VALUES (?, ?, ?)";
    private static final String MAX_USER_ID_QUERY           = "SELECT max(l_id) FROM LMS.users";
    private static final String CHANGE_USER_MANAGERIAL_STATUS_BY_LOGIN_QUERY = "UPDATE LMS.users SET u_is_manager = ? WHERE u_login = ?";

    @Override
    public List<User> findAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    User user = new User();
                    user.setId(rs.getInt("u_id"));
                    user.setLogin(rs.getString("u_login"));
                    user.setName(rs.getString("u_name"));
                    user.setSurname(rs.getString("u_surname"));
                    user.setEmail(rs.getString("u_email"));
                    user.setRole(rs.getInt("u_role"));
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

    @Override
    public User findUserByLoginAndPassword(String login, String password) {

        System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword");

        User user = null;
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword = inside try");
            PreparedStatement ps = conn.prepareStatement(FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY);
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
                    user.setRole(rs.getInt("u_role"));
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
//
//    @Override
//    public User findUserByLogin(String login) {
//        User user = null;
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(FIND_USER_BY_LOGIN_QUERY);
//            ps.setString(1, login);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                do {
//                    user = new User();
//                    user.setId(rs.getInt("u_id"));
//                    user.setLogin(rs.getString("u_login"));
//                    user.setName(rs.getString("u_name"));
//                    user.setSurname(rs.getString("u_surname"));
//                    user.setIsActive(rs.getInt("u_is_active"));
//                    user.setIsManager(rs.getInt("u_is_manager"));
//                } while (rs.next());
//            } else {
//                //logger
//            }
//        } catch (SQLException e) {
//            //logger
//        }
//        System.out.println(user);
//        return user;
//    }
//
//    @Override
//    public void makeUserInactiveByLogin(String login) {
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(CHANGE_USER_ACTIVE_STATUS_BY_LOGIN_QUERY);
//            ps.setInt(1, 0);
//            ps.setString(2, login);
//            int result = ps.executeUpdate();
//            if (result != 0) {
//                conn.commit();
//            }
//        } catch (SQLException e) {
//            //logger
//        }
//    }
//
//    @Override
//    public void makeUserActiveByLogin(String login) {
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(CHANGE_USER_ACTIVE_STATUS_BY_LOGIN_QUERY);
//            ps.setInt(1, 1);
//            ps.setString(2, login);
//            int result = ps.executeUpdate();
//            if (result != 0) {
//                conn.commit();
//            }
//        } catch (SQLException e) {
//            //logger
//        }
//    }
//
//    @Override
//    public void makeUserAsGeneralByLogin(String login) {
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(CHANGE_USER_MANAGERIAL_STATUS_BY_LOGIN_QUERY);
//            ps.setInt(1, 0);
//            ps.setString(2, login);
//            System.out.println(ps);
//            int result = ps.executeUpdate();
//            if (result != 0) {
//                conn.commit();
//            }
//        } catch (SQLException e) {
//            //logger
//        }
//    }
//
//    @Override
//    public void makeUserAsNotGeneralByLogin(String login) {
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(CHANGE_USER_MANAGERIAL_STATUS_BY_LOGIN_QUERY);
//            ps.setInt(1, 1);
//            ps.setString(2, login);
//            int result = ps.executeUpdate();
//            if (result != 0) {
//                conn.commit();
//            }
//        } catch (SQLException e) {
//            //logger
//        }
//    }
//
//    @Override
//    public void registerUser(User user) {
//        try (Connection conn = ConnectionPool.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(CREATE_USER_QUERY);
//            ps.setString(1, user.getLogin());
//            ps.setString(2, user.getName());
//            ps.setString(3, user.getSurname());
//            int result = ps.executeUpdate();
//            if (result != 0) {
//                conn.commit();
//            }
//        } catch (SQLException e) {
//        }
//    }
}
