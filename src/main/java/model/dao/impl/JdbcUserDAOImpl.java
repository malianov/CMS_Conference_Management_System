package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.UserDao;
import model.dao.impl.queries.SeminarSQL;
import model.dao.impl.queries.UserSQL;
import model.dao.mapper.SeminarMapper;
import model.dao.mapper.UserMapper;
import model.dao.utility.FindQueryGenerator;
import model.entity.Seminar;
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
        UserMapper userMapper = new UserMapper();

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY.getQUERY())) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            rs.next();
            return userMapper.extractFromResultSet(rs);
        } catch (SQLException e) {
            throw new DAOException();
        }

    }

    @Override
    public UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String searchUserLogin,
                                                                    String searchUserName, String searchUserSurname, String searchUserEmail) {
        UserService.PaginationResult paginationResult = new UserService.PaginationResult();

        UserMapper userMapper = new UserMapper();
        List<User> users = new ArrayList<>();

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
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHANGE_USER_ROLE_BY_ID_AND_NEW_ROLE_QUERY.getQUERY());
            ps.setString(1, newRole);
            ps.setString(2, userLogin);

            ps.execute();

        } catch (SQLException e) {
            //logger
        }
    }

    @Override
    public void changeUserActivityStatus(String userLogin, String newActivityStatus) {
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHANGE_USER_ACTIVITY_STATUS_QUERY.getQUERY());
            ps.setString(1, newActivityStatus);
            ps.setString(2, userLogin);

            ps.execute();

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

            rs.next();

            User user = new UserMapper().extractFromResultSet(rs);
            return user;

        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public boolean ifLoginExists(String login) {
        try (Connection conn = ConnectionPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(UserSQL.CHECK_LOGIN_EXISTS.getQUERY());
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
        }
        return false;
    }
}


