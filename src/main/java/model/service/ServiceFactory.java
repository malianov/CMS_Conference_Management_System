package model.service;

public class ServiceFactory {

    private static volatile ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    serviceFactory = new ServiceFactory();
                }
            }
        }
        return serviceFactory;
    }

    public UserService getUserService() {
        return new UserService();
    }

//    public ConferenceService getUserService() {
//        return new ConferenceService();
//    }
//
//    public SeminarService getUserService() {
//        return new SeminarService();
//    }
//
//    public StatisticsService getStatisticsService() {
//        return new StatisticService();
//    }
}
