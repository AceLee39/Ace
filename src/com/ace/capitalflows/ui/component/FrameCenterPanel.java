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

    public FrameCenterPanel() {
        this.setLayout(new BorderLayout());
        this.add(CustComboBoxPanel.getInstance(), BorderLayout.NORTH);
        tabs = new JTabbedPane();
        nianJdCenterPanel = new NianJdCenterPanel();
        CustComboBoxPanel.getInstance().setNeedReset(Boolean.FALSE);
        tabs.add("NianJd", nianJdCenterPanel);
        this.add(tabs, BorderLayout.CENTER);
    }

    public String getCurTabName() {
        return tabs.getTitleAt(tabs.getSelectedIndex());
    }

    /**
     * @return the nianJdCenterPanel
     */
    public NianJdCenterPanel getNianJdCenterPanel() {
        return nianJdCenterPanel;
    }
}
