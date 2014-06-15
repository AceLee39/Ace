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
import com.ace.capitalflows.entity.model.NianYdDataModel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class NianYdDataCenterPanel extends AbstractCenterPanel {

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
        return new String[]{"年月度", "外汇占款增量S", "调整后FDI", "实际贸易顺差FBT"};
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
        return DataModelFactory.getInstance().getDataModel(NianYdDataModel.class.getName(), Constant.MODE_DATA);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initCenterPanelName()
     */
    @Override
    protected String initCenterPanelName() {
        return Constant.CENTER_NIAN_YD_DATA;
    }
}
