package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Probe;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.PROBE;
import static kz.epam.happylab.constant.Common.UPDATE;

/**
 * DAO for updating or inserting records into probes table
 */
public class ProbeDAO implements DAO<Probe> {
    private Connection connection;

    public ProbeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Probe probe) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, PROBE), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, probe);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Probe probe) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, PROBE));
        prepareStatement(stmt, probe);
        stmt.setInt(8, probe.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private PreparedStatement prepareStatement(PreparedStatement stmt, Probe probe) throws SQLException {
        stmt.setInt(1, probe.getOrderId());
        stmt.setInt(2, probe.getNumberLab());
        stmt.setInt(3, probe.getNumberCustomer());
        stmt.setDate(4, (Date) probe.getDateReceiving());
        stmt.setString(5, probe.getPointSampling());
        stmt.setDate(6, (Date) probe.getDateSampling());
        stmt.setString(7, probe.getRemark());

        return stmt;
    }
}
