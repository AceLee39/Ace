// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class FrameCenterPanel extends JPanel {
    protected AbstractCenterPanel centerPanel;
    protected JLabel centerPanelName;
    public FrameCenterPanel() {
        this.setLayout(new BorderLayout());
        centerPanel = initDefaultCenterPanel();
        centerPanelName = new JLabel(centerPanel.getCenterPanelName());
        this.add(centerPanelName, BorderLayout.NORTH);
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
        FrameCenterPanel.this.remove(FrameCenterPanel.this.centerPanel);
        FrameCenterPanel.this.remove(FrameCenterPanel.this.centerPanelName);
        FrameCenterPanel.this.invalidate();
        FrameCenterPanel.this.updateUI();
        FrameCenterPanel.this.centerPanel = centerPanel;
        FrameCenterPanel.this.centerPanelName = new JLabel(FrameCenterPanel.this.centerPanel.getCenterPanelName());
        FrameCenterPanel.this.add(FrameCenterPanel.this.centerPanelName, BorderLayout.NORTH);
        FrameCenterPanel.this.add(FrameCenterPanel.this.centerPanel, BorderLayout.CENTER);
        FrameCenterPanel.this.invalidate();
        FrameCenterPanel.this.updateUI();
    }
}
