package model.dao.impl;

import model.dao.daoFactory.*;

public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JdbcUserDAOImpl();
    }

    @Override
    public ConferenceDao createConferenceDao() {
        return null;
    }

//    @Override
//    public ConferenceDao createConferenceDao() {
//        return new JdbcConferenceDAOImpl();
//    }
//
//    @Override
//    public SeminarDao createSeminarDao() {
//        return new JdbcSeminarDaoImpl();
//    }
//
//    @Override
//    public StatisticsDao createStatisticsDao() {
//        return new JdbcStatisticsDaoImpl();
//    }
}
