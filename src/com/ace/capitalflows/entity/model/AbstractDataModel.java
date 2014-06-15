// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.Vector;

import com.ace.capitalflows.db.model.DaoModel;

/**
 * @author Administrator
 *
 */
public abstract class AbstractDataModel implements DataModel {
    protected String mode;
    protected boolean isNianJd = true;
    protected DaoModel daoModel;
    protected boolean isResidual;

    public boolean isResidual() {
        return isResidual;
    }

    @Override
    public void setResidual(final boolean isResidual) {
        this.isResidual = isResidual;
    }

    @Override
    public DaoModel getDaoModel() {
        return this.daoModel;
    }

    public boolean isNianJd() {
        return isNianJd;
    }

    @Override
    public void setNianJd(final boolean isNianJd) {
        this.isNianJd = isNianJd;
    }

    @Override
    public void setMode(final String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public AbstractDataModel() {}

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
