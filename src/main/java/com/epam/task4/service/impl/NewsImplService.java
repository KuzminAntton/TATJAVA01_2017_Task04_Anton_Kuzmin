package com.epam.task4.service.impl;


import com.epam.task4.bean.News;
import com.epam.task4.dao.factory.DAOFactory;
import com.epam.task4.dao.database.DBWorker;
import com.epam.task4.dao.exception.DAOException;
import com.epam.task4.service.NewsService;
import com.epam.task4.service.exception.ServiceException;
import com.epam.task4.util.NewsValidator;
import com.epam.task4.util.RequestWorker;

import java.util.HashSet;

public class NewsImplService implements NewsService {



    public void init() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DBWorker dbWorker = daoFactory.getDbWorker();
        try {
            dbWorker.init();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void destroy()
    {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DBWorker dbWorker = daoFactory.getDbWorker();

        dbWorker.destroy();
    }

    /**
     * Take news from controller and give it to DAO layer.
     *
     * @param news
     * @throws ServiceException catch exception and throw it on service level.
     */
    @Override
    public void addNews(News news) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            if(NewsValidator.newsValidateNotNull(news)) {
                dbWorker.addItem(news);
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public HashSet<News> getNewsByTitle(String title) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreator(String creator) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByCreator(creator);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCategory(String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByCategory(category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCategory(String title, String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByTitleAndCategory(title, category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreatorAndCategory(String creator, String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByCreatorAndCategory(creator, category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCreator(String title, String creator) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            return dbWorker.searchNewsByTitleAndCreator(title, creator);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Return news from DAO layer to controller.
     *
     * @param request criterion for finding news.
     * @return list of news.
     * @throws ServiceException
     */

    @Override
    public HashSet<News> getNewsFreeCriteria(String request) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            String[] parametersForTheSearch;
            parametersForTheSearch = RequestWorker.getSearchParametersInRequest(request);

            return dbWorker.searchNewsForFreeCriteria(parametersForTheSearch);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public News getConcreteNews(String request) throws ServiceException {

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            String[] parametersForTheSearch;
            parametersForTheSearch = request.split(",");

            News news = new News(parametersForTheSearch[0], parametersForTheSearch[1], parametersForTheSearch[2]);

            return dbWorker.searchConcreteNews(news);


        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

}
