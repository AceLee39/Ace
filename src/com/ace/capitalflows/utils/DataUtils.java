// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.utils;


/**
 * @author Administrator
 *
 */
public class DataUtils {
    public static String[][] updataTableData(final String[][] items, String from, String to) {
        if (CommenUtils.compareString(from, to)) {
            final String temp = from;
            from = to;
            to = temp;
        }
        final String[][] updateTableDate = new String[items.length][];
        int i = 0;
        for (int j = 0; j < items.length; j++) {
            final String nianJd = items[j][0];
            if (CommenUtils.compareString(nianJd, from) && CommenUtils.compareString(to, nianJd)) {
                updateTableDate[i] = items[j];
                i++;
            }
        }
        return updateTableDate;
    }
}
