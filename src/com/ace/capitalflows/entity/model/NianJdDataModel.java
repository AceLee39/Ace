// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.List;
import java.util.Vector;

import com.ace.capitalflows.db.model.CuddingtonModel;
import com.ace.capitalflows.db.model.ResidualModel;
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.Residual;

/**
 * @author Administrator
 *
 */
public class NianJdDataModel extends AbstractDataModel {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#getTableData()
     */
    @Override
    public String[][] getTableData() {
        return getNianJdData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#getComboBoxData()
     */
    @Override
    public Vector<String> getComboBoxData() {
        return getNianJdComboBoxData();
    }

    public String[][] getNianJdData() {
        final List<Residual> residuals = ResidualModel.findResiduals();
        final List<Cuddington> cuddingtons = CuddingtonModel.findCuddingtons();
        final String[][] nianJdData = new String[residuals.size()][3];
        for (int i=0; i<residuals.size(); i++) {
            nianJdData[i][0] = residuals.get(i).getNianJD();
            nianJdData[i][1] = residuals.get(i).getResidual();
            nianJdData[i][2] = cuddingtons.get(i).getCuddington();
        }
        return nianJdData;
    }

    public Vector<String> getNianJdComboBoxData() {
        return ResidualModel.findAllNianJd();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#batchInsert(java.util.List[])
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void batchInsert(final List... lists) {
        ResidualModel.batchInsertResidual(lists[0]);
        CuddingtonModel.batchInsertCuddington(lists[1]);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        ResidualModel.deleteAll();
        CuddingtonModel.deleteAll();
    }

}
