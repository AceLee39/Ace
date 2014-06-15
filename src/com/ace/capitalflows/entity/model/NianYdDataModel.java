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

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.db.model.DaoModelFactory;
import com.ace.capitalflows.entity.MonthScale;
import com.ace.capitalflows.entity.YDResidual;
import com.ace.capitalflows.utils.PropertiesUtil;

/**
 * @author Administrator
 *
 */
public class NianYdDataModel extends AbstractDataModel {


    public NianYdDataModel() {
        daoModel = DaoModelFactory.getInstance().getDaoModel(PropertiesUtil.getString("YDResidualModel"));
    }

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
        String[][] nianYdData = null;
        if (StringUtils.equals(this.mode, Constant.MODE_SCALE)) {
            final List<MonthScale> monthScales = daoModel.findScaleAll();
            nianYdData = new String[monthScales.size()][2];
            for (int i=0; i<monthScales.size(); i++) {
                nianYdData[i][0] = monthScales.get(i).getNianYD();
                nianYdData[i][1] = monthScales.get(i).getYdResidual();
            }
        }
        if (StringUtils.equals(this.mode, Constant.MODE_DATA)) {
            final List<YDResidual> yDResiduals = daoModel.findDataAll();
            nianYdData = new String[yDResiduals.size()][4];
            for (int i=0; i<yDResiduals.size(); i++) {
                nianYdData[i][0] = yDResiduals.get(i).getNianYD();
                nianYdData[i][1] = String.valueOf(yDResiduals.get(i).getS());
                nianYdData[i][2] = String.valueOf(yDResiduals.get(i).getFdi());
                nianYdData[i][3] = String.valueOf(yDResiduals.get(i).getFbt());
            }
        }
        return nianYdData;
    }

    @SuppressWarnings("unchecked")
    public Vector<String> getNianYdComboBoxData() {
        return daoModel.findComboBoxData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#batchInsert(java.util.List[])
     */
    @Override
    public void batchInsert(final Map<String, Object> result) {
        daoModel.batchInsert(result);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.AbstractDataModel#deleteAll()
     */
    @Override
    public void deleteAll() {
        daoModel.deleteAll();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.entity.model.DataModel#setMode(java.lang.String)
     */
    @Override
    public void setMode(final String mode) {
        this.mode = mode;
    }
}
