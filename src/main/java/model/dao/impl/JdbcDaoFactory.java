package model.dao.impl;

import model.dao.daoFactory.*;
import model.service.ConferenceService;

public class JdbcDaoFactory extends DaoFactory {
    @Override
    public UserDao createUserDao() {
        return new JdbcUserDAOImpl();
    }

    @Override
    public ConferenceDao createConferenceDao() {
        return new JdbcConferenceDaoImpl();
    }

    @Override
    public SeminarDao createSeminarDao() {
        return new JdbcSeminarDaoImpl();
    }
//
//    @Override
//    public StatisticsDao createStatisticsDao() {
//        return new JdbcStatisticsDaoImpl();
//    }
}
