// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;

import javax.swing.JMenuItem;

import com.ace.capitalflows.ui.component.AbstractCenterPanel;
import com.ace.capitalflows.ui.component.CustMenuBar;
import com.ace.capitalflows.ui.component.FrameCenterPanel;


/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends BaseFrame {
    private CustMenuBar menuBar;
    private FrameCenterPanel frameCenterPanel;

    /**
     * @param title
     */
    private MainFrame(final String title) {
        super(title);
        this.setSize(500, 600);
        this.setVisible(true);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#initComponent()
     */
    @Override
    protected void initComponent() {

        //init menuBar
        menuBar = new CustMenuBar();
        frameCenterPanel = new FrameCenterPanel();

    }

    private static class MainFrameInstance {
        private static MainFrame instance = new MainFrame("短期资本流动规模测试系统");
    }

    public static MainFrame getInstance() {
        return MainFrameInstance.instance;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#addIntoContainer()
     */
    @Override
    protected void addIntoContainer() {
        this.setJMenuBar(menuBar);
        container.setLayout(new BorderLayout());
//        container.add(menuBar, BorderLayout.NORTH);
        container.add(frameCenterPanel, BorderLayout.CENTER);
    }

    public JMenuItem getUpdate() {
        return menuBar.getUpdate();
    }

    public String getCurTabName() {
        return frameCenterPanel.getCurTabName();
    }

    public AbstractCenterPanel getCurTabPanel() {
        return frameCenterPanel.getCurTabPanel();
    }

    public AbstractCenterPanel getCenterPanel(final String panelName) {
        return frameCenterPanel.getCenterPanel(panelName);
    }
}
