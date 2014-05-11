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
public class ResidualOraclelModel extends ResidualModel{

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#getConn()
     */
    @Override
    protected Connection getConn() throws SQLException {
        return super.getOracleConn();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.ResidualModel#getbatchInsertSql()
     */
    @Override
    protected String getbatchInsertSql() {
        return "INSERT INTO SOCF_RESIDUAL(ID,NIAN_JD,S,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16) " +
                "VALUES(SEQ_RESIDUAL.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

}
