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
public class NianJdCuddingtonDataCenterPanel extends AbstractCenterPanel {

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
        return new String[]{"年季度", "投资收益差额(S1)", "其它部门差额(S2)", "货币市场工具差额(S3)", "股本证券差额(S4)", "货币市场工具差额(S5)"
                , "短期差额(S6)", "短期差额(S7)", "短期差额(S8)", "短期差额(S9)", "短期差额(S10)", "货币和存款差额(S11)", "短期差额(S12)", "FDI中短期资本(20%)(S13)"
                , "贸易中的短期资本(S14)", "调整项(90%)(S15)"};
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
        final DataModel nianJdDataModule = DataModelFactory.getInstance().getDataModel(NianJdDataModel.class.getName(), Constant.MODE_DATA);
        nianJdDataModule.setNianJd(Boolean.FALSE);
        nianJdDataModule.setResidual(Boolean.FALSE);
        return nianJdDataModule;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.component.AbstractCenterPanel#initCenterPanelName()
     */
    @Override
    protected String initCenterPanelName() {
        return Constant.CENTER_NIAN_JD_CUDDINGTON_DATA;
    }
}
