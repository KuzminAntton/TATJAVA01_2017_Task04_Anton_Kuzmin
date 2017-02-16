package com.epam.task4.service.factory;


import com.epam.task4.service.impl.NewsImplService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final NewsImplService newsServiceImpl = new NewsImplService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public NewsImplService getNewsServiceImpl() {
        return newsServiceImpl;
    }
}
