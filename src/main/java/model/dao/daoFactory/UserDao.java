package model.dao.daoFactory;

import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

public interface UserDao extends GenericDao {
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
    //List<User> findAllUsers() throws DAOException, SQLException;
    UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String search_user_login, String searchUserName,
                                                          String searchUserSurname, String searchUserEmail);
    //UserService.PaginationResult findAllUsersByPagination(int lowerBound, int upperBound);
    void changeUserRole(String userLogin, String newRole);
    void changeUserActivityStatus(String userLogin, String newActivityStatus);
}
