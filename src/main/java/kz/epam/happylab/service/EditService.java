package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.entity.Entity;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

import static kz.epam.happylab.constant.Common.OPTION;
import static kz.epam.happylab.constant.Common.PROFILE;
import static kz.epam.happylab.constant.Common.RECORD_ID;

public class EditService {

    public Entity edit (HttpServletRequest request){
        Connection connection = ConnectionPool.getInstance().takeConnection();
        String option = request.getParameter(OPTION);
        Entity entity;
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);

        if(PROFILE.equalsIgnoreCase(option)) {
            UserService userService = new UserService();
            entity = userService.getUser(connection, userService.getUserId(request));
        } else {
            entity = new EntityService(option).getEntity(connection, request, recordId);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return entity;
    }
}
