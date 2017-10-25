package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Entity;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

import static kz.epam.happylab.constant.Common.OPTION;
import static kz.epam.happylab.constant.Common.PROFILE;

public class ApplyService {

    public Entity apply(HttpServletRequest request){
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String option = request.getParameter(OPTION);
        Entity entity;

        if(PROFILE.equalsIgnoreCase(option)){
            UserService userService = new UserService();
            entity = userService.getUser(connection, userService.updateUser(connection, request));
        } else {
            EntityService entityService = new EntityService(option);
            int newRecordId = entityService.updateEntity(connection, request, option);
            entity = entityService.getEntity(connection, request, newRecordId);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return entity;
    }

}
