package ua.boring.project.utils;

import java.sql.Date;

/**
 * @author Rudenko Andrey
 * @project project
 */
public class DateUtils {

    public static Date getCurrentSqlDate() {
        java.util.Date utilDate = new java.util.Date();

        return new Date(utilDate.getTime());
    }

}
