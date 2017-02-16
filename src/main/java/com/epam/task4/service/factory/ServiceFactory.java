package com.epam.task4.service.factory;


import com.epam.task4.service.impl.NewsServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final NewsServiceImpl newsServiceImpl = new NewsServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public NewsServiceImpl getNewsServiceImpl() {
        return newsServiceImpl;
    }
}
