package com.epam.task4.service;


public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final NewsService newsService = new NewsService();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public NewsService getNewsService() {
        return newsService;
    }
}
