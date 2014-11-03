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

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.db.OracleDaoFactory;


/**
 * @author Administrator
 *
 */
public class DBUtils {

    public static String getAttributeByKey(final String key) {
        String value = StringUtils.EMPTY;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "select value from SOCF_ATTRIBUTE WHERE ATTR_KEY = ?";
            if (StringUtils.equals(PropertiesUtil.getString("DBMODE"), "mysql")) {
                conn = DaoFactory.getInstance().getConn();
            } else {
                conn = OracleDaoFactory.getInstance().getConn();
            }
            ps = conn.prepareStatement(sql);
            ps.setString(0, key);
            rs = ps.executeQuery();
            if (rs != null) {
                rs.next();
                value = rs.getString("attr_value");
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, ps, rs);
        }
        return value;
    }

    public static void updateAttributeValue(final String key, final String value) {
        final String sql = "update SOCF_ATTRIBUTE set attr_value=? where key=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            if (StringUtils.equals(PropertiesUtil.getString("DBMODE"), "mysql")) {
                conn = DaoFactory.getInstance().getConn();
            } else {
                conn = OracleDaoFactory.getInstance().getConn();
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (final SQLException e) {
            rollback(conn);
            System.out.println("fail to update attribute key = " + key + ", value = " + value
                    + ", e : " + e.getMessage());
        } finally {
            closeAll(conn, ps, null);
        }
    }


    public static void rollback(final Connection conn) {
        try {
            if (null != conn && !conn.isClosed()) {
                conn.rollback();
            }
        } catch (final SQLException e) {
            System.out.println("conn rollback");
            e.printStackTrace();
        }
    }

    public static void closeAll (final Connection conn, final PreparedStatement ps, final ResultSet rs) {
        try {
            closeRs(rs);
            closePs(ps);
            closeConn(conn);
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }


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
