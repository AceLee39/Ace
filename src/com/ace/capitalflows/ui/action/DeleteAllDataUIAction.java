// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.action;

import java.util.Map;

import com.ace.capitalflows.action.ActionDispatch;
import com.ace.capitalflows.action.actioncontext.DeleteAllDataActionContext;

/**
 * @author Administrator
 *
 */
public class DeleteAllDataUIAction extends AbstractUIAction {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.action.AbstractUIAction#process(java.util.Map)
     */
    @Override
    protected void process(final Map<String, Object> params) {
        final DeleteAllDataActionContext deleteAllData = new DeleteAllDataActionContext();
        deleteAllData.setCurTabName(params.get(DeleteAllDataActionContext.KEY_CUR_TAB_NAME).toString());
        ActionDispatch.execute(deleteAllData);
    }

}
