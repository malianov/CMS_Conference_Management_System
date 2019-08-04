package model.dao.daoFactory;

import model.entity.User;
import model.exception.DAOException;
import model.service.UserService;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends GenericDao {
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
    //List<User> findAllUsers() throws DAOException, SQLException;
    UserService.PaginationResult findSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String search_user_login, String searchUserName,
                                                          String searchUserSurname, String searchUserEmail, String searchAdministrator, String searchModerator, String searchSpeaker,
                                                          String searchParticipant, String searchActive, String searchDeactivated);
    //UserService.PaginationResult findAllUsersByPagination(int lowerBound, int upperBound);
}
