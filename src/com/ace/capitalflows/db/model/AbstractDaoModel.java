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
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.db.OracleDaoFactory;

/**
 * @author Administrator
 *
 */
public class AbstractDaoModel implements DaoModel {

    @SuppressWarnings("rawtypes")
    @Override
    public void batchInsert(final List items) {

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("rawtypes")
    @Override
    public List findAll() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return null;
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
}
