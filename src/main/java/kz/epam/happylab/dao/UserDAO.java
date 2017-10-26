package kz.epam.happylab.dao;

import kz.epam.happylab.entity.User;
import kz.epam.happylab.util.QueryGetter;

import java.sql.*;

import static kz.epam.happylab.constant.Common.*;
/**
 * DAO for getting, updating or inserting records from users table
 */
public class UserDAO implements DAO<User> {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int insert(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(INSERT, USER), Statement.RETURN_GENERATED_KEYS);
        prepareStatement(stmt, user);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        int lastId = keys.getInt(1);
        stmt.close();

        return lastId;
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE, USER));
        prepareStatement(stmt, user);
        stmt.setInt(9, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    private void prepareStatement(PreparedStatement stmt, User user) throws SQLException {
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getUsertype());
        stmt.setDate(6, (Date) user.getDateRegistration());
        stmt.setInt(7, user.getBlock());
        stmt.setString(8, user.getRemark());
    }

    public void updateProfile(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(UPDATE_PROFILE, USER));
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getUsername());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setInt(5, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public void updateBlock(User user) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(BLOCK, USER));
        stmt.setInt(1, user.getBlock());
        stmt.setInt(2, user.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    public User findById(int id) throws SQLException {
        User user = new User();

        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FINDBYID, USER));
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            user = new User().init(rs);
        }

        rs.close();
        stmt.close();

        return user;
    }


    public User findByLogin(String login, String password) throws SQLException {
        User user = new User();

        PreparedStatement stmt = connection.prepareStatement(QueryGetter.getQuery(FINDBYLOGIN, USER));
        stmt.setString(1, login);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            user = new User().init(rs);
        }

        rs.close();
        stmt.close();

        return user;
    }
}
