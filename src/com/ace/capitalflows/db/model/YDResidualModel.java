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
import java.util.Map;
import java.util.Vector;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.MonthScale;
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
    @Override
    public void batchInsert(final Map<String, Object> result) {
        runTransaction(result);
    }


    @SuppressWarnings({"unchecked"})
    @Override
    protected void executer(final Connection conn, final Map<String, Object> result) throws SQLException {
        if (result != null) {
            final List<YDResidual> dataList = (List<YDResidual>) result.get(Constant.PTY_YD_RESIDUALS);
            batchInsertYDResidual(conn, dataList);
            batchInsertMonthScale(conn, dataList);
        } else {
            deleteYDResidual(conn);
            deleteMonthScale(conn);
        }
    }



    /**
     * @param conn
     * @throws SQLException
     */
    private void deleteMonthScale(final Connection conn) throws SQLException {
        final String sql = "DELETE FROM SOCF_MONTH_SCALE  WHERE NIAN_YD IS NOT NULL";
        final PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }


    /**
     * @param conn
     * @throws SQLException
     */
    private void deleteYDResidual(final Connection conn) throws SQLException {
        final String sql = "DELETE FROM SOCF_YD_RESIDUAL WHERE NIAN_YD IS NOT NULL";
        final PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
    }


    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#findAll()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List findScaleAll() {
        return findMonthScale();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#findComboBoxData()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return findAllNianYd();
    }

    protected void batchInsertMonthScale(final Connection conn, final List<YDResidual> ydResiduals) throws SQLException {
        PreparedStatement ps = null;
        final String sql = getBatchInsertSqlforMonthScale();
        ps = conn.prepareStatement(sql);
        for (final YDResidual ydResidual : ydResiduals) {
            ps.setString(1, ydResidual.getNianYD());
            ps.setString(2, ydResidual.getYdResidual());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    /**
     * @return
     */
    protected String getBatchInsertSqlforMonthScale() {
        return null;
    }


    protected void batchInsertYDResidual(final Connection conn, final List<YDResidual> ydResiduals) throws SQLException {
        PreparedStatement ps = null;
        final String sql = getbatchInsertSql();
        ps = conn.prepareStatement(sql);
        for (final YDResidual ydResidual : ydResiduals) {
            ps.setString(1, ydResidual.getNianYD());
            ps.setDouble(2, ydResidual.getS());
            ps.setDouble(3, ydResidual.getFdi());
            ps.setDouble(4, ydResidual.getFbt());
            ps.addBatch();
        }
        ps.executeBatch();
    }

    protected Vector<String> findAllNianYd() {
        final Vector<String> allNianYd = new Vector<String>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT NIAN_YD FROM SOCF_MONTH_SCALE ORDER BY NIAN_YD";
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

    protected List<MonthScale> findMonthScale() {
        final List<MonthScale> monthScales = new ArrayList<MonthScale>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_MONTH_SCALE  ORDER BY NIAN_YD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                final MonthScale monthScale = new MonthScale();
                monthScale.setId(rs.getInt("ID"));
                monthScale.setNianYD(rs.getString("NIAN_YD"));
                monthScale.setYdResidual(rs.getString("YD_RESIDUAL"));
                monthScales.add(monthScale);
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
        return monthScales;
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
        runTransaction(null);
    }


    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#findDataAll()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List findDataAll() {
        return findYDResiduals();
    }
}
