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

import com.ace.capitalflows.entity.YDResidual;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class YDResidualModel extends AbstractDaoModel{

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#batchInsert(java.util.List)
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public void batchInsert(final List ydResiduals) {
        batchInsertYDResidual(ydResiduals);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#findAll()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List findAll() {
        return findYDResiduals();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#findComboBoxData()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return findAllNianYd();
    }

    protected void batchInsertYDResidual(final List<YDResidual> ydResiduals) {
        Connection conn = null;
        PreparedStatement ps = null;
        final String sql = getbatchInsertSql();
        try {
            conn = getConn();
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

    protected Vector<String> findAllNianYd() {
        final Vector<String> allNianYd = new Vector<String>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT NIAN_YD FROM SOCF_YD_RESIDUAL ORDER BY NIAN_YD";
            conn = getConn();
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

    protected List<YDResidual> findYDResiduals() {
        final List<YDResidual> ydResiduals = new ArrayList<YDResidual>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_YD_RESIDUAL ORDER BY NIAN_YD";
            conn = getConn();
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



    @Override
    public void deleteAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
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
