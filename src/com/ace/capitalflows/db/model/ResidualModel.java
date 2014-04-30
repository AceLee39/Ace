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

import com.ace.capitalflows.entity.Residual;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class ResidualModel extends AbstractDaoModel{

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void batchInsert(final List items) {
        batchInsertResidual(items);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List findAll() {
        return findResiduals();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return findAllNianJd();
    }

    private void batchInsertResidual(final List<Residual> residuals) {
        Connection conn = null;
        PreparedStatement ps = null;
        final String sql = getbatchInsertSql();
        try {
            conn = getConn();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            for (final Residual residual : residuals) {
                ps.setString(1, residual.getNianJD());
                ps.setDouble(2, residual.getS());
                ps.setDouble(3, residual.getL1());
                ps.setDouble(4, residual.getL2());
                ps.setDouble(5, residual.getL3());
                ps.setDouble(6, residual.getL4());
                ps.setDouble(7, residual.getL5());
                ps.setDouble(8, residual.getL6());
                ps.setDouble(9, residual.getL7());
                ps.setDouble(10, residual.getL8());
                ps.setDouble(11, residual.getL9());
                ps.setDouble(12, residual.getL10());
                ps.setDouble(13, residual.getL11());
                ps.setDouble(14, residual.getL12());
                ps.setDouble(15, residual.getL13());
                ps.setDouble(16, residual.getL14());
                ps.setDouble(17, residual.getL15());
                ps.setDouble(18, residual.getL16());
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

    private Vector<String> findAllNianJd() {
        final Vector<String> allNianJd = new Vector<String>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT NIAN_JD FROM SOCF_RESIDUAL";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                allNianJd.add(rs.getString("NIAN_JD"));
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
        return allNianJd;
    }

    private List<Residual> findResiduals() {
        final List<Residual> residuals = new ArrayList<Residual>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_RESIDUAL";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final Residual residual = new Residual();
                residual.setId(rs.getInt("ID"));
                residual.setNianJD(rs.getString("NIAN_JD"));
                residual.setS(rs.getDouble("S"));
                residual.setL1(rs.getDouble("L1"));
                residual.setL2(rs.getDouble("L2"));
                residual.setL3(rs.getDouble("L3"));
                residual.setL4(rs.getDouble("L4"));
                residual.setL5(rs.getDouble("L5"));
                residual.setL6(rs.getDouble("L6"));
                residual.setL7(rs.getDouble("L7"));
                residual.setL8(rs.getDouble("L8"));
                residual.setL9(rs.getDouble("L9"));
                residual.setL10(rs.getDouble("L10"));
                residual.setL11(rs.getDouble("L11"));
                residual.setL12(rs.getDouble("L12"));
                residual.setL13(rs.getDouble("L13"));
                residual.setL14(rs.getDouble("L14"));
                residual.setL15(rs.getDouble("L15"));
                residual.setL16(rs.getDouble("L16"));
                residual.calculate();
                residuals.add(residual);
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
        return residuals;
    }



    @Override
    public void deleteAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            final String sql = "DELETE FROM SOCF_RESIDUAL WHERE NIAN_JD IS NOT NULL";
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
