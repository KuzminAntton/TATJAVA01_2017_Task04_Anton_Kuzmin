package com.epam.task4.util;

import com.epam.task4.controller.commands.CommandName;

public final class Help {
    private static String wrongInput = "Please use only supported commands : \n" +
            CommandName.ADD_NEWS + "\n" +
            CommandName.GET_CONCRETE_NEWS + "\n" +
            CommandName.GET_NEWS_FREE_CRIT + "\n" +
            CommandName.EXIT + "\n" +
            "Add news request must look like : ADD_NEWS-Name,Creator,Category" + "\n" +
<<<<<<< HEAD
=======

            "Add news request must look like : ADD_NEWS-Category,Name,Creator" + "\n" +
>>>>>>> af063971f98d9a349628d7125e4110bee5d21714
            "Search news request must look like : " + "\n" +
            "get_news_free_crit-tag1...tagN (punctuation is not important)" + "\n" +
            "get_concrete_news-Category,Name,Creator" + "\n" +
            "exit- : if you want to go away(don't forget about '-' after command)";

    public static String getWrongInput() {
        return wrongInput;
    }
}
