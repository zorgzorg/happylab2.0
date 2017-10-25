package kz.epam.happylab.dao;

import java.sql.SQLException;

public interface DAO <T> {
    int insert(T t) throws SQLException;
    void update(T t) throws SQLException;
}
