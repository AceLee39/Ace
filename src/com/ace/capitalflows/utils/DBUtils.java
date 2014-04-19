// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Administrator
 *
 */
public class DBUtils {

    public static void closeConn(final Connection conn) throws SQLException {
        if (null != conn) {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }

    public static void closePs(final PreparedStatement ps) throws SQLException {
        if (null != ps) {
            if (!ps.isClosed()) {
                ps.close();
            }
        }
    }


    public static void closeRs(final ResultSet rs) throws SQLException {
        if (null != rs) {
            if (!rs.isClosed()) {
                rs.close();
            }
        }
    }


}
