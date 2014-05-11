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
public class CuddingtonOracleModel extends CuddingtonModel{

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
        return "INSERT INTO SOCF_CUDDINGTON(ID,NIAN_JD,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15) " +
                "VALUES(SEQ_CUDDINGTON.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}
