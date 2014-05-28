// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class FrameCenterPanel extends JPanel {
    private AbstractCenterPanel centerPanel;
    public FrameCenterPanel() {
        this.setLayout(new BorderLayout());
        centerPanel = initDefaultCenterPanel();
        this.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * @return
     */
    private AbstractCenterPanel initDefaultCenterPanel() {
        return new NianJdCenterPanel();
    }

    /**
     * @return the centerPanel
     */
    public AbstractCenterPanel getCenterPanel() {
        return centerPanel;
    }

    public String getCenterPanelName() {
        return centerPanel.getCenterPanelName();
    }

    /**
     * @param centerPanel the centerPanel to set
     */
    public void setCenterPanel(final AbstractCenterPanel centerPanel) {
        this.centerPanel = centerPanel;
        this.add(centerPanel, BorderLayout.CENTER);
    }


}
