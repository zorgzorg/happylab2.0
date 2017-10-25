package kz.epam.happylab.entity;

import kz.epam.happylab.util.ParameterRequest;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;

public class Position extends Entity{
    private String position;
    private String remark;

    public Position() {
    }

    @Override
    public Position init(HttpServletRequest request) {
        Position position = new Position();
        position.setId(ParameterRequest.getParameter(request, RECORD_ID));
        position.setPosition(request.getParameter(POSITION).trim());
        position.setRemark(request.getParameter(REMARK).trim());

        return position;
    }

    @Override
    public Position init(ResultSet rs) throws SQLException {
        Position position = new Position();
        position.setId(rs.getInt(ID));
        position.setPosition(rs.getString(POSITION));
        position.setRemark(rs.getString(REMARK));

        return position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
