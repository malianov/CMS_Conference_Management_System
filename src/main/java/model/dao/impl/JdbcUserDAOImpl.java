package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.UserDao;
import model.dao.impl.queries.UserSQL;
import model.dao.mapper.UserMapper;
import model.dao.utility.FindQueryGenerator;
import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserDAOImpl implements UserDao {
    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        System.out.println("JdbcUserDAOImpl.java -> inside findUserByLoginAndPassword");

        UserMapper userMapper = new UserMapper();
//        User user = new User();
//        user = null;

        try (Connection conn = ConnectionPool.getConnection();
            PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY.getQUERY())) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("JdbcUserDAOImpl.java -> inside findUserByLoginAndPassword = after ResultSet rs = ps.executeQuery();");

            rs.next();
            return userMapper.extractFromResultSet(rs);
        } catch (SQLException e) {
            //logger
            throw new DAOException();
        }

    }

    @Override
    public UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String searchUserLogin,
                                                                    String searchUserName, String searchUserSurname, String searchUserEmail) {

        System.out.println("=== === === JdbcUserDAOImpl.java - > searchUserId = " + searchUserId);
        System.out.println("=== === === JdbcUserDAOImpl.java - > searchUserLogin = " + searchUserLogin);
        System.out.println("=== === === JdbcUserDAOImpl.java - > searchUserName = " + searchUserName);
        System.out.println("=== === === JdbcUserDAOImpl.java - > searchUserSurname = " + searchUserSurname);
        System.out.println("=== === === JdbcUserDAOImpl.java - > searchUserEmail = " + searchUserEmail);

        UserService.PaginationResult paginationResult = new UserService.PaginationResult();

        UserMapper userMapper = new UserMapper();
        List<User> users = new ArrayList<>();

        System.out.println("-_-_-_-_-_ users - " + users);
        FindQueryGenerator qg = new FindQueryGenerator();
        String findUsersByCriteriaRequests = String.valueOf(qg.findUsersByCriteriaRequests(searchUserId, searchUserLogin,
                searchUserName, searchUserSurname, searchUserEmail)) + "LIMIT ?, ?;";

        PreparedStatement usersPS = null;
        try (Connection conn = ConnectionPool.getConnection()) {
            usersPS = conn.prepareStatement(findUsersByCriteriaRequests);
            usersPS.setInt(1, lowerBound);
            usersPS.setInt(2, upperBound);
            ResultSet rs = usersPS.executeQuery();

            while (rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
                users.add(user);
            }

            String findCountUsersByCriteriaRequests = String.valueOf(qg.calculateUsersByCriteriaRequests(searchUserId, searchUserLogin,
                    searchUserName, searchUserSurname, searchUserEmail));

            PreparedStatement countRowsPS = null;

            countRowsPS = conn.prepareStatement(findCountUsersByCriteriaRequests);
            rs = countRowsPS.executeQuery();

            if (rs.next()) {
                paginationResult.setNoOfRows(rs.getInt(1));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        paginationResult.setUsersList(new ArrayList<>(users));
        return paginationResult;
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public void changeUserRole(String userLogin, String newRole) {
        System.out.println("jdbcUserDaoImpl.java ==>> changeUserRole");
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("UserDAOImpl.java -> changeUserRole = inside try");
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHANGE_USER_ROLE_BY_ID_AND_NEW_ROLE_QUERY.getQUERY());
            ps.setString(1, newRole);
            ps.setString(2, userLogin);
            System.out.println("UserDAOImpl.java -> changeUserRole = ps = " + ps);

            ps.execute();

            System.out.println("JdbcUserDAOImpl.java -> inside changeUserRole = after ResultSet rs = ps.executeQuery();");
        } catch (SQLException e) {
            //logger
        }
    }

    @Override
    public void changeUserActivityStatus(String userLogin, String newActivityStatus) {
        System.out.println("jdbcUserDaoImpl.java ==>> changeUserActivityStatus");
        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("UserDAOImpl.java -> changeUserActivityStatus = inside try");
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHANGE_USER_ACTIVITY_STATUS_QUERY.getQUERY());
            ps.setString(1, newActivityStatus);
            ps.setString(2, userLogin);
            System.out.println("UserDAOImpl.java -> changeUserActivityStatus = ps = " + ps);

            ps.execute();

            System.out.println("JdbcUserDAOImpl.java -> inside changeUserActivityStatus = after ResultSet rs = ps.executeQuery();");
        } catch (SQLException e) {
            //logger
        }
    }

    @Override
    public User findByLogin(String login) throws DAOException {

        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_USER_BY_LOGIN_QUERY.getQUERY());
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            System.out.println("UserDAOImpl.java -> findByLogin - rs = " + rs);

            rs.next();

            User user = new UserMapper().extractFromResultSet(rs);
            System.out.println("UserDAOImpl.java -> findByLogin - user = " + user);
            return user;

        } catch (SQLException ex) {
            System.out.println("jdbcUserDAOImpl.java -> findByLogin - cathed exception");
            throw new DAOException();
        }
    }

    @Override
    public boolean ifLoginExists(String login) {
        System.out.println("UserDAOImpl.java -> inside ifLoginExists ");
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHECK_LOGIN_EXISTS.getQUERY());
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            System.out.println("UserDAOImpl.java -> ifLoginExists - rs = " + rs);

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("jdbcUserDAOImpl.java -> findByName - cathed exception");
        }
        return false;
    }
}


