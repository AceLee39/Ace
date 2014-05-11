// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.excel;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.constant.Constant;

/**
 * @author Ace.Li
 *
 */
public class ParseExcelFactory {

    public ParseExcel getParseExcel(final String curTabName) {
        if (StringUtils.equals(curTabName, Constant.TAB_NIAN_JD)) {
            return new NianJdParseExcel();
        }
        if (StringUtils.equals(curTabName, Constant.TAB_NIAN_YD)) {
            return new NianYdParseExcel();
        }
        return null;
    }

    private static class ParseExcelFactoryInstance {
        private static final ParseExcelFactory instance = new ParseExcelFactory();
    }

    public static ParseExcelFactory getInstance() {
        return ParseExcelFactoryInstance.instance;
    }
}
