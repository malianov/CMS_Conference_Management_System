package model.dao.impl;

import model.dao.daoFactory.*;

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
}
