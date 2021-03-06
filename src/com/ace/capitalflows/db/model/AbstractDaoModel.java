// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.db.DaoFactory;
import com.ace.capitalflows.db.OracleDaoFactory;

/**
 * @author Administrator
 *
 */
public abstract class AbstractDaoModel implements DaoModel {

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
