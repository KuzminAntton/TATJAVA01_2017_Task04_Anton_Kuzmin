package com.epam.task4.controller.commands.impl.news_commands.search_news;

import com.epam.task4.bean.News;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;

import java.io.IOException;

public class GetNewsByCreatorAndCategory implements Command {
    @Override
    public String execute(String request) throws IOException, ServiceException {
        String response = null;

        String[] parameters = request.split(",");

        String creator = parameters[0];
        String category = parameters[1];

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();

        try {
            for (News news : newsServiceImpl.getNewsByCreatorAndCategory(creator, category)) {
                System.out.println(news);
            }

        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        response = "News that I could find";

        return response;
    }
}
