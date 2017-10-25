package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Entity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

import static kz.epam.happylab.constant.Common.OPTION;
import static kz.epam.happylab.constant.Common.PROFILE;

public class SaveService {

    public Entity save(HttpServletRequest request){
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String option = request.getParameter(OPTION);
        Entity entity;

        if(PROFILE.equalsIgnoreCase(option)){
            UserService userService = new UserService();
            userService.updateUser(connection, request);
            entity = userService.getUser(connection, userService.getUserId(request));
        } else {
            new EntityService(option).updateEntity(connection, request, option);
            entity = new ShowService().show(request);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return entity;
    }
}
