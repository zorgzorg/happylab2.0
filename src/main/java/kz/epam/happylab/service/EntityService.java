package kz.epam.happylab.service;

import kz.epam.happylab.dao.DAO;
import kz.epam.happylab.dao.DAOFactory;
import kz.epam.happylab.dao.EntityDAO;
import kz.epam.happylab.entity.Entity;
import kz.epam.happylab.entity.EntityFactory;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import static kz.epam.happylab.constant.Common.*;
import static kz.epam.happylab.constant.ExceptionMessage.*;

public class EntityService {
    private final static Logger logger = Logger.getLogger(EntityService.class);
    private String option;

    public EntityService(String option) {
        this.option = option;
    }

    public Entity getEntity(Connection connection, HttpServletRequest request, int recordId) {
        EntityDAO dao = new EntityDAO(connection, option);
        Entity entity = EntityFactory.createEntity(option);
        int filter = ParameterRequest.getParameter(request, FILTER);

        try {
            if(recordId == 0){
                Collection data = dao.findAll(filter);
                entity.setData(data);
            } else {
                entity = dao.findById(recordId);
            }
        } catch (SQLException e) {
            logger.error(EXCEPTION_FIND_RECORD, e);
        }

        FilterService.setFilters(connection, entity, filter, option, true);

        return entity;
    }

    public int updateEntity(Connection connection, HttpServletRequest request, String option){
        Entity record = initEntity(request);
        int recordId = ParameterRequest.getParameter(request, RECORD_ID);
        DAO dao = DAOFactory.createDAO(connection, option);

        try {
            if (recordId > ZERO) {
                dao.update(record);
            } else {
                recordId = dao.insert(record);
            }
        } catch (SQLException e) {
            logger.error(EXCEPTION_INSERT_RECORD, e);
        }

        return recordId;
    }

    public Entity initEntity(HttpServletRequest request) {
        Entity entity = EntityFactory.createEntity(option);
        entity = entity.init(request);
        return entity;
    }
}
