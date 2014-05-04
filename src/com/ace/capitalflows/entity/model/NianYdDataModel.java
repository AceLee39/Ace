// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.List;
import java.util.Vector;

import com.ace.capitalflows.db.model.YDResidualModel;
import com.ace.capitalflows.entity.YDResidual;

/**
 * @author Administrator
 *
 */
public class NianYdDataModel extends AbstractDataModel {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#getTableData()
     */
    @Override
    public String[][] getTableData() {
        return getNianYdData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#getComboBoxData()
     */
    @Override
    public Vector<String> getComboBoxData() {
        return getNianYdComboBoxData();
    }

    public String[][] getNianYdData() {
        final List<YDResidual> ydResiduals = YDResidualModel.findYDResiduals();
        final String[][] nianYdData = new String[ydResiduals.size()][3];
        for (int i=0; i<ydResiduals.size(); i++) {
            nianYdData[i][0] = ydResiduals.get(i).getNianYD();
            nianYdData[i][1] = ydResiduals.get(i).getYdResidual();
        }
        return nianYdData;
    }

    public Vector<String> getNianYdComboBoxData() {
        return YDResidualModel.findAllNianYd();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#batchInsert(java.util.List[])
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void batchInsert(final List... lists) {
        YDResidualModel.batchInsertYDResidual(lists[0]);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        YDResidualModel.deleteAll();
    }
}
