// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.ace.capitalflows.ui.frame.MainFrame;
import com.ace.capitalflows.utils.LabelManager;

/**
 * @author Ace.Li
 *
 */
@SuppressWarnings("serial")
public class CustMenuItem extends JMenuItem implements ActionListener{
    private static final String CLASS_FORMAT_PATH = "com.ace.capitalflows.ui.componect.%1$sCenterPanel";
    private AbstractCenterPanel centerPanel;


    @SuppressWarnings({"static-access", "unchecked"})
    public CustMenuItem(final String panelKey) {
        super(LabelManager.getInstance().getString(panelKey));
        try {
            final Class<AbstractCenterPanel> clazz = (Class<AbstractCenterPanel>) Class.forName(String.format(CLASS_FORMAT_PATH, panelKey));
            centerPanel = clazz.newInstance();
        } catch (final Exception e) {
            centerPanel = null;
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        if(centerPanel == null || MainFrame.getInstance().isCurCenterPanel(centerPanel.getCenterPanelName())) {
            return;
        }
        MainFrame.getInstance().setCenterPanel(centerPanel);
        MainFrame.getInstance().pack();
    }

}
