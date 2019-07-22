package model.dao.daoFactory;

import model.dao.impl.UserDAOImpl;

public interface AbstractFactory {
    //BookDAOImpl    createBookDAO();
    UserDAOImpl createUserDAO();
//    OrderDAOImpl   createOrderDAO();
//    ReaderDAOImpl  createReaderDAO();
//    ReportDAOImpl  createReportDAO();
}
