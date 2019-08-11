package model.service;

import model.dao.daoFactory.DaoFactory;
import model.entity.User;
import model.exception.DAOException;
import model.exception.ServiceException;
import model.validation.Validation;

import java.util.List;

public class UserService {
    private DaoFactory daoFactory;

    public UserService() {
        daoFactory = DaoFactory.getInstance();
    }

    public User login(String login) throws DAOException {
        return daoFactory.createUserDao().findByLogin(login);
    }

    public boolean ifLoginExists(String login) {
        if (Validation.isStringValid(login)) {
            return daoFactory.createUserDao().ifLoginExists(login);
        } else {
            return false;
        }
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return daoFactory.createUserDao().findUserByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public PaginationResult getSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String search_user_login, String searchUserName, String searchUserSurname, String searchUserEmail) {

        return daoFactory.createUserDao().findSearchUsersByPagination(lowerBound, upperBound, searchUserId, search_user_login, searchUserName,
                searchUserSurname, searchUserEmail);
    }

    public void changeUserRole(String userLogin, String newRole) throws ServiceException {
        daoFactory.createUserDao().changeUserRole(userLogin, newRole);
    }

    public void changeUserAcivityStatus(String userLogin, String newAcivityStatus) {
        daoFactory.createUserDao().changeUserActivityStatus(userLogin, newAcivityStatus);
    }

    public static class PaginationResult {
        private int noOfRows;
        private List<User> usersList;

        public int getNoOfRows() {
            return noOfRows;
        }

        public void setNoOfRows(int noOfRows) {
            this.noOfRows = noOfRows;
        }

        public List<User> getUsersList() {
            return usersList;
        }

        public void setUsersList(List<User> resultList) {
            this.usersList = resultList;
        }
    }
}
