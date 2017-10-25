package kz.epam.happylab.util;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_PARSE_DATE;
import static kz.epam.happylab.constant.Common.*;

public class DateFormatter {
    private final static Logger logger = Logger.getLogger(DateFormatter.class);


    public static String formatDate(String date)
    {
        String pattern = RU_FORMAT_DATE;
        String reformattedStr = "";

        if(date.contains("/")){
            pattern = EN_FORMAT_DATE;
        }

        SimpleDateFormat fromUser = new SimpleDateFormat(pattern);
        SimpleDateFormat dbFormat = new SimpleDateFormat(DB_FORMAT_DATE);

        try {
            reformattedStr = dbFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
            logger.error(EXCEPTION_PARSE_DATE, e);
        }

        return reformattedStr;
    }

}
