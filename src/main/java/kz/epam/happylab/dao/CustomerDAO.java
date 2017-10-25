package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Customer;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.CUSTOMER;
import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.UPDATE;

/**
 * DAO for updating or inserting records into customers table
 */
public class CustomerDAO implements DAO<Customer> {
    private Connection connection;

    public CustomerDAO() {
    }

    public CustomerDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Customer customer) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, CUSTOMER), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, customer);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Customer customer) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, CUSTOMER));
        prepareStatement(stmt, customer);
        stmt.setInt(4, customer.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private PreparedStatement prepareStatement(PreparedStatement stmt, Customer customer) throws SQLException {
        stmt.setString(1, customer.getName());
        stmt.setString(2, customer.getCity());
        stmt.setString(3, customer.getRemark());

        return stmt;
    }
}
