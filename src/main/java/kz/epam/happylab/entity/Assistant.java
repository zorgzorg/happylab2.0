package kz.epam.happylab.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import static kz.epam.happylab.constant.Common.*;

public class Assistant extends Entity {
    private String lastname;

    @Override
    public Assistant init(ResultSet rs) throws SQLException {
        Assistant assistant = new Assistant();
        assistant.setId(rs.getInt(ID));
        assistant.setLastname(rs.getString(LASTNAME));

        return assistant;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
