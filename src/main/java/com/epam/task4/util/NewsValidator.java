package com.epam.task4.util;

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


}
