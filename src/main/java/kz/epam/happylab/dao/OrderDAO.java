package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Order;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.ORDER;
import static kz.epam.happylab.constant.Common.UPDATE;

/**
 * DAO for updating or inserting records into orders table
 */
public class OrderDAO implements DAO<Order> {
    private Connection connection;

    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Order order) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, ORDER), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, order);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Order order) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, ORDER));
        prepareStatement(stmt, order);
        stmt.setInt(5, order.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void prepareStatement(PreparedStatement stmt, Order order) throws SQLException {
        stmt.setString(1, order.getNumber());
        stmt.setInt(2, order.getCustomerId());
        stmt.setDate(3, (Date) order.getDate());
        stmt.setString(4, order.getRemark());
    }
}
