package com.epam.task4.controller.commands.search_news;

import com.epam.task4.controller.commands.Command;
import com.epam.task4.util.Help;
import com.epam.task4.util.NewsValidator;
import com.epam.task4.service.NewsService;
import com.epam.task4.service.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;

public class GetConcreteNews implements Command {
    public String execute(String request) {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        request = request.replaceAll(" ", "");

        if (NewsValidator.newsValidateBySize(request)) {
            try {
                System.out.println(newsService.getConcreteNews(request));
            } catch (ServiceException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(Help.getWrongInput());
        }

        response = "News that I could find";

        return response;
    }
}
