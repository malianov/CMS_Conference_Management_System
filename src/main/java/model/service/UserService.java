package model.service;

import model.dao.daoFactory.DaoFactory;
import model.entity.User;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private DaoFactory daoFactory;

    public UserService() {
        System.out.println("UserService.java -> inside UserService()");
        daoFactory = DaoFactory.getInstance();
    }


    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        System.out.println("UserService.java -> inside findUserByLoginAndPassword");
        try {
            return daoFactory.createUserDao().findUserByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<User> findAllUsers() throws ServiceException {
        try {
            return daoFactory.createUserDao().findAllUsers();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }







//    public static class PaginationResult {
//        private int noOfRows;
//        private List<User> resultList;
//
//        public int getNoOfRecords() {
//            return noOfRows;
//        }
//
//        public void setNoOfRecords(int noOfRecords) {
//            this.noOfRows = noOfRows;
//        }
//
//        public List<User> getResultList() {
//            return resultList;
//        }
//
//        public void setResultList(List<User> resultList) {
//            this.resultList = resultList;
//        }
//    }

//    public PaginationResult getRowsByPagination(int lowerBound, int upperBound, long idUser) {
//        UserDao dao = daoFactory.createReportDao();
//        return dao.findByPagination(lowerBound, upperBound, idUser);
//    }

//    public void makeUserAsNotGeneralByLogin(String login) throws ServiceException {
//        try {
//            userDAO.makeUserAsNotGeneralByLogin(login);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
//
//    public void makeUserAsGeneralByLogin(String login) throws ServiceException {
//        try {
//            userDAO.makeUserAsGeneralByLogin(login);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
//
//    public void makeUserActiveByLogin(String login) throws ServiceException {
//        try {
//            userDAO.makeUserActiveByLogin(login);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
//
//    public void makeUserInactiveByLogin(String login) throws ServiceException {
//        try {
//            userDAO.makeUserInactiveByLogin(login);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }

//    public User findUserByLogin(String login) throws ServiceException {
//        try {
//            return userDAO.findUserByLogin(login);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }



//    public void registerUser(User user) throws ServiceException {
//        try {
//            userDAO.registerUser(user);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
}
