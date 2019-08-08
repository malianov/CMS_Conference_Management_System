package model.dao.daoFactory;

import model.dao.impl.JdbcDaoFactory;
import model.entity.Conference;
import model.service.ConferenceService;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract ConferenceDao createConferenceDao();
    public abstract SeminarDao createSeminarDao();
    //public abstract ConferenceDao changeDateDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JdbcDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}