package model.dao.daoFactory;

import model.entity.Seminar;
import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

import java.util.List;

public interface UserDao extends AutoCloseable {
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
    UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String search_user_login, String searchUserName,
    String searchUserSurname, String searchUserEmail);
    void changeUserRole(String userLogin, String newRole);
    void changeUserActivityStatus(String userLogin, String newActivityStatus);
    User findByLogin(String login) throws DAOException;
    boolean ifLoginExists(String login);
}
