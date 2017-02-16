package com.epam.task4.controller.commands.impl.news_commands.search_news;

import com.epam.task4.bean.News;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;
import org.apache.log4j.Logger;

import java.io.IOException;

public class GetNewsByCreator implements Command {

    private static final Logger log = Logger.getLogger(GetNewsByCreator.class);

    @Override
    public String execute(String request) throws IOException, ServiceException {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();

        try {
            for (News news : newsServiceImpl.getNewsByCreator(request)) {
                System.out.println(news);
            }

        } catch (ServiceException e) {
            log.error(e);
            System.out.println(e.getMessage());
        }


        response = "News that I could find";
        return response;
    }
}
