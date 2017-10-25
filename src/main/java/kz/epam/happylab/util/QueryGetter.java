package kz.epam.happylab.util;

import java.util.ResourceBundle;

import static kz.epam.happylab.constant.Common.SQL_DIR;

public class QueryGetter {
    public static String getQuery(String type, String option){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(SQL_DIR+option);
        return resourceBundle.getString(type);
    }
}
