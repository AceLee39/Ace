// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import java.io.File;

import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.excel.NianJdParseExcel;

/**
 * @author Administrator
 *
 */
public class ImportDataAction extends BaseAction<ImportDataActionContext> {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.action.BaseAction#process(com.ace.capitalflows.action.actioncontext.BaseActionContext)
     */
    @Override
    protected void process(final ImportDataActionContext actionContext) {
        final File importFile = actionContext.getImportFile();
        final NianJdParseExcel pe = new NianJdParseExcel();
        pe.parseExcel(importFile);
        actionContext.getDataModel().batchInsert(pe.getResiduals(), pe.getCuddingtons());
    }
}
