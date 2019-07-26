package model.dao.daoFactory;

import model.dao.impl.*;

public class DAOFactory implements AbstractFactory {

//    @Override
//    public BookDAOImpl createBookDAO() {
//        return new BookDAOImpl();
//    }

    @Override
    public UserDAOImpl createUserDAO() {
        System.out.println("DAOFactory.java -> inside createUserDAO()");
        return new UserDAOImpl();
    }

//    @Override
//    public OrderDAOImpl createOrderDAO() {
//        return new OrderDAOImpl();
//    }
//
//    @Override
//    public ReaderDAOImpl createReaderDAO() {
//        return new ReaderDAOImpl();
//    }
//
//    @Override
//    public ReportDAOImpl createReportDAO() {
//        return new ReportDAOImpl();
//    }
}