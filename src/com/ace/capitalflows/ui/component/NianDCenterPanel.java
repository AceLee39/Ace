// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.util.Vector;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.model.DataModel;
import com.ace.capitalflows.entity.model.DataModelFactory;
import com.ace.capitalflows.entity.model.NianJdDataModel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class NianDCenterPanel extends AbstractCenterPanel {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initTableData()
     */
    @Override
    protected String[][] initTableData() {
        return dataModel.getTableData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initTableHeader()
     */
    @Override
    protected String[] initTableHeader() {
        return new String[]{"年季度", "直接法", "间接法"};
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initComboBoxData()
     */
    @Override
    protected Vector<String> initComboBoxData() {
        return dataModel.getComboBoxData();
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initDataModel()
     */
    @Override
    protected DataModel initDataModel() {
        final DataModel nianDDataModule = DataModelFactory.getInstance().getDataModel(NianJdDataModel.class.getName(), Constant.MODE_SCALE);
        nianDDataModule.getDaoModel().setNianJd(Boolean.FALSE);
        return nianDDataModule;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initCenterPanelName()
     */
    @Override
    protected String initCenterPanelName() {
        return Constant.CENTER_YEAR;
    }
}