// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import com.ace.capitalflows.action.actioncontext.DeleteAllDataActionContext;
import com.ace.capitalflows.ui.frame.MainFrame;


/**
 * @author Administrator
 */
public class DeleteAllDataActionListener extends AbstractActionListener {

    /*
     * (non-Javadoc)
     * @see com.ace.capitalflows.actionlistener.AbstractActionListener#initParams()
     */
    @Override
    protected void initParams() {
        params.put(DeleteAllDataActionContext.KEY_CENTER_PANEL_NAME, MainFrame.getInstance().getCenterPanelName());
    }

}
