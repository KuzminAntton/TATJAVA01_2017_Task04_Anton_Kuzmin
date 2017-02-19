package com.epam.task4.controller.commands.impl.news_commands.search_news;

import com.epam.task4.controller.commands.Command;
import com.epam.task4.util.Help;
import com.epam.task4.util.NewsValidator;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;
import org.apache.log4j.Logger;

public class GetConcreteNews implements Command {

    private static final Logger log = Logger.getLogger(GetConcreteNews.class);

    public String execute(String request) {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();

        request = request.replaceAll(" ", "");

        if (NewsValidator.newsValidateBySize(request)) {
            try {
                System.out.println(newsServiceImpl.getConcreteNews(request));
            } catch (ServiceException e) {
                log.error(e);
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(Help.getWrongInput());
        }

        response = "News that I could find";

        return response;
    }
}
