package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Entity;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

import static kz.epam.happylab.constant.Common.OPTION;
import static kz.epam.happylab.constant.Common.PROFILE;

public class ShowService {
    private final static Logger logger = Logger.getLogger(ShowService.class);

    public Entity show(HttpServletRequest request){
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String option = request.getParameter(OPTION);
        Entity entity;

        if(PROFILE.equalsIgnoreCase(option)) {
            UserService userService = new UserService();
            entity = userService.getUser(connection, userService.getUserId(request));
        } else {
            entity = new EntityService(option).getEntity(connection, request, 0);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return entity;
    }
}
