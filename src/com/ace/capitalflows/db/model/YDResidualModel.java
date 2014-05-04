// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.entity.YDResidual;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class YDResidualModel {


    public static void batchInsertYDResidual(final List<YDResidual> ydResiduals) {
        Connection conn = null;
        PreparedStatement ps = null;
        final String sql = "INSERT INTO SOCF_YD_RESIDUAL(ID,NIAN_YD,S,FDI,FBT) " +
                "VALUES(null,?,?,?,?)";
        try {
            conn = DaoFactory.getInstance().getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (final YDResidual ydResidual : ydResiduals) {
                ps.setString(1, ydResidual.getNianYD());
                ps.setDouble(2, ydResidual.getS());
                ps.setDouble(3, ydResidual.getFdi());
                ps.setDouble(4, ydResidual.getFbt());
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (final SQLException e) {
            try {
                conn.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<String> findAllNianYd() {
        final Vector<String> allNianYd = new Vector<String>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT NIAN_YD FROM SOCF_YD_RESIDUAL";
            conn = DaoFactory.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                allNianYd.add(rs.getString("NIAN_YD"));
            }
        } catch (final SQLException e) {
            try {
                conn.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closeRs(rs);
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return allNianYd;
    }

    public static List<YDResidual> findYDResiduals() {
        final List<YDResidual> ydResiduals = new ArrayList<YDResidual>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_YD_RESIDUAL";
            conn = DaoFactory.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final YDResidual ydResidual = new YDResidual();
                ydResidual.setId(rs.getInt("ID"));
                ydResidual.setNianYD(rs.getString("NIAN_YD"));
                ydResidual.setS(rs.getDouble("S"));
                ydResidual.setFdi(rs.getDouble("FDI"));
                ydResidual.setFbt(rs.getDouble("FBT"));
                ydResidual.calculate();
                ydResiduals.add(ydResidual);
            }
        } catch (final SQLException e) {
            try {
                conn.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closeRs(rs);
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
        return ydResiduals;
    }



    public static void deleteAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DaoFactory.getInstance().getConn();
            final String sql = "DELETE FROM SOCF_YD_RESIDUAL WHERE NIAN_YD IS NOT NULL";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (final SQLException e) {
            try {
                conn.rollback();
            } catch (final SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closePs(ps);
                DBUtils.closeConn(conn);
            } catch (final SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
