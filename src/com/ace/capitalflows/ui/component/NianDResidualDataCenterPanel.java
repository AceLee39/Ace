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
public class NianDResidualDataCenterPanel extends AbstractCenterPanel {

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
        return new String[]{"年季度", "职工报酬差额（L1）", "各级政府差额(L2)", "资本帐户差额(L3)", "我国在外直接投资差额(L4)"
                , "股本证券差额(L5)", "(中)长期债券差额(L6)", "(中)长期债券差额(L7)", "长期差额(L8)", "长期差额(L9)"
                , "货币和存款差额(L10)", "长期差额(L11)", "长期差额(L12)", "长期差额(L13)", "长期差额(L14)", "FDI实际值(L15)"
                , "贸易中的实际顺差(L16)", "外汇占款增量(S)"};
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
        final DataModel nianDDataModule = DataModelFactory.getInstance().getDataModel(NianJdDataModel.class.getName(), Constant.MODE_DATA);
        nianDDataModule.getDaoModel().setNianJd(Boolean.FALSE);
        nianDDataModule.setResidual(Boolean.TRUE);
        return nianDDataModule;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initCenterPanelName()
     */
    @Override
    protected String initCenterPanelName() {
        return Constant.CENTER_YEAR_RESIDUAL_DATA;
    }
}
