// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;

/**
 * @author Administrator
 *
 */
public abstract class BaseAction<T extends BaseActionContext> implements Action<T> {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.action.Action#execute(com.ace.capitalflows.action.actioncontext.ActionContext)
     */
    @Override
    public void execute(final T actionContext) {
        preprocess(actionContext);
        process(actionContext);
        postprocess(actionContext);
    }

    protected void postprocess(final T actionContext) {

    }

    protected abstract void process(final T actionContext);

    protected void preprocess(final T actionContext) {

    }

}
