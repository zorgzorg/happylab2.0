package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_FIND_RECORD;

public class LoginService {
    private final static Logger logger = Logger.getLogger(LoginService.class);

    public String login(HttpServletRequest request) {
        User user = null;

        try {
            user = findUserByLogin(request);
        } catch (SQLException e) {
            logger.error(EXCEPTION_FIND_RECORD, e);
        }

        return getView(user, request, LOGIN_PATH);
    }

    private User findUserByLogin(HttpServletRequest request) throws SQLException {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        UserDAO userDAO = new UserDAO(connection);
        User user = userDAO.findByLogin(request.getParameter(USERNAME), request.getParameter(PASSWORD));
        ConnectionPool.getInstance().releaseConnection(connection);

        return user;
    }

    private String getView(User user, HttpServletRequest request, String view){
        if (user.getId() != 0) {
            if(user.getBlock() == 0) {
                setSessionAttributeRequest(request, USER, user);
                setSessionAttributeRequest(request, DATA, user);
                view = BASE_PATH + PROFILE + FORM_LAYOUT;
            } else {
                setAttributeRequest(request, MESSAGE, BLOCKED_USER);
            }
        } else {
            setAttributeRequest(request, MESSAGE, UNKNOWN_USER);
        }

        return view;
    }

    private void setAttributeRequest(HttpServletRequest request, String key, Object attribute){
        request.setAttribute(key, attribute);
    }

    private void setSessionAttributeRequest(HttpServletRequest request, String key, Object attribute){
        request.getSession().setAttribute(key, attribute);
    }
}
