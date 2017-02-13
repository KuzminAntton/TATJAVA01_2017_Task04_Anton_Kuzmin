package com.epam.task4.service;

import com.epam.task4.bean.News;
import com.epam.task4.service.exception.ServiceException;

import java.util.HashSet;

public interface ServiceNews {
    public void addNews(String request) throws ServiceException;

    HashSet<News> getNewsByTitle(String title) throws ServiceException;

    HashSet<News> getNewsByCreator(String creator) throws ServiceException;

    HashSet<News> getNewsByCategory(String category) throws ServiceException;

    HashSet<News> getNewsByTitleAndCategory(String title, String category) throws ServiceException;

    HashSet<News> getNewsByCreatorAndCategory(String creator, String category) throws ServiceException;

    HashSet<News> getNewsByTitleAndCreator(String title, String creator) throws ServiceException;

    HashSet<News> getNewsFreeCriteria(String request) throws ServiceException;

}
