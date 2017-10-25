package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.entity.User;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.BLOCK;
import static kz.epam.happylab.constant.Common.RECORD_ID;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_UPDATE_RECORD;

public class BlockService {
    private final static Logger logger = Logger.getLogger(BlockService.class);

    public void updateBlock(HttpServletRequest request) {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user = new User();
        user.setId(ParameterRequest.getParameter(request, RECORD_ID));
        user.setBlock(Integer.parseInt(request.getParameter(BLOCK).trim()));

        try {
            userDAO.updateBlock(user);
        } catch (SQLException e) {
            logger.error(EXCEPTION_UPDATE_RECORD, e);
        }

        ConnectionPool.getInstance().releaseConnection(connection);
    }
}
