package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.ID;
import static kz.epam.happylab.constant.Common.USERTYPE;

public class Usertype extends Entity {
    private String usertype;

    @Override
    public Usertype init(ResultSet rs) throws SQLException {
        Usertype usertype = new Usertype();
        usertype.setId(rs.getInt(ID));
        usertype.setUsertype(rs.getString(USERTYPE));

        return usertype;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
