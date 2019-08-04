package model.service;

import model.dao.daoFactory.DaoFactory;
import model.dao.daoFactory.UserDao;
import model.entity.User;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private DaoFactory daoFactory;

    public UserService() {
        daoFactory = DaoFactory.getInstance();
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        try {
            return daoFactory.createUserDao().findUserByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public PaginationResult getSearchUsersByPagination(int lowerBound, int upperBound, String searchUserId, String search_user_login, String searchUserName, String searchUserSurname, String searchUserEmail) {

        System.out.println("UserService.java =>> inside getSearchUsersByPagination");
        return daoFactory.createUserDao().findSearchUsersByPagination(lowerBound, upperBound, searchUserId, search_user_login, searchUserName,
                searchUserSurname, searchUserEmail);
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
