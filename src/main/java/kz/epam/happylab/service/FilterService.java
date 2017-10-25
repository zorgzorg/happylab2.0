package kz.epam.happylab.service;

import kz.epam.happylab.dao.EntityDAO;
import kz.epam.happylab.entity.Entity;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_FIND_RECORDS;

public class FilterService {
    private final static Logger logger = Logger.getLogger(FilterService.class);

    public static Collection getFilter(Connection connection, String option){
        EntityDAO dao = new EntityDAO(connection, option);
        Collection filter = new ArrayList();

        try {
            filter = dao.findAll(ZERO);
        } catch (SQLException e) {
            logger.error(EXCEPTION_FIND_RECORDS, e);
        }

        return filter;
    }

    public static void setFilters(Connection connection, Entity entity, int filter, String option, Boolean editMode) {
        if(editMode) {
            if(AES.equalsIgnoreCase(option)||SSA.equalsIgnoreCase(option)||SANPIN.equalsIgnoreCase(option)) {
                Collection filters = new ArrayList();
                filters.add(getFilter(connection, PROBE));
                filters.add(getFilter(connection, ASSISTANT));
                entity.setFilterList(filters);
                entity.setFilter(filter);
            }
            if(EMPLOYEE.equalsIgnoreCase(option)) {
                entity.setFilterList(getFilter(connection, POSITION));
            }
            if(USER.equalsIgnoreCase(option)) {
                entity.setFilterList(getFilter(connection, USERTYPE));
            }
        }
        if (ORDER.equalsIgnoreCase(option)) {
            entity.setFilterList(getFilter(connection, CUSTOMER));
            entity.setFilter(filter);
        }
        if (PROBE.equalsIgnoreCase(option)) {
            entity.setFilterList(FilterService.getFilter(connection, ORDER));
            entity.setFilter(filter);
        }
    }
}
