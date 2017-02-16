package com.epam.task4.util;

<<<<<<< HEAD
import com.epam.task4.bean.News;

=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
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





=======
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b
}
