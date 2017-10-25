package kz.epam.happylab.entity;

import kz.epam.happylab.util.DateFormatter;
import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static kz.epam.happylab.constant.Common.*;

public class User extends Entity{
    private String name;
    private String username;
    private String email;
    private String password;
    private String usertype;
    private Date dateRegistration;
    private int block;
    private String remark;

    public User() {
    }

    @Override
    public User init(HttpServletRequest request) {
        User user = new User();
        user.setId(ParameterRequest.getParameter(request, RECORD_ID));
        user.setName(request.getParameter(NAME).trim());
        user.setUsername(request.getParameter(USERNAME).trim());
        user.setEmail(request.getParameter(EMAIL).trim());
        user.setPassword(request.getParameter(PASSWORD).trim());

        if(request.getParameter(DATE_REGISTRATION)!= null) {
            user.setDateRegistration(java.sql.Date.valueOf(DateFormatter.formatDate(request.getParameter(DATE_REGISTRATION).trim())));
        }
        if(request.getParameter(USERTYPE)!= null) {
            user.setUsertype(request.getParameter(USERTYPE).trim());
        }
        if(request.getParameter(BLOCK)!= null) {
            user.setBlock(Integer.parseInt(request.getParameter(BLOCK).trim()));
        }
        if(request.getParameter(REMARK)!= null) {
            user.setRemark(request.getParameter(REMARK).trim());
        }

        return user;
    }

    @Override
    public User init(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt(ID));
        user.setName(rs.getString(NAME));
        user.setUsername(rs.getString(USERNAME));
        user.setEmail(rs.getString(EMAIL));
        user.setPassword(rs.getString(PASSWORD));
        user.setUsertype(rs.getString(USERTYPE));
        user.setDateRegistration(rs.getDate(DATE_REGISTRATION));
        user.setBlock(rs.getInt(BLOCK));
        user.setRemark(rs.getString(REMARK));

        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
