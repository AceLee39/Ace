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
    public FrameCenterPanel() {
        this.setLayout(new BorderLayout());
        this.add(CustComboBoxPanel.getInstance(), BorderLayout.NORTH);
        tabs = new JTabbedPane();
        tabs.add("NianJd", new NianJdCenterPanel());
        tabs.add("NianYd", new NianYdCenterPanel());
        this.add(tabs, BorderLayout.CENTER);
        CustTablePanel.getInstance().setNeedReInit(Boolean.TRUE);
    }

    public String getCurTabName() {
        return tabs.getTitleAt(tabs.getSelectedIndex());
    }



}
