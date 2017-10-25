package kz.epam.happylab.entity;

import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static kz.epam.happylab.constant.Common.*;

public class Order extends Entity{
    private String number;
    private int customerId;
    private String name;
    private Date date;
    private String remark;
    private int probesQuantity;

    public Order() {
    }

    @Override
    public Order init(HttpServletRequest request) {
        Order order = new Order();
        order.setId(ParameterRequest.getParameter(request, RECORD_ID));
        order.setCustomerId(ParameterRequest.getParameter(request, CUSTOMER_ID));
        order.setNumber(request.getParameter(NUMBER).trim());
        order.setDate(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE).trim())));
        order.setRemark(request.getParameter(REMARK).trim());

        return order;
    }

    @Override
    public Order init(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt(ID));
        order.setCustomerId(rs.getInt(CUSTOMER_ID));
        order.setName(rs.getString(NAME));
        order.setNumber(rs.getString(NUMBER));
        order.setProbesQuantity(rs.getInt(PROBES_QUANTITY));
        order.setDate(rs.getDate(DATE));
        order.setRemark(rs.getString(REMARK));

        return order;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getProbesQuantity() {
        return probesQuantity;
    }

    public void setProbesQuantity(int probesQuantity) {
        this.probesQuantity = probesQuantity;
    }

}
