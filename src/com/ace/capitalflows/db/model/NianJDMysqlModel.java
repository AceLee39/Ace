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
public class NianJDMysqlModel extends NianJDModel{

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.AbstractDaoModel#getConn()
     */
    @Override
    protected Connection getConn() throws SQLException {
        return super.getMysqlConn();
    }

    @Override
    protected String getbatchInsertScaleSql() {
        return "INSERT INTO SOCF_QUARTER_SCALE(ID,NIAN_JD,cuddington,residual,is_nian_jd) " +
                "VALUES(null,?,?,?,?)";
    }

    @Override
    protected String getbatchInsertCuddingtonSql() {
        return "INSERT INTO SOCF_CUDDINGTON(ID,NIAN_JD,S1,S2,S3,S4,S5,S6,S7,S8,S9,S10,S11,S12,S13,S14,S15,is_nian_jd) " +
                "VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String getbatchInsertResidualSql() {
        return "INSERT INTO SOCF_RESIDUAL(ID,NIAN_JD,S,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13,L14,L15,L16,is_nian_jd) " +
                "VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
}
