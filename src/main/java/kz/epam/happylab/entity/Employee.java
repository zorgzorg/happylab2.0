package kz.epam.happylab.entity;

import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;

public class Employee extends Entity {
    private String lastname;
    private String name;
    private String surname;
    private int positionId;
    private String position;
    private int assistant;
    private int signature;
    private String remark;

    public Employee() {
    }

    @Override
    public Employee init(HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setId(ParameterRequest.getParameter(request, RECORD_ID));
        employee.setLastname(request.getParameter(LASTNAME).trim());
        employee.setName(request.getParameter(NAME).trim());
        employee.setSurname(request.getParameter(SURNAME).trim());
        employee.setPositionId(ParameterRequest.getParameter(request, POSITION_ID));
        employee.setAssistant(Integer.parseInt(request.getParameter(ASSISTANT).trim()));
        employee.setSignature(Integer.parseInt(request.getParameter(SIGNATURE).trim()));
        employee.setRemark(request.getParameter(REMARK).trim());

        return employee;
    }

    @Override
    public Employee init(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt(ID));
        employee.setLastname(rs.getString(LASTNAME));
        employee.setName(rs.getString(NAME));
        employee.setSurname(rs.getString(SURNAME));
        employee.setPositionId(rs.getInt(POSITION_ID));
        employee.setPosition(rs.getString(POSITION));
        employee.setAssistant(rs.getInt(ASSISTANT));
        employee.setSignature(rs.getInt(SIGNATURE));
        employee.setRemark(rs.getString(REMARK));

        return employee;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAssistant() {
        return assistant;
    }

    public void setAssistant(int assistant) {
        this.assistant = assistant;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
