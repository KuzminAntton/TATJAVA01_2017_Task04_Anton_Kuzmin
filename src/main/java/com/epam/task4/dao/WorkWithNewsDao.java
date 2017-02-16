package com.epam.task4.dao;


import com.epam.task4.bean.News;
import com.epam.task4.dao.exception.DAOException;

import java.util.HashSet;

public interface WorkWithNewsDao {

    HashSet<News> searchNewsForFreeCriteria(String[] request) throws DAOException;

    HashSet<News> searchNewsByTitle(String title) throws DAOException;

    HashSet<News> searchNewsByCreator(String creator) throws DAOException;

    HashSet<News> searchNewsByCategory(String category) throws DAOException;

    HashSet<News> searchNewsByTitleAndCategory(String title, String category) throws DAOException;

    HashSet<News> searchNewsByCreatorAndCategory(String creator, String category) throws DAOException;

    HashSet<News> searchNewsByTitleAndCreator(String title, String creator) throws DAOException;


    News searchConcreteNews(News news) throws DAOException;


<<<<<<< HEAD
    void addItem(News news) throws DAOException;
=======
    void addItem(String request) throws DAOException;
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b

}
