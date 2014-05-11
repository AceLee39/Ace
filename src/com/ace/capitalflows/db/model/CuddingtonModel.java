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

import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class CuddingtonModel extends AbstractDaoModel{

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#batchInsert(java.util.List)
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void batchInsert(final List items) {
        batchInsertCuddington(items);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#findAll()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List findAll() {
        return findCuddingtons();
    }

    private void batchInsertCuddington(final List<Cuddington> cuddingtons) {
        Connection conn = null;
        PreparedStatement ps = null;
        final String sql = getbatchInsertSql();
        try {
            conn = getConn();
            conn.setAutoCommit(false);
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

    @Override
    public void deleteAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConn();
            final String sql = "DELETE FROM SOCF_CUDDINGTON WHERE NIAN_JD IS NOT NULL";
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


    private List<Cuddington> findCuddingtons() {
        final List<Cuddington> cuddingtons = new ArrayList<Cuddington>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String sql = "SELECT * FROM SOCF_CUDDINGTON ORDER BY NIAN_JD";
            conn = getConn();
            ps = conn.prepareStatement(sql);
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

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#findComboBoxData()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        // TODO Auto-generated method stub
        return null;
    }

}
