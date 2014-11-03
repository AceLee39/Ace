// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import com.ace.capitalflows.ui.component.AbstractCenterPanel;
import com.ace.capitalflows.ui.frame.MainFrame;

/**
 * @author Ace.Li
 *
 */
public class CustMenuActionListener implements ActionListener {
    private final AbstractCenterPanel centerPanel;

    public CustMenuActionListener(final AbstractCenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if(MainFrame.getInstance().isCurCenterPanel(centerPanel.getCenterPanelName())) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrame.getInstance().setCenterPanel(centerPanel);
                MainFrame.getInstance().pack();
            }
        });
    }
}
