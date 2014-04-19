// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.util.List;
import java.util.Vector;

/**
 * @author Administrator
 *
 */
public class AbstractDaoModel implements DaoModel {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#batchInsert(java.util.List)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public void batchInsert(final List items) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#findAll()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public List findAll() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see com.ace.capitalflows.db.model.DaoModel#findComboBoxData()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Vector findComboBoxData() {
        return null;
    }
}
