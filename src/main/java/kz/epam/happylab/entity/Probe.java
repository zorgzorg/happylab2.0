package kz.epam.happylab.entity;

import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static kz.epam.happylab.constant.Common.*;

public class Probe extends Entity {
    private int orderId;
    private int number;
    private int numberLab;
    private int numberCustomer;
    private Date dateReceiving;
    private String name;
    private String pointSampling;
    private Date dateSampling;
    private String remark;

    public Probe() {
    }

    @Override
    public Probe init(HttpServletRequest request) {
        Probe probe = new Probe();
        probe.setId(ParameterRequest.getParameter(request, RECORD_ID));
        probe.setOrderId(ParameterRequest.getParameter(request, ORDER_ID));
        probe.setNumberLab(Integer.parseInt(request.getParameter(NUMBER_LAB).trim()));
        probe.setNumberCustomer(Integer.parseInt(request.getParameter(NUMBER_CUSTOMER).trim()));
        probe.setDateReceiving(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_RECEIVING).trim())));
        probe.setPointSampling(request.getParameter(POINT_SAMPLING).trim());
        probe.setDateSampling(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_SAMPLING).trim())));
        probe.setRemark(request.getParameter(REMARK).trim());

        return probe;
    }

    @Override
    public Probe init (ResultSet rs) throws SQLException {
        Probe probe = new Probe();
        probe.setId(rs.getInt(ID));
        probe.setOrderId(rs.getInt(ORDER_ID));
        probe.setNumber(rs.getInt(NUMBER));
        probe.setNumberLab(rs.getInt(NUMBER_LAB));
        probe.setNumberCustomer(rs.getInt(NUMBER_CUSTOMER));
        probe.setDateReceiving(rs.getDate(DATE_RECEIVING));
        probe.setName(rs.getString(NAME));
        probe.setPointSampling(rs.getString(POINT_SAMPLING));
        probe.setDateSampling(rs.getDate(DATE_SAMPLING));
        probe.setRemark(rs.getString(REMARK));

        return probe;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberLab() {
        return numberLab;
    }

    public void setNumberLab(int numberLab) {
        this.numberLab = numberLab;
    }

    public int getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(int numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public Date getDateReceiving() {
        return dateReceiving;
    }

    public void setDateReceiving(Date dateReceiving) {
        this.dateReceiving = dateReceiving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPointSampling() {
        return pointSampling;
    }

    public void setPointSampling(String pointSampling) {
        this.pointSampling = pointSampling;
    }

    public Date getDateSampling() {
        return dateSampling;
    }

    public void setDateSampling(Date dateSampling) {
        this.dateSampling = dateSampling;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
