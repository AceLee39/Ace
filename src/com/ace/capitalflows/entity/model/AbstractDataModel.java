// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.Vector;

/**
 * @author Administrator
 *
 */
public abstract class AbstractDataModel implements DataModel {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#getTableData()
     */
    @Override
    public String[][] getTableData() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#getComboBoxData()
     */
    @Override
    public Vector<String> getComboBoxData() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#deleteAll()
     */
    @Override
    public void deleteAll() {

    }

}
