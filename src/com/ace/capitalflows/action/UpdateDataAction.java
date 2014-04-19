// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import java.util.List;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;

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
        final String[][] dataArray = actionContext.getDataModel().getTableData();
        actionContext.setTableData(dataArray);
        final List<String> comboBoxDataList = actionContext.getDataModel().getComboBoxData();
        actionContext.setComboBoxData(comboBoxDataList);
    }
}
