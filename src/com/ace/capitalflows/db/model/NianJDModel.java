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
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.QuarterScale;
import com.ace.capitalflows.entity.Residual;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class NianJDModel extends AbstractDaoModel{

    @Override
    public List<Residual> findResiduals() {
        final List<Residual> residuals = new ArrayList<Residual>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_RESIDUAL WHERE IS_NIAN_JD=? ORDER BY NIAN_JD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, this.isNianJd);
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
                residual.setNianJd(rs.getBoolean("is_nian_jd"));
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
    public List<Cuddington> findCuddingtons() {
        final List<Cuddington> cuddingtons = new ArrayList<Cuddington>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_CUDDINGTON WHERE IS_NIAN_JD=? ORDER BY NIAN_JD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, this.isNianJd);
            rs = ps.executeQuery();
            while (rs.next()) {
                final Cuddington cuddington = new Cuddington();
                cuddington.setId(rs.getInt("ID"));
                cuddington.setNianJD(rs.getString("NIAN_JD"));
                cuddington.setS1(rs.getDouble("S1"));
                cuddington.setS2(rs.getDouble("S2"));
                cuddington.setS3(rs.getDouble("S3"));
                cuddington.setS4(rs.getDouble("S4"));
                cuddington.setS5(rs.getDouble("S5"));
                cuddington.setS6(rs.getDouble("S6"));
                cuddington.setS7(rs.getDouble("S7"));
                cuddington.setS8(rs.getDouble("S8"));
                cuddington.setS9(rs.getDouble("S9"));
                cuddington.setS10(rs.getDouble("S10"));
                cuddington.setS11(rs.getDouble("S11"));
                cuddington.setS12(rs.getDouble("S12"));
                cuddington.setS13(rs.getDouble("S13"));
                cuddington.setS14(rs.getDouble("S14"));
                cuddington.setS15(rs.getDouble("S15"));
                cuddington.setNianJd(rs.getBoolean("is_nian_jd"));
                cuddington.calculate();
                cuddingtons.add(cuddington);
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
        return cuddingtons;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List findScaleAll() {
        return findScale();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return findAllNianJd();
    }

    private void batchInsertResidual(final Connection conn, final List<Residual> residuals) throws SQLException {
        PreparedStatement ps = null;
        final String sql = getbatchInsertResidualSql();
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
            ps.setBoolean(19, residual.isNianJd());
            ps.addBatch();
            ps.executeBatch();
        }
    }

    /**
     * @return
     */
    protected String getbatchInsertResidualSql() {
        return null;
    }

    private Vector<String> findAllNianJd() {
        final Vector<String> allNianJd = new Vector<String>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT NIAN_JD FROM SOCF_QUARTER_SCALE  WHERE IS_NIAN_JD=? ORDER BY NIAN_JD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, this.isNianJd);
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

    private List<QuarterScale> findScale() {
        final List<QuarterScale> quarterScales = new ArrayList<QuarterScale>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_QUARTER_SCALE WHERE IS_NIAN_JD=? ORDER BY NIAN_JD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, this.isNianJd);
            rs = ps.executeQuery();
            while (rs.next()) {
                final QuarterScale quarterScale = new QuarterScale();
                quarterScale.setId(rs.getInt("ID"));
                quarterScale.setNianJD(rs.getString("NIAN_JD"));
                quarterScale.setCuddington(rs.getString("cuddington"));
                quarterScale.setResidual(rs.getString("residual"));
                quarterScale.setNianJd(rs.getBoolean("is_nian_jd"));
                quarterScales.add(quarterScale);
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
        return quarterScales;
    }



    @Override
    public void deleteAll() {
        runTransaction(null);
    }


    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#batchInsert(java.util.Map)
     */
    @Override
    public void batchInsert(final Map<String, Object> result) {
        runTransaction(result);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void executer(final Connection conn, final Map<String, Object> result) throws SQLException {
        if (result != null) {
            final List<Cuddington> cuddingtons = (List<Cuddington>) result.get(Constant.PTY_CUDDINGTONS);
            final List<Residual> residuals = (List<Residual>) result.get(Constant.PTY_RESIDUALS);
            final List<QuarterScale> quarterScales = (List<QuarterScale>) result.get(Constant.PTY_QUARTER_SCALES);
            batchInsertCuddington(conn, cuddingtons);
            batchInsertResidual(conn, residuals);
            batchInsertScale(conn, quarterScales);
        } else {
            deleteScaleAll(conn);
            deleteCuddingtonAll(conn);
            deleteResidualAll(conn);
        }
    }

    /**
     * @param conn
     * @throws SQLException
     */
    private void deleteResidualAll(final Connection conn) throws SQLException {
        PreparedStatement ps = null;
        final String sql = "DELETE FROM SOCF_RESIDUAL WHERE NIAN_JD IS NOT NULL AND IS_NIAN_JD=?";
        ps = conn.prepareStatement(sql);
        ps.setBoolean(1, this.isNianJd);
        ps.executeUpdate();
    }

    /**
     * @param conn
     * @throws SQLException
     */
    private void deleteCuddingtonAll(final Connection conn) throws SQLException {
        PreparedStatement ps = null;
        final String sql = "DELETE FROM SOCF_CUDDINGTON WHERE NIAN_JD IS NOT NULL AND IS_NIAN_JD=?";
        ps = conn.prepareStatement(sql);
        ps.setBoolean(1, this.isNianJd);
        ps.executeUpdate();
    }

    /**
     * @param conn
     * @throws SQLException
     */
    private void deleteScaleAll(final Connection conn) throws SQLException {
        PreparedStatement ps = null;
        final String sql = "DELETE FROM SOCF_QUARTER_SCALE WHERE NIAN_JD IS NOT NULL AND IS_NIAN_JD=?";
        ps = conn.prepareStatement(sql);
        ps.setBoolean(1, this.isNianJd);
        ps.executeUpdate();
    }

    /**
     * @param conn
     * @param quarterScales
     * @throws SQLException
     */
    private void batchInsertScale(final Connection conn, final List<QuarterScale> quarterScales) throws SQLException {
        PreparedStatement ps = null;
        final String sql = getbatchInsertScaleSql();
        ps = conn.prepareStatement(sql);
        for (final QuarterScale quarterScale : quarterScales) {
            ps.setString(1, quarterScale.getNianJD());
            ps.setString(2, quarterScale.getCuddington());
            ps.setString(3, quarterScale.getResidual());
            ps.setBoolean(4, quarterScale.isNianJd());
            ps.addBatch();
            ps.executeBatch();
        }
    }

    /**
     * @return
     */
    protected String getbatchInsertScaleSql() {
        return null;
    }

    private void batchInsertCuddington(final Connection conn, final List<Cuddington> cuddingtons) throws SQLException {
        PreparedStatement ps = null;
        final String sql = getbatchInsertCuddingtonSql();
        ps = conn.prepareStatement(sql);
        for (final Cuddington cuddington : cuddingtons) {
            ps.setString(1, cuddington.getNianJD());
            ps.setDouble(2, cuddington.getS1());
            ps.setDouble(3, cuddington.getS2());
            ps.setDouble(4, cuddington.getS3());
            ps.setDouble(5, cuddington.getS4());
            ps.setDouble(6, cuddington.getS5());
            ps.setDouble(7, cuddington.getS6());
            ps.setDouble(8, cuddington.getS7());
            ps.setDouble(9, cuddington.getS8());
            ps.setDouble(10, cuddington.getS9());
            ps.setDouble(11, cuddington.getS10());
            ps.setDouble(12, cuddington.getS11());
            ps.setDouble(13, cuddington.getS12());
            ps.setDouble(14, cuddington.getS13());
            ps.setDouble(15, cuddington.getS14());
            ps.setDouble(16, cuddington.getS15());
            ps.setBoolean(17, cuddington.isNianJd());
            ps.addBatch();
            ps.executeBatch();
        }
    }

    /**
     * @return
     */
    protected String getbatchInsertCuddingtonSql() {
        return null;
    }

}
