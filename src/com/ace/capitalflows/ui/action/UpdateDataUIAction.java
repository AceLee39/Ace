// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.action;

import java.util.Map;

import com.ace.capitalflows.action.ActionDispatch;
import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;

/**
 * @author Administrator
 *
 */
public class UpdateDataUIAction extends AbstractUIAction {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.action.AbstractUIAction#process(java.util.Map)
     */
    @Override
    protected void process(final Map<String, Object> params) {
        final BaseActionContext updateData = new UpdateDataActionContext();
        updateData.setCurTabName((String) params.get(UpdateDataActionContext.KEY_CUR_TAB_NAME));
        ActionDispatch.execute(updateData);
        params.put(UpdateDataActionContext.KEY_TABLE_DATA, updateData.getTableData());
        params.put(UpdateDataActionContext.KEY_COMBOBOX_DATA, updateData.getComboBoxData());
    }

}
