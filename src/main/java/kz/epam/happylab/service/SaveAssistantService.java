package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.ASSISTANT;
import static kz.epam.happylab.constant.Common.RECORD_ID;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_UPDATE_RECORD;

public class SaveAssistantService {
    private final static Logger logger = Logger.getLogger(SaveAssistantService.class);

    public void updateAssistant(HttpServletRequest request) {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        Employee employee = new Employee();
        employee.setId(ParameterRequest.getParameter(request, RECORD_ID));
        employee.setAssistant(Integer.parseInt(request.getParameter(ASSISTANT).trim()));

        try {
            employeeDAO.updateAssistant(employee);
        } catch (SQLException e) {
            logger.error(EXCEPTION_UPDATE_RECORD, e);
        }

        ConnectionPool.getInstance().releaseConnection(connection);
    }
}
