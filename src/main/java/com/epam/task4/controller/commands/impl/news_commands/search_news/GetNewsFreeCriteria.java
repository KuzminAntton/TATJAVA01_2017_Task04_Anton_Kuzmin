package com.epam.task4.controller.commands.impl.news_commands.search_news;

import com.epam.task4.bean.News;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;
import org.apache.log4j.Logger;


public class GetNewsFreeCriteria implements Command {

    @Override
    public String execute(String request) throws ServiceException {

        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();

        if (newsServiceImpl.getNewsFreeCriteria(request).isEmpty()) {
            System.out.println("News not found, please check your criteria.");
        } else {
            for (News news : newsServiceImpl.getNewsFreeCriteria(request)) {
                System.out.println(news);
            }
        }

        response = "News that I could find";
        return response;
    }
}
