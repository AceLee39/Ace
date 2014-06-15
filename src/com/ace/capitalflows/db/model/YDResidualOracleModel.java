// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class YDResidualOracleModel extends YDResidualModel{

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#getConn()
     */
    @Override
    protected Connection getConn() throws SQLException {
        return getOracleConn();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#getbatchInsertSql()
     */
    @Override
    protected String getbatchInsertSql() {
        return "INSERT INTO SOCF_YD_RESIDUAL(ID,NIAN_YD,S,FDI,FBT) " +
                "VALUES(SEQ_YD_RESIDUAL.NEXTVAL,?,?,?,?)";
    }

    @Override
    protected String getBatchInsertSqlforMonthScale() {
        return "INSERT INTO SOCF_MONTH_SCALE (ID,NIAN_YD,ydResidual ) " +
                "VALUES(SEQ_MONTH_SCALE.NEXTVAL,?,?)";
    }
}
