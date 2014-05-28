// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.action;

import java.io.File;
import java.util.Map;

import com.ace.capitalflows.action.ActionDispatch;
import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;

/**
 * @author Administrator
 *
 */
public class ImportDataUIAction extends AbstractUIAction {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.action.AbstractUIAction#process(java.util.Map)
     */
    @Override
    protected void process(final Map<String, Object> params) {
        final ImportDataActionContext importData = new ImportDataActionContext();
        final File file = (File) params.get(ImportDataActionContext.KEY_IMPORT_FILE);
        if (file == null) {
            return;
        }
        importData.setImportFile(file);
        importData.setCurTabName(params.get(ImportDataActionContext.KEY_CENTER_PANEL_NAME).toString());
        ActionDispatch.execute(importData);
    }
}
