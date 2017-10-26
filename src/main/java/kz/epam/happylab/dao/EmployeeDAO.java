package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Employee;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.*;

/**
 * DAO for updating or inserting records into employees table
 */
public class EmployeeDAO implements DAO<Employee> {    
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        if(employee.getSignature() == -1){
            deleteSignature();
        }
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, EMPLOYEE), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, employee);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Employee employee) throws SQLException {
        if(employee.getSignature() == -1){
            deleteSignature();
        }
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, EMPLOYEE));
        prepareStatement(stmt, employee);
        stmt.setInt(8, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void prepareStatement(PreparedStatement stmt, Employee employee) throws SQLException {
        stmt.setString(1, employee.getLastname());
        stmt.setString(2, employee.getName());
        stmt.setString(3, employee.getSurname());
        stmt.setInt(4, employee.getPositionId());
        stmt.setInt(5, employee.getAssistant());
        stmt.setInt(6, employee.getSignature());
        stmt.setString(7, employee.getRemark());
    }

    public void updateAssistant(Employee employee) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE_ASSISTANT, EMPLOYEE));
        stmt.setInt(1, employee.getAssistant());
        stmt.setInt(2, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void deleteSignature() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(DELETE_SIGNATURE, EMPLOYEE));
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateSignature(Employee employee) throws SQLException {
        deleteSignature();
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE_SIGNATURE, EMPLOYEE));
        stmt.setInt(1, employee.getSignature());
        stmt.setInt(2, employee.getId());
        stmt.executeUpdate();
        stmt.close();
    }
}
