// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.model.DataModel;

/**
 * @author Administrator
 *
 */
public class UpdateDataAction<T extends BaseActionContext> extends BaseAction<UpdateDataActionContext> {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.action.BaseAction#process(com.ace.capitalflows.action.actioncontext.ActionContext)
     */
    @Override
    protected void process(final UpdateDataActionContext actionContext) {
        final DataModel dataModel = actionContext.getDataModel();
        if (StringUtils.equals(actionContext.getCurTabName(), Constant.CENTER_YEAR)
                || StringUtils.equals(actionContext.getCurTabName(), Constant.CENTER_YEAR_CUDDINGTON_DATA)
                || StringUtils.equals(actionContext.getCurTabName(), Constant.CENTER_YEAR_RESIDUAL_DATA)) {
            dataModel.getDaoModel().setNianJd(Boolean.FALSE);
        }
        final String[][] dataArray = dataModel.getTableData();
        actionContext.setTableData(dataArray);
        final List<String> comboBoxDataList = dataModel.getComboBoxData();
        actionContext.setComboBoxData(comboBoxDataList);
    }
}
