package kz.epam.happylab.service;

import kz.epam.happylab.connection.ConnectionPool;
import kz.epam.happylab.dao.EmployeeDAO;
import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.util.ParameterRequest;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.RECORD_ID;
import static kz.epam.happylab.constant.Common.SIGNATURE;
import static kz.epam.happylab.constant.ExceptionMessage.EXCEPTION_UPDATE_RECORD;

public class SaveSignatureService {
    private final static Logger logger = Logger.getLogger(SaveSignatureService.class);

    public void updateSignature(HttpServletRequest request) {
        Connection connection = ConnectionPool.getInstance().takeConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO(connection);
        Employee employee = new Employee();
        employee.setId(ParameterRequest.getParameter(request, RECORD_ID));
        employee.setSignature(Integer.parseInt(request.getParameter(SIGNATURE).trim()));

        try {
            employeeDAO.updateSignature(employee);
        } catch (SQLException e) {
            logger.error(EXCEPTION_UPDATE_RECORD, e);
        }

        ConnectionPool.getInstance().releaseConnection(connection);
    }
}
