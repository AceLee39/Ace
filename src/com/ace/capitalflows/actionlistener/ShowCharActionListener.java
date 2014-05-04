// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import com.ace.capitalflows.ui.frame.MainFrame;
import com.ace.capitalflows.ui.frame.chart.ChartFactory;

/**
 * @author Administrator
 */
public class ShowCharActionListener extends AbstractActionListener {

    /*
     * (non-Javadoc)
     * @see com.ace.capitalflows.actionlistener.AbstractActionListener#initParams()
     */
    @Override
    protected void initParams() {

    }

    @Override
    protected void doUIAction() {
    }

    @Override
    protected void updatedFrame() {
        final String[][] dataArray = MainFrame.getInstance().getCurTabPanel().getTableData();
        final ApplicationFrame demo = ChartFactory.getInstance().getChart(dataArray);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
