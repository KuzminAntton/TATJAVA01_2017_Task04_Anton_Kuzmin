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

public class NewsServiceImpl implements NewsService {

    public void initResource() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        DBWorker dbWorker = daoFactory.getDbWorker();
        try {
            dbWorker.init();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void destroyResource()
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
            }else {
                throw new ServiceException("can't add news");
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

            if(NewsValidator.newsValidateNotNull(title)) {
                return dbWorker.searchNewsByTitle(title);
            }else {
                throw new ServiceException("can't find news by title");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreator(String creator) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            if(NewsValidator.newsValidateNotNull(creator)) {
                return dbWorker.searchNewsByCreator(creator);
            }else {
                throw new ServiceException("can't find news by creator");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCategory(String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();

            if(NewsValidator.newsValidateNotNull(category)) {
                return dbWorker.searchNewsByCategory(category);
            }else {
                throw new ServiceException("can't find news by category");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCategory(String title, String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            if(NewsValidator.newsValidateNotNull(title,category)) {
                return dbWorker.searchNewsByTitleAndCategory(title, category);
            }else {
                throw new ServiceException("can't find news by title and category");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByCreatorAndCategory(String creator, String category) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            if(NewsValidator.newsValidateNotNull(creator,category)) {
                return dbWorker.searchNewsByCreatorAndCategory(creator, category);
            }else {
                throw new ServiceException("can't find news by creator and category");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public HashSet<News> getNewsByTitleAndCreator(String title, String creator) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DBWorker dbWorker = daoFactory.getDbWorker();


            if(NewsValidator.newsValidateNotNull(title,creator)) {
                return dbWorker.searchNewsByTitleAndCreator(title, creator);
            }else {
                throw new ServiceException("can't find news by title and category");
            }


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


            if(NewsValidator.newsValidateNotNull(request)) {
                return dbWorker.searchNewsForFreeCriteria(parametersForTheSearch);
            }else {
                throw new ServiceException("can't find news by free criteria");
            }





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

            String title = parametersForTheSearch[0];
            String creator = parametersForTheSearch[1];
            String category = parametersForTheSearch[2];

            if(NewsValidator.newsValidateNotNull(request)) {
                News news = new News(title, creator, category);
                return dbWorker.searchConcreteNews(news);
            }else {
                throw new ServiceException("can't find concrete  news ");
            }


        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

}
