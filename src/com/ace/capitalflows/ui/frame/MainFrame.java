// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Toolkit;

import javax.swing.JMenuItem;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.ui.component.AbstractCenterPanel;
import com.ace.capitalflows.ui.component.CustComboBoxPanel;
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
    private static MainFrame instance;

    /**
     * @param title
     */
    private MainFrame(final String title) {
        super(title);
        final double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        final double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        this.setSize((int)width, (int)height);//设置大小
        this.setFont(new Font("System", Font.PLAIN, 14));
        final Font f = this.getFont();
        final FontMetrics fm = this.getFontMetrics(f);
        final int x = fm.stringWidth("短期资本流动规模测试系统");
        final int y = fm.stringWidth(" ");
        final int z = this.getWidth()/2 - (x/2);
        final int w = z/y;
        String pad ="";
        pad = String.format("%"+w+"s", pad);
        this.setTitle(pad+"短期资本流动规模测试系统");
        this.setResizable(false);
//        this.setLocation(0,0); //设置窗体居中显示
        setLocationRelativeTo(null);
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
        if(instance == null) {
            instance = MainFrameInstance.instance;
        }
        return instance;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#addIntoContainer()
     */
    @Override
    protected void addIntoContainer() {
        this.setJMenuBar(menuBar);
        container.setLayout(new BorderLayout());
        container.add(frameCenterPanel, BorderLayout.CENTER);
    }

    public JMenuItem getUpdate() {
        return menuBar.getUpdate();
    }

    public AbstractCenterPanel getCenterPanel() {
        return frameCenterPanel.getCenterPanel();
    }

    public CustComboBoxPanel getComboBoxPanel() {
        return frameCenterPanel.getCenterPanel().getComboBoxPanel();
    }

    public String getCenterPanelName() {
        return frameCenterPanel.getCenterPanelName();
    }

    public void setCenterPanel(final AbstractCenterPanel centerPanel) {
        frameCenterPanel.setCenterPanel(centerPanel);
    }

    public boolean isCurCenterPanel(final String name) {
        final boolean isCurCenterPanel = (name == null? true : StringUtils.equals(name, getCenterPanelName()));
        return isCurCenterPanel;
    }
}
