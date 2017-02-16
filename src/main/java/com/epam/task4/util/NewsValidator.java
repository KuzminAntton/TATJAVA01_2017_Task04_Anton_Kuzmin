package com.epam.task4.util;

<<<<<<< HEAD
=======

>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
import com.epam.task4.bean.News;

public final class NewsValidator {
    /**
     * Check that news is correct.
     * news correct if news look like : 'Category,Title,Creator'
     *
     * @param news
     * @return true if news is correct.
     */
    public static boolean newsValidateBySize(String news) {
        boolean res = false;
        if(news.split(",").length == 3) {
            res = true;
        }
        return res;
    }

<<<<<<< HEAD

=======
>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
    public static boolean newsValidateNotNull(String title) {
        boolean res = true;
        if(title.isEmpty()) {
            res = false;
        }
        return res;
    }


    public static boolean newsValidateNotNull(String title, String creator) {

        boolean res = true;
        if(title.isEmpty() || creator.isEmpty()) {
            res = false;
        }
        return res;

    }


    public static boolean newsValidateNotNull(String title, String creator, String category) {

        boolean res = true;
        if(title.isEmpty() || category.isEmpty() || creator.isEmpty()) {
            res = false;
        }
        return res;
    }
    public static boolean newsValidateNotNull(News news) {

        boolean res = true;
        if(news.getName().isEmpty() || news.getCreator().isEmpty() || news.getCategory().isEmpty())   {
            res = false;
        }
        return res;


    }





}
