package kz.epam.happylab.entity;

import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;

public class Customer extends Entity{
    private String name;
    private String city;
    private String remark;

    public Customer() {
    }

    @Override
    public Customer init(HttpServletRequest request) {
        Customer customer = new Customer();
        customer.setId(ParameterRequest.getParameter(request, RECORD_ID));
        customer.setName(request.getParameter(NAME).trim());
        customer.setCity(request.getParameter(CITY).trim());
        customer.setRemark(request.getParameter(REMARK).trim());

        return customer;
    }

    @Override
    public Customer init(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt(ID));
        customer.setName(rs.getString(NAME));
        customer.setCity(rs.getString(CITY));
        customer.setRemark(rs.getString(REMARK));

        return customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
