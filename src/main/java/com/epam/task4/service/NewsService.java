package com.epam.task4.service;

<<<<<<< HEAD
=======

>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
import com.epam.task4.bean.News;
import com.epam.task4.service.exception.ServiceException;

import java.util.HashSet;

public interface NewsService {
    public void addNews(News news) throws ServiceException;

    HashSet<News> getNewsByTitle(String title) throws ServiceException;

    HashSet<News> getNewsByCreator(String creator) throws ServiceException;

    HashSet<News> getNewsByCategory(String category) throws ServiceException;

    HashSet<News> getNewsByTitleAndCategory(String title, String category) throws ServiceException;

    HashSet<News> getNewsByCreatorAndCategory(String creator, String category) throws ServiceException;

    HashSet<News> getNewsByTitleAndCreator(String title, String creator) throws ServiceException;

    HashSet<News> getNewsFreeCriteria(String request) throws ServiceException;
<<<<<<< HEAD
=======


import com.epam.task4.bean.News;
import com.epam.task4.dao.DAOFactory;
import com.epam.task4.dao.database.DBWorker;
import com.epam.task4.dao.exception.DAOException;
import com.epam.task4.service.exception.ServiceException;
import com.epam.task4.util.RequestWorker;

import java.util.HashSet;

public class NewsService implements ServiceNews {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private DBWorker dbWorker = daoFactory.getDbWorker();

    public void init() throws ServiceException {
        try {
            dbWorker.init();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void destroy() {
        dbWorker.destroy();
    }

    /**
     * Take news from controller and give it to DAO layer.
     *
     * @param request string with news.
     * @throws ServiceException catch exception and throw it on service level.
     */
    @Override
    public void addNews(String request) throws ServiceException {
        try {
            dbWorker.addItem(request);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public HashSet<News> getNewsByTitle(String title) throws ServiceException {
        try {
            return dbWorker.searchNewsByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreator(String creator) throws ServiceException {
        try {
            return dbWorker.searchNewsByCreator(creator);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCategory(String category) throws ServiceException {
        try {
            return dbWorker.searchNewsByCategory(category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCategory(String title, String category) throws ServiceException {
        try {
            return dbWorker.searchNewsByTitleAndCategory(title, category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreatorAndCategory(String creator, String category) throws ServiceException {
        try {
            return dbWorker.searchNewsByCreatorAndCategory(creator, category);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCreator(String title, String creator) throws ServiceException {
        try {
            return
                    dbWorker.searchNewsByTitleAndCreator(title, creator);
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
            String[] parametersForTheSearch;
            parametersForTheSearch = RequestWorker.getSearchParametersInRequest(request);

            return dbWorker.searchNewsForFreeCriteria(parametersForTheSearch);

        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public News getConcreteNews(String request) throws ServiceException {

        try {
            String[] parametersForTheSearch;
            parametersForTheSearch = request.split(",");

            News news = new News(parametersForTheSearch[0], parametersForTheSearch[1], parametersForTheSearch[2]);

            return dbWorker.searchConcreteNews(news);


        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }
>>>>>>> af063971f98d9a349628d7125e4110bee5d21714

}
