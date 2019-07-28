package model.dao.daoFactory;

import model.entity.User;
import model.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List<User> findAllUsers() throws DAOException, SQLException;
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
}
