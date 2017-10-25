package kz.epam.happylab.service;

import kz.epam.happylab.dao.UserDAO;
import kz.epam.happylab.entity.User;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.*;

public class UserService {
    private final static Logger logger = Logger.getLogger(UserService.class);

    public UserService() {
    }

    public User getUser(Connection connection, int userId) {
        UserDAO userDAO = new UserDAO(connection);
        User user = new User();

        try {
            user = userDAO.findById(userId);
        } catch (SQLException e) {
            logger.error(EXCEPTION_FIND_RECORD, e);
        }
        return user;
    }

    public int updateUser(Connection connection, HttpServletRequest request) {
        UserDAO dao = new UserDAO(connection);
        User user = new User().init(request);
        int userId = getUserId(request);
        user.setId(userId);

        try {
            dao.updateProfile(user);
        } catch (SQLException e) {
            logger.error(EXCEPTION_INSERT_RECORD, e);
        }

        return userId;
    }

    public int getUserId(HttpServletRequest request) {
        int userId = ZERO;

        if (request.getSession().getAttribute(USER) != null) {
            User user = (User) request.getSession().getAttribute(USER);
            userId = user.getId();
        }

        return userId;
    }
}
