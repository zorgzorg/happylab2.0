package kz.epam.happylab.entity;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class Entity {
    private int id;
    private Date date;
    private Collection data;
    private int filter;
    private Collection filterList;

    public Entity() {
    }

    public Entity init (HttpServletRequest request){
        return new Entity();
    }
    public Entity init (ResultSet rs) throws SQLException {
        return new Entity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection getData() {
        return data;
    }

    public void setData(Collection data) {
        this.data = data;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public Collection getFilterList() {
        return filterList;
    }

    public void setFilterList(Collection filterList) {
        this.filterList = filterList;
    }
}
