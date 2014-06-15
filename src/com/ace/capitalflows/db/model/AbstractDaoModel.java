// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.db.OracleDaoFactory;
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.Residual;
import com.ace.capitalflows.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public abstract class AbstractDaoModel implements DaoModel {
    protected boolean isNianJd = Boolean.TRUE;
    @Override
    public void batchInsert(final Map<String, Object> result) {

    }

    public boolean isNianJd() {
        return isNianJd;
    }

    @Override
    public void setNianJd(final boolean isNianJd) {
        this.isNianJd = isNianJd;
    }

    protected Connection getConn() throws SQLException {
        return null;
    }

    protected Connection getMysqlConn() throws SQLException {
        return DaoFactory.getInstance().getConn();
    }

    protected Connection getOracleConn() throws SQLException {
        return OracleDaoFactory.getInstance().getConn();
    }

    protected String getbatchInsertSql() {
        return StringUtils.EMPTY;
    }

    @Override
    public List<Cuddington> findCuddingtons() {
        return null;
    }

    @Override
    public List<Residual> findResiduals() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return null;
    }

    protected void runTransaction(final Map<String, Object> result) {
        final Transaction transaction = new Transaction() {
            @Override
            public void process() {
                Connection conn = null;
                try {
                    conn = getConn();
                    conn.setAutoCommit(false);
                    executer(conn, result);
                    conn.commit();
                } catch (final SQLException e) {
                    try {
                        if (!conn.isClosed() && conn != null) {
                            conn.rollback();
                        }
                    } catch (final SQLException e1) {
                        e1.printStackTrace();
                    }
                    e.printStackTrace();
                } finally {
                    try {
                        DBUtils.closeConn(conn);
                    } catch (final SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        transaction.process();
    }

    /**
     * @param conn
     * @param ydResiduals
     * @throws SQLException
     *
     */
    protected void executer(final Connection conn, final Map<String, Object> result) throws SQLException {

    }

    private interface Transaction {
        void process();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List findScaleAll() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public List findDataAll() {
        return null;
    }


}
