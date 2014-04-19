// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.action;

import java.util.Map;

/**
 * @author Administrator
 *
 */
public abstract class AbstractUIAction implements UIAction {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.action.UIAction#execute()
     */
    @Override
    public void execute(final Map<String, Object> params) {
        preprocess(params);
        process(params);
        postprocess(params);
    }

    /**
     *
     */
    protected void postprocess(final Map<String, Object> params) {

    }

    protected abstract void process(Map<String, Object> params);

    protected void preprocess(final Map<String, Object> params) {

    }

}
