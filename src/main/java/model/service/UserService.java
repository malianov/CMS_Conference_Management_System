package model.service;

import model.dao.daoFactory.AbstractFactory;
import model.dao.daoFactory.DAOFactory;
import model.dao.daoFactory.IUserDAO;
import model.entity.User;
import model.exception.DAOException;
import model.exception.ServiceException;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private IUserDAO userDAO;

    public UserService() {
        System.out.println("UserService.java -> inside UserService()");
        AbstractFactory factory = new DAOFactory();
        userDAO = factory.createUserDAO();
    }

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

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {

        System.out.println("UserService.java -> inside findUserByLoginAndPassword");

        try {
            return userDAO.findUserByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<User> findAllUsers() throws ServiceException {
        try {
            return userDAO.findAllUsers();
        } catch (DAOException | SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

//    public void registerUser(User user) throws ServiceException {
//        try {
//            userDAO.registerUser(user);
//        } catch (DAOException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
}
