package com.epam.task4.controller.commands.search_news;

import com.epam.task4.bean.News;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.NewsService;
import com.epam.task4.service.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;


public class GetNewsFreeCriteria implements Command {
    @Override
    public String execute(String request) throws ServiceException {

        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsService newsService = serviceFactory.getNewsService();

        if(newsService.getNewsFreeCriteria(request).isEmpty()) {
            System.out.println("News not found, please check your criteria.");
        } else {
            for(News news : newsService.getNewsFreeCriteria(request)) {
                System.out.println(news);
            }
        }

        response = "News that I could find";
        return response ;
    }
}
