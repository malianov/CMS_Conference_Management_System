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

//    public BookService getBookService() {
//        return new BookService();
//    }
//
//    public OrderService getOrderService() {
//        return new OrderService();
//    }
//
//    public ReaderService getReaderService() {
//        return new ReaderService();
//    }
//
//    public ReportService getReportService() {
//        return new ReportService();
//    }
}
