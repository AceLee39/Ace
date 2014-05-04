// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.db.model.DaoModel;
import com.ace.capitalflows.db.model.DaoModelFactory;
import com.ace.capitalflows.db.model.YDResidualOracleModel;
import com.ace.capitalflows.entity.YDResidual;

/**
 * @author Administrator
 *
 */
public class NianYdDataModel extends AbstractDataModel {
    DaoModel ydResidualModel = DaoModelFactory.getInstance().getDaoModel(YDResidualOracleModel.class.getName());


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

    @SuppressWarnings("unchecked")
    public String[][] getNianYdData() {
        final List<YDResidual> ydResiduals = ydResidualModel.findAll();
        final String[][] nianYdData = new String[ydResiduals.size()][2];
        for (int i=0; i<ydResiduals.size(); i++) {
            nianYdData[i][0] = ydResiduals.get(i).getNianYD();
            nianYdData[i][1] = ydResiduals.get(i).getYdResidual();
        }
        return nianYdData;
    }

    @SuppressWarnings("unchecked")
    public Vector<String> getNianYdComboBoxData() {
        return ydResidualModel.findComboBoxData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#batchInsert(java.util.List[])
     */
    @SuppressWarnings({"unchecked"})
    @Override
    public void batchInsert(final Map<String, Object> result) {
        ydResidualModel.batchInsert((List<YDResidual>) result.get(Constant.PTY_YD_RESIDUALS));
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        ydResidualModel.deleteAll();
    }
}
