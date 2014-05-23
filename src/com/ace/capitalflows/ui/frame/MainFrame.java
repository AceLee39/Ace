// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ace.capitalflows.actionlistener.DeleteAllDataActionListener;
import com.ace.capitalflows.actionlistener.ImportDataActionListener;
import com.ace.capitalflows.actionlistener.ShowCharActionListener;
import com.ace.capitalflows.actionlistener.UpdateDataActionListener;
import com.ace.capitalflows.ui.component.AbstractCenterPanel;
import com.ace.capitalflows.ui.component.FrameCenterPanel;


/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends BaseFrame {
    private JMenuBar menuBar;
    private JMenuItem importData;
    private JMenuItem update;
    private JMenuItem deleteAll;
    private JMenuItem showChar;
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
        menuBar = new JMenuBar();
        final JMenu menu = new JMenu("File");
        importData = new JMenuItem("Import Data");
        menu.add(importData);

        showChar = new JMenuItem("Show Chart");
        menu.add(showChar);
        menuBar.add(menu);

        final JMenu edit = new JMenu("Edit");
        update = new JMenuItem("Update");
        edit.add(update);
        deleteAll = new JMenuItem("DeleteAllData");
        edit.add(deleteAll);
        menuBar.add(edit);

        frameCenterPanel = new FrameCenterPanel();

    }

    private static class MainFrameInstance {
        private static MainFrame instance = new MainFrame("短期资本流动规模测试系统");
    }

    public static MainFrame getInstance() {
        return MainFrameInstance.instance;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#addButtonActionListener()
     */
    @Override
    protected void addButtonActionListener() {
        importData.addActionListener(new ImportDataActionListener());
        update.addActionListener(new UpdateDataActionListener());
        deleteAll.addActionListener(new DeleteAllDataActionListener());
        showChar.addActionListener(new ShowCharActionListener());
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#addIntoContainer()
     */
    @Override
    protected void addIntoContainer() {
        container.setLayout(new BorderLayout());
        container.add(menuBar, BorderLayout.NORTH);
        container.add(frameCenterPanel, BorderLayout.CENTER);
    }

    /**
     * @return the update
     */
    public JMenuItem getUpdate() {
        return update;
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
