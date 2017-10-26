package kz.epam.happylab.dao;

import kz.epam.happylab.action.ActionFactory;
import kz.epam.happylab.enumtype.DAOType;
import org.apache.log4j.Logger;

import java.sql.Connection;

import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_WRONG_OPTION;

public class DAOFactory {
    private final static Logger logger = Logger.getLogger(ActionFactory.class);

    public static DAO createDAO(Connection connection, String option){
        DAO dao = new UserDAO(connection);

        if(option == null || option.isEmpty()){
            return dao;
        }

        try {
            DAOType daoType = DAOType.valueOf(option.toUpperCase());
            dao = daoType.create(connection);
        } catch (IllegalArgumentException e) {
            logger.error(EXCEPTION_WRONG_OPTION, e);
        }

        return dao;
    }
}
