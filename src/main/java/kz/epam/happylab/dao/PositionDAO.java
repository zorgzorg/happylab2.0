package kz.epam.happylab.dao;

import kz.epam.happylab.entity.Position;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.INSERT;
import static kz.epam.happylab.constant.Common.POSITION;
import static kz.epam.happylab.constant.Common.UPDATE;

/**
 * DAO for updating or inserting records into positions table
 */
public class PositionDAO implements DAO<Position> {
    private Connection connection;

    public PositionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(Position position) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, POSITION), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, position);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(Position position) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, POSITION));
        prepareStatement(stmt, position);
        stmt.setInt(3, position.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void prepareStatement(PreparedStatement stmt, Position position) throws SQLException {
        stmt.setString(1, position.getPosition());
        stmt.setString(2, position.getRemark());
    }
}
