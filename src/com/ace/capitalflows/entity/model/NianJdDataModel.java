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
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.QuarterScale;
import com.ace.capitalflows.entity.Residual;
import com.ace.capitalflows.utils.PropertiesUtil;

/**
 * @author Administrator
 *
 */
public class NianJdDataModel extends AbstractDataModel {


    public NianJdDataModel() {
        daoModel = DaoModelFactory.getInstance().getDaoModel(PropertiesUtil.getString("NianJDModel"));
    }


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

    private String Double2String(final double data) {
        return String.valueOf(data);
    }

    @SuppressWarnings("unchecked")
    public String[][] getNianJdData() {
        String[][] nianJdData = null;
        if (StringUtils.endsWith(this.mode, Constant.MODE_DATA)) {
            if (this.isResidual) {
                final List<Residual> residuals = daoModel.findResiduals();
                nianJdData = new String[residuals.size()][18];
                for (int i=0; i<residuals.size(); i++) {
                    nianJdData[i][0] = residuals.get(i).getNianJD();
                    nianJdData[i][1] = Double2String(residuals.get(i).getL1());
                    nianJdData[i][2] = Double2String(residuals.get(i).getL2());
                    nianJdData[i][3] = Double2String(residuals.get(i).getL3());
                    nianJdData[i][4] = Double2String(residuals.get(i).getL4());
                    nianJdData[i][5] = Double2String(residuals.get(i).getL5());
                    nianJdData[i][6] = Double2String(residuals.get(i).getL6());
                    nianJdData[i][7] = Double2String(residuals.get(i).getL7());
                    nianJdData[i][8] = Double2String(residuals.get(i).getL8());
                    nianJdData[i][9] = Double2String(residuals.get(i).getL9());
                    nianJdData[i][10] = Double2String(residuals.get(i).getL10());
                    nianJdData[i][11] = Double2String(residuals.get(i).getL11());
                    nianJdData[i][12] = Double2String(residuals.get(i).getL12());
                    nianJdData[i][13] = Double2String(residuals.get(i).getL13());
                    nianJdData[i][14] = Double2String(residuals.get(i).getL14());
                    nianJdData[i][15] = Double2String(residuals.get(i).getL15());
                    nianJdData[i][16] = Double2String(residuals.get(i).getL16());
                    nianJdData[i][17] = Double2String(residuals.get(i).getS());
                }
            } else {
                final List<Cuddington> cuddingtons = daoModel.findCuddingtons();
                nianJdData = new String[cuddingtons.size()][16];
                for (int i=0; i<cuddingtons.size(); i++) {
                    nianJdData[i][0] = cuddingtons.get(i).getNianJD();
                    nianJdData[i][1] = Double2String(cuddingtons.get(i).getS1());
                    nianJdData[i][2] = Double2String(cuddingtons.get(i).getS2());
                    nianJdData[i][3] = Double2String(cuddingtons.get(i).getS3());
                    nianJdData[i][4] = Double2String(cuddingtons.get(i).getS4());
                    nianJdData[i][5] = Double2String(cuddingtons.get(i).getS5());
                    nianJdData[i][6] = Double2String(cuddingtons.get(i).getS6());
                    nianJdData[i][7] = Double2String(cuddingtons.get(i).getS7());
                    nianJdData[i][8] = Double2String(cuddingtons.get(i).getS8());
                    nianJdData[i][9] = Double2String(cuddingtons.get(i).getS9());
                    nianJdData[i][10] = Double2String(cuddingtons.get(i).getS10());
                    nianJdData[i][11] = Double2String(cuddingtons.get(i).getS11());
                    nianJdData[i][12] = Double2String(cuddingtons.get(i).getS12());
                    nianJdData[i][13] = Double2String(cuddingtons.get(i).getS13());
                    nianJdData[i][14] = Double2String(cuddingtons.get(i).getS14());
                    nianJdData[i][15] = Double2String(cuddingtons.get(i).getS15());
                }
            }
        }
        if (StringUtils.equals(this.mode, Constant.MODE_SCALE)) {
            final List<QuarterScale> quarterScales = daoModel.findScaleAll();
            nianJdData = new String[quarterScales.size()][3];
            for (int i=0; i<quarterScales.size(); i++) {
                nianJdData[i][0] = quarterScales.get(i).getNianJD();
                nianJdData[i][1] = quarterScales.get(i).getResidual();
                nianJdData[i][2] = quarterScales.get(i).getCuddington();
            }
        }
        return nianJdData;
    }

    @SuppressWarnings("unchecked")
    public Vector<String> getNianJdComboBoxData() {
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
     * @see com.ace.capitalflows.entity.model.DataModel#setMode()
     */
    @Override
    public void setMode(final String mode) {
        this.mode = mode;
    }

}
