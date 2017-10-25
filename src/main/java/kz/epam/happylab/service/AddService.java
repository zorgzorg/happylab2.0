package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Entity;
import kz.epam.happylab.entity.EntityFactory;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.Date;

import static kz.epam.happylab.constant.Common.*;

public class AddService {

    public Entity add(HttpServletRequest request){
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String option = request.getParameter(OPTION);
        Entity entity;

        if(PROFILE.equalsIgnoreCase(option)) {
            UserService userService = new UserService();
            entity = userService.getUser(connection, userService.getUserId(request));
        } else {
            entity = EntityFactory.createEntity(option);
            int filter = ParameterRequest.getParameter(request, FILTER);
            entity.setId(ZERO);

            if (!CUSTOMER.equalsIgnoreCase(option) || !EMPLOYEE.equalsIgnoreCase(option) || !POSITION.equalsIgnoreCase(option)) {
                entity.setDate(new Date());
            }

            FilterService.setFilters(connection, entity, filter, option, true);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return entity;
    }
}
