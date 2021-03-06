package model.dao.daoFactory;

import model.dao.impl.JdbcDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;
    public abstract UserDao createUserDao();
    public abstract ConferenceDao createConferenceDao();
    public abstract SeminarDao createSeminarDao();

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