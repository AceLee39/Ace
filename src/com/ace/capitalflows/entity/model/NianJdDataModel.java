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
import com.ace.capitalflows.db.model.CuddingtonOracleModel;
import com.ace.capitalflows.db.model.DaoModel;
import com.ace.capitalflows.db.model.DaoModelFactory;
import com.ace.capitalflows.db.model.ResidualOraclelModel;
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.Residual;

/**
 * @author Administrator
 *
 */
public class NianJdDataModel extends AbstractDataModel {
    DaoModel cuddingtonModel = DaoModelFactory.getInstance().getDaoModel(CuddingtonOracleModel.class.getName());
    DaoModel residualModel = DaoModelFactory.getInstance().getDaoModel(ResidualOraclelModel.class.getName());

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

    @SuppressWarnings("unchecked")
    public String[][] getNianJdData() {
        final List<Residual> residuals = residualModel.findAll();
        final List<Cuddington> cuddingtons = cuddingtonModel.findAll();
        final String[][] nianJdData = new String[residuals.size()][3];
        for (int i=0; i<residuals.size(); i++) {
            nianJdData[i][0] = residuals.get(i).getNianJD();
            nianJdData[i][1] = residuals.get(i).getResidual();
            nianJdData[i][2] = cuddingtons.get(i).getCuddington();
        }
        return nianJdData;
    }

    @SuppressWarnings("unchecked")
    public Vector<String> getNianJdComboBoxData() {
        return residualModel.findComboBoxData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#batchInsert(java.util.List[])
     */
    @SuppressWarnings({"rawtypes"})
    @Override
    public void batchInsert(final Map<String, Object> result) {
        residualModel.batchInsert((List) result.get(Constant.PTY_RESIDUALS));
        cuddingtonModel.batchInsert((List) result.get(Constant.PTY_CUDDINGTONS));
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        residualModel.deleteAll();
        cuddingtonModel.deleteAll();
    }

}
