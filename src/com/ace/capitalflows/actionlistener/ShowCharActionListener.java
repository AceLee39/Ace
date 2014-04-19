// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import org.jfree.ui.RefineryUtilities;

import com.ace.capitalflows.ui.component.CustTablePanel;
import com.ace.capitalflows.ui.frame.TimeSeriesChart;

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
        final String[][] dataArray = CustTablePanel.getInstance().getCurTableData();
        final TimeSeriesChart demo = new TimeSeriesChart("中国国际收支平衡", dataArray);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
