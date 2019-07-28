package model.dao.daoFactory;

import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
    List<User> findAllUsers() throws DAOException, SQLException;
    UserService.PaginationResult findAllUsersByPagination(int lowerBound, int upperBound);
}
