package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.EntityDAO;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_DELETE_RECORD;

public class DeleteService {
    private final static Logger logger = Logger.getLogger(DeleteService.class);

    public int delete(HttpServletRequest request){
        Connection connection =  ConnectionPool.getInstance().takeConnection();
        EntityDAO dao = new EntityDAO(connection, request.getParameter(OPTION));
        int i = ZERO;

        try {
            i = dao.delete(ParameterRequest.getParameter(request, RECORD_ID));
        } catch (SQLException e) {
            logger.error(EXCEPTION_DELETE_RECORD, e);
        }

        ConnectionPool.getInstance().releaseConnection(connection);

        return i;
    }
}
