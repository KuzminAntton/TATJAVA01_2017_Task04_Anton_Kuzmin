package com.epam.task4.controller.commands.impl.news_commands.add_news;

import com.epam.task4.bean.News;
import org.apache.log4j.Logger;
import com.epam.task4.controller.commands.Command;
import com.epam.task4.service.impl.NewsServiceImpl;
import com.epam.task4.service.factory.ServiceFactory;
import com.epam.task4.service.exception.ServiceException;

public class AddNews implements Command {
    private static final Logger log = Logger.getLogger(AddNews.class);

    @Override
    public String execute(String request) {
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        NewsServiceImpl newsServiceImpl = serviceFactory.getNewsServiceImpl();

        String[] parameters = request.split(",");

        String title = parameters[0];
        String creator = parameters[1];
        String category = parameters[2];

        News news = new News(title,creator,category);

        try{
                newsServiceImpl.addNews(news);
            } catch (ServiceException e) {
            log.error(e);
                System.out.println(e.getMessage());
            }


        response = "News has been added successful.";

        return response;
    }
}
