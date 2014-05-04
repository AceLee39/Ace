// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class FrameCenterPanel extends JPanel {
    private final JTabbedPane tabs;
    private final NianJdCenterPanel nianJdCenterPanel;
	private final NianYdCenterPanel nianYdCenterPanel;
    public FrameCenterPanel() {
        this.setLayout(new BorderLayout());
        this.add(CustComboBoxPanel.getInstance(), BorderLayout.NORTH);
        tabs = new JTabbedPane();
        nianJdCenterPanel = new NianJdCenterPanel();
        CustComboBoxPanel.getInstance().setNeedReset(Boolean.FALSE);
        tabs.add("NianJd", nianJdCenterPanel);
		nianYdCenterPanel = new NianYdCenterPanel();
        tabs.add("NianYd", nianYdCenterPanel);
        this.add(tabs, BorderLayout.CENTER);
    }

    public String getCurTabName() {
        return tabs.getTitleAt(tabs.getSelectedIndex());
    }

    public AbstractCenterPanel getCurTabPanel() {
        return (AbstractCenterPanel) tabs.getSelectedComponent();
    }

    /**
     * @return the nianJdCenterPanel
     */
    public NianJdCenterPanel getNianJdCenterPanel() {
        return nianJdCenterPanel;
    }

    /**
     * @return the nianJdCenterPanel
     */
    public NianYdCenterPanel getNianYdCenterPanel() {
        return nianYdCenterPanel;
    }
}
