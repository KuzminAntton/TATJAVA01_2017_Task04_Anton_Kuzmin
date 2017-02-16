package com.epam.task4.dao.database;


import java.util.Locale;
import java.util.ResourceBundle;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

<<<<<<< HEAD
    private ResourceBundle bundle = ResourceBundle.getBundle("db");
=======
    private ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.ENGLISH);
>>>>>>> 928a172da525de4ed9c409d06b8a3334992c4d1b

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
