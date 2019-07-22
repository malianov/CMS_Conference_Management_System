package model.dao.daoFactory;

import model.entity.User;
import model.exception.DAOException;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    //User findUserByLogin(String login) throws DAOException;


//    List<User> findAllUsers() throws DAOException, SQLException;
//    void registerUser(User User) throws DAOException;
//    void makeUserInactiveByLogin(String login) throws DAOException;
//    void makeUserActiveByLogin(String login) throws DAOException;
//    void makeUserAsGeneralByLogin(String login) throws DAOException;
//    void makeUserAsNotGeneralByLogin(String login) throws DAOException;
    User findUserByLoginAndPassword(String login, String password) throws DAOException;
}
