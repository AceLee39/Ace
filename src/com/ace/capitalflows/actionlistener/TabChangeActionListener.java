// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.util.Vector;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ace.capitalflows.ui.component.AbstractCenterPanel;
import com.ace.capitalflows.ui.component.CustComboBoxPanel;

/**
 * @author Administrator
 *
 */
public class TabChangeActionListener implements ChangeListener{

    /* (non-Javadoc)
     * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
     */
    @Override
    public void stateChanged(final ChangeEvent e) {
        final JTabbedPane source = (JTabbedPane) e.getSource();
        final AbstractCenterPanel centerPanel = (AbstractCenterPanel) source.getSelectedComponent();
        final Vector<String> comboBoxData = centerPanel.getComboBoxData();
        final CustComboBoxPanel comboBoxPanel = CustComboBoxPanel.getInstance();
        comboBoxPanel.setNeedReset(Boolean.TRUE);
        comboBoxPanel.setComboBoxData(comboBoxData);
        comboBoxPanel.setNeedReset(Boolean.FALSE);
    }
}
