package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Entity;
import kz.epam.happylab.entity.EntityFactory;
import kz.epam.happylab.util.QueryGetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kz.epam.happylab.constant.Common.*;
/**
 * DAO for getting and deleting records from all tables
 */
public class EntityDAO {
    private String option;
    private Connection connection;

    public EntityDAO(Connection connection, String option) {
        this.connection = connection;
        this.option = option;
    }

    public int delete(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(DELETE, option));
        stmt.setInt(1, id);
        int i = stmt.executeUpdate();
        stmt.close();

        return i;
    }

    public List<Entity> findAll(int filter) throws SQLException{
        List<Entity> data = new ArrayList();
        Entity entity = EntityFactory.createEntity(option);
        PreparedStatement stmt;

        if(filter == ZERO){
            stmt = connection.prepareStatement(QueryGetter.getQuery(FINDALL, option));
        } else {
            stmt = connection.prepareStatement(QueryGetter.getQuery(FINDALL_FILTER, option));
            stmt.setInt(1, filter);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            entity = entity.init(rs);
            data.add(entity);
        }
        rs.close();
        stmt.close();

        return data;
    }

    public Entity findById(int id) throws SQLException {
        Entity entity = EntityFactory.createEntity(option);

        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FINDBYID, option));
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            entity = entity.init(rs);
        }

        rs.close();
        stmt.close();

        return entity;
    }
}
