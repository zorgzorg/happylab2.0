package kz.epam.happylab.enumtype;

import kz.epam.happylab.dao.*;

import java.sql.Connection;

public enum DAOType {
    CUSTOMER{
        public DAO create(Connection connection) { return new CustomerDAO(connection); }
    },
    ORDER {
        public DAO create(Connection connection) {
            return new OrderDAO(connection);
        }
    },
    PROBE{
        public DAO create(Connection connection) {
            return new ProbeDAO(connection);
        }
    },
    AES{
        public DAO create(Connection connection) {
            return new AESDAO(connection);
        }
    },
    SSA{
        public DAO create(Connection connection) {
            return new SSADAO(connection);
        }
    },
    SANPIN{
        public DAO create(Connection connection) { return new SanpinDAO(connection); }
    },
    EMPLOYEE{
        public DAO create(Connection connection) {
            return new EmployeeDAO(connection);
        }
    },
    POSITION{
        public DAO create(Connection connection) { return new PositionDAO(connection); }
    },
    USER{
        public DAO create(Connection connection) {
            return new UserDAO(connection);
        }
    };

    public DAO create(Connection connection){
        return new UserDAO(connection);
    }
}

