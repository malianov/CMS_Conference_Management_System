package model.dao.impl;

import connection.ConnectionPool;
import model.dao.daoFactory.UserDao;
import model.dao.impl.queries.UserSQL;
import model.dao.mapper.UserMapper;
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
                    user.setId_user(rs.getLong("u_id"));
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
                    user.setId_user(rs.getInt("u_id"));
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

//    @Override
//    public UserService.PaginationResult findAllUsersByPagination(int offset, int noOfRows, long id_user) {
//        return null;
//    }

    @Override
    public UserService.PaginationResult findAllUsersByPagination(int lowerBound, int upperBound) {

        UserService.PaginationResult paginationResult = new UserService.PaginationResult();

        Map<Long, User> users = new HashMap<>();
        UserMapper userMapper = new UserMapper();

        try (Connection conn = ConnectionPool.getConnection();
            PreparedStatement usersPS = conn.prepareStatement(UserSQL.GET_USERS_BY_PAGINATION.getQUERY());
            PreparedStatement countRowsPS = conn.prepareStatement(UserSQL.CALC_USERS_BY_WHOLE.getQUERY())) {
            usersPS.setInt(1, lowerBound);
            usersPS.setInt(2, upperBound);

            ResultSet rs = usersPS.executeQuery();
            while (rs.next()) {
                User user = userMapper.extractFromResultSet(rs);
            }
            rs.close();

            rs = countRowsPS.executeQuery();
            if (rs.next()) {
                paginationResult.setNoOfRows(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
           // logger.fatal("Caught SQLException exception", e);
            e.printStackTrace();
        }
        paginationResult.setResultList(new ArrayList<>(users.values()));
        return paginationResult;
    }

}
