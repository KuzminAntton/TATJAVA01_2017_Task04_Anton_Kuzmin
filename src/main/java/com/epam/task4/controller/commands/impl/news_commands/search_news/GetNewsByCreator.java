package com.epam.task4.controller.commands.impl.news_commands.search_news;

import com.epam.task4.bean.News;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.impl.NewsImplService;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;

import java.io.IOException;

public class GetNewsByCreator implements Command {
    @Override
    public String execute(String request) throws IOException, ServiceException {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsImplService newsServiceImpl = serviceFactory.getNewsServiceImpl();

        try {
            for (News news : newsServiceImpl.getNewsByCreator(request)) {
                System.out.println(news);
            }

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }


        response = "News that I could find";
        return response;
    }
}
