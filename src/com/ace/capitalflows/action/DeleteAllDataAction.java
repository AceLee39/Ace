// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.DeleteAllDataActionContext;
import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.model.DataModel;

/**
 * @author Administrator
 *
 */
public class DeleteAllDataAction<T extends BaseActionContext> extends BaseAction<DeleteAllDataActionContext> {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.action.BaseAction#process(com.ace.capitalflows.action.actioncontext.ActionContext)
     */
    @Override
    protected void process(final DeleteAllDataActionContext actionContext) {
        final DataModel dataModel = actionContext.getDataModel();
        if (StringUtils.equals(actionContext.getCurTabName(), Constant.CENTER_YEAR)) {
            dataModel.getDaoModel().setNianJd(Boolean.FALSE);
        }
        dataModel.deleteAll();
    }

}
