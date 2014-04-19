// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ace.capitalflows.utils.PropertiesUtil;

/**
 * @author Administrator
 *
 */
public class DaoFactory {
    private static ThreadLocal<Connection> localConn = new ThreadLocal<Connection>();

    static {
        try {
            Class.forName(PropertiesUtil.getDBInstance().getString("DRIVER"));
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private DaoFactory() {
    }

    public Connection getConn() throws SQLException {
        Connection conn = localConn.get();
        if(null == conn || conn.isClosed()) {
            conn = DriverManager.getConnection(PropertiesUtil.getDBInstance().getString("URL"),
                    PropertiesUtil.getDBInstance().getString("USERNAME"),
                    PropertiesUtil.getDBInstance().getString("PASSWORD"));
            localConn.set(conn);
        }
        return conn;
    }

    private static class DaoFactoryInstance {
        private static DaoFactory instance = new DaoFactory();
    }

    public static DaoFactory getInstance() {
        return DaoFactoryInstance.instance;
    }

    public static void main(final String[] args) throws SQLException {

        System.out.println(DaoFactory.getInstance().getConn());
    }

}
