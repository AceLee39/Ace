// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.frame.chart;

import org.apache.commons.lang.StringUtils;
import org.jfree.ui.ApplicationFrame;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.ui.frame.MainFrame;


/**
 * @author Ace.Li
 *
 */
public class ChartFactory {
    private static class ChartFactoryInstance {
        private static final ChartFactory instance = new ChartFactory();
    }

    public static ChartFactory getInstance() {
        return ChartFactoryInstance.instance;
    }

    public ApplicationFrame getChart(final String[][] dataArray) {
        if (StringUtils.equals(MainFrame.getInstance().getCenterPanelName(), Constant.CENTER_NIAN_JD)) {
            return new NianJdChart("中国国际收支平衡", dataArray);
        }
        if (StringUtils.equals(MainFrame.getInstance().getCenterPanelName(), Constant.CENTER_NIAN_YD)) {
            return new NianYdChart("中国国际收支平衡", dataArray);
        }
        return null;
    }
}
