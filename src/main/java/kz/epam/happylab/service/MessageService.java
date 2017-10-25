package kz.epam.happylab.service;

import static kz.epam.happylab.constant.Common.ZERO;
import static kz.epam.happylab.constant.Common.DELETE_SUCCESFUL;
import static kz.epam.happylab.constant.Common.DELETE_UNSUCCESFUL;

public class MessageService {

    public static String getDeleteMessage(int i) {
        String message;

        if(i>ZERO){
            message = DELETE_SUCCESFUL;
        } else {
            message = DELETE_UNSUCCESFUL;
        }

        return message;
    }

}
