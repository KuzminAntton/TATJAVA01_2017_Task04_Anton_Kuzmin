package com.epam.task4.dao.database;

import com.epam.task4.bean.News;
import com.epam.task4.dao.WorkWithNewsDao;
import com.epam.task4.dao.exception.ConnectionPoolException;
import com.epam.task4.dao.exception.DAOException;
import com.mysql.jdbc.PreparedStatement;
<<<<<<< HEAD
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class DBWorker implements WorkWithNewsDao {

<<<<<<< HEAD
    private static final Logger log = LogManager.getRootLogger();

=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
    private ConnectionPool pool = new ConnectionPool();
    private String sqlSearchByFreeCriteriaInquiry = "SELECT * FROM news";
    private String sqlSearchByConcreteCriteriaInquiry = "SELECT * FROM news where ";
    private String sqlAddCommand = "INSERT INTO news(title,creator,category) VALUES(?,?,?)";

    private String titleRowName = "title";
    private String creatorRowName = "creator";
    private String categoryRowName = "category";

    public void init() throws DAOException {
        try {
            pool.initPollData();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }
    }

    public void destroy() {
        pool.dispose();
    }

    @Override
    public HashSet<News> searchNewsForFreeCriteria(String[] request) throws DAOException {

        HashSet<News> news = new HashSet<>();

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {

            con = pool.takeConnection();

            preparedStatement = (PreparedStatement) con.prepareStatement(sqlSearchByFreeCriteriaInquiry);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String creator = rs.getString(creatorRowName);
                String title = rs.getString(titleRowName);
                String category = rs.getString(categoryRowName);
                for (String searchParameter : request) {
                    if (creator.toLowerCase().equals(searchParameter) ||
                            title.toLowerCase().equals(searchParameter) ||
                            category.toLowerCase().equals(searchParameter)) {
                        news.add(new News(title, creator, category));
                    }
                }

            }

        } catch (SQLException | ConnectionPoolException e) {
<<<<<<< HEAD
            log.error(e);
=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            throw new DAOException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

            try {
                con.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

        }

        return news;
    }

    @Override
    public HashSet<News> searchNewsByTitle(String title) throws DAOException {
        HashSet<News> news;

        news = addNewsFromConcreteColumnInHashSet(titleRowName, title);

        return news;
    }

    @Override
    public HashSet<News> searchNewsByCreator(String creator) throws DAOException {
        HashSet<News> news;

        news = addNewsFromConcreteColumnInHashSet(creatorRowName, creator);

        return news;
    }

    @Override
    public HashSet<News> searchNewsByCategory(String category) throws DAOException {
        HashSet<News> news;

        news = addNewsFromConcreteColumnInHashSet(categoryRowName, category);

        return news;
    }

    @Override
    public HashSet<News> searchNewsByTitleAndCategory(String title, String category) throws DAOException {
        HashSet<News> news = new HashSet<>();

        news.addAll(addNewsFromConcreteColumnInHashSet(titleRowName, title));
        news.addAll(addNewsFromConcreteColumnInHashSet(categoryRowName, category));

        return news;
    }

    @Override
    public HashSet<News> searchNewsByCreatorAndCategory(String creator, String category) throws DAOException {
        HashSet<News> news = new HashSet<>();

        news.addAll(addNewsFromConcreteColumnInHashSet(creatorRowName, creator));
        news.addAll(addNewsFromConcreteColumnInHashSet(categoryRowName, category));

        return news;
    }

    @Override
    public HashSet<News> searchNewsByTitleAndCreator(String title, String creator) throws DAOException {
        HashSet<News> news = new HashSet<>();

        news.addAll(addNewsFromConcreteColumnInHashSet(titleRowName, title));
        news.addAll(addNewsFromConcreteColumnInHashSet(creatorRowName, creator));

        return news;
    }

    @Override
    public News searchConcreteNews(News news) throws DAOException {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {

            con = pool.takeConnection();

            preparedStatement = (PreparedStatement) con.prepareStatement(sqlSearchByFreeCriteriaInquiry);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String title = rs.getString(titleRowName);
                String creator = rs.getString(creatorRowName);
                String category = rs.getString(categoryRowName);
                if (news.equals(new News(title, creator, category))) {
                    return news;
                }

            }

        } catch (SQLException | ConnectionPoolException e) {
<<<<<<< HEAD
            log.error(e);
=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            throw new DAOException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

            try {
                con.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

        }

        return null;
    }


    @Override
<<<<<<< HEAD
    public void addItem(News news) throws DAOException {
        Connection con = null;
        PreparedStatement preparedStatement = null;

=======
    public void addItem(String request) throws DAOException {
        Connection con = null;
        //ResultSet rs = null;
        PreparedStatement preparedStatement = null;


        String[] parameters = request.split(",");


>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
        try {

            con = pool.takeConnection();

            preparedStatement = (PreparedStatement) con.prepareStatement(sqlAddCommand);

<<<<<<< HEAD
            preparedStatement.setString(1, news.getName());
            preparedStatement.setString(2, news.getCreator());
            preparedStatement.setString(3, news.getCategory());
=======
            preparedStatement.setString(1, parameters[0]);
            preparedStatement.setString(2, parameters[1]);
            preparedStatement.setString(3, parameters[2]);
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b

            preparedStatement.executeUpdate();

        } catch (SQLException | ConnectionPoolException e) {
<<<<<<< HEAD
            log.error(e);
=======

>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            throw new DAOException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

            try {
                con.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

        }

    }

    private HashSet<News> addNewsFromConcreteColumnInHashSet(String columnName, String criteria) throws DAOException {

        HashSet<News> news = new HashSet<>();

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;

        try {

            con = pool.takeConnection();

            preparedStatement = (PreparedStatement) con.prepareStatement(sqlSearchByConcreteCriteriaInquiry + columnName + " = " + "'" + criteria + "'");

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String titleFromDB = rs.getString(titleRowName);
                String creatorFromDB = rs.getString(creatorRowName);
                String categoryFromDB = rs.getString(categoryRowName);
                news.add(new News(titleFromDB, creatorFromDB, categoryFromDB));
            }


        } catch (SQLException | ConnectionPoolException e) {
<<<<<<< HEAD
           log.error(e);
=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            throw new DAOException(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

            try {
                con.close();
            } catch (SQLException e) {
<<<<<<< HEAD
                log.error(e);
=======
                e.printStackTrace();
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
            }

        }
        return news;
    }

<<<<<<< HEAD
=======
//    private HashSet<News> addNewsFromConcreteColumnInHashSet(String firstColumnName, String secondColumnName, String sirstCriteria , String secondCriteria) throws DAOException {
//
//    }
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b

}
