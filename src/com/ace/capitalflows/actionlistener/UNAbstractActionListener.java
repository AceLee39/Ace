// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import com.ace.capitalflows.ui.action.UIActionExecute;
import com.ace.capitalflows.ui.frame.BaseFrame;

/**
 * @author Administrator
 *
 */
public abstract class UNAbstractActionListener implements ActionListener {
    private final BaseFrame baseFrame;
    private final Map<String, Object> params = new HashMap<String, Object>();

    public UNAbstractActionListener (final BaseFrame baseFrame) {
        this.baseFrame = baseFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        doUpdate();
    }

    /**
     *
     */
    protected void doUpdate() {
        initParams();
        doUIAction();
        updatedFrame();
    }

    /**
     *
     */
    private void updatedFrame() {
        // TODO Auto-generated method stub

    }

    /**
     *
     */
    private void doUIAction() {
        UIActionExecute.execute(this.getClass().getSimpleName(), params);
    }

    /**
     *
     */
    private void initParams() {
        // TODO Auto-generated method stub

    }

    public BaseFrame getBaseFrame() {
        return baseFrame;
    }

    public Map<String, Object> getParams() {
        return params;
    }

}
