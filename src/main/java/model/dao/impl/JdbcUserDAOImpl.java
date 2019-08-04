package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.UserDao;
import model.dao.impl.queries.UserSQL;
import model.dao.mapper.UserMapper;
import model.dao.utility.FindQueryGenerator;
import model.entity.Role;
import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUserDAOImpl implements UserDao {
    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        System.out.println("JdbcUserDAOImpl.java -> inside findUserByLoginAndPassword");

        UserMapper userMapper = new UserMapper();
        User user = new User();

        try (Connection conn = ConnectionPool.getConnection()) {
            System.out.println("UserDAOImpl.java -> inside findUserByLoginAndPassword = inside try");
            PreparedStatement ps = conn.prepareStatement(UserSQL.FIND_USER_BY_LOGIN_AND_PASSWORD_QUERY.getQUERY());
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("JdbcUserDAOImpl.java -> inside findUserByLoginAndPassword = after ResultSet rs = ps.executeQuery();");

            if (rs.next()) {
                user = userMapper.extractFromResultSet(rs);
            } else {
                //logger
            }
        } catch (SQLException e) {
            //logger
        }
        System.out.println("JdbcUserDaoImpl.java -> user - " + user);
        return user;
    }

    @Override
    public UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String searchUserLogin,
                                                                    String searchUserName, String searchUserSurname, String searchUserEmail) {

        UserService.PaginationResult paginationResult = new UserService.PaginationResult();

        UserMapper userMapper = new UserMapper();
        List<User> users = new ArrayList<>();

        System.out.println("-_-_-_-_-_ users - " + users);
        FindQueryGenerator qg = new FindQueryGenerator();
        String findUsersByCriteriaRequests = String.valueOf(qg.findUsersByCriteriaRequests(searchUserId, searchUserLogin,
                searchUserName, searchUserSurname, searchUserEmail))  + "LIMIT ?, ?;";

        PreparedStatement usersPS = null;
        try(Connection conn = ConnectionPool.getConnection()) {
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
}
