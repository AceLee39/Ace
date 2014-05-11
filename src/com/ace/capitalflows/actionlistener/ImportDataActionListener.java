// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.ui.component.CustFileChooser;


/**
 * @author Administrator
 *
 */
public class ImportDataActionListener extends AbstractActionListener {

    /* (non-Javadoc)
     * @see com.ace.capitalflows.composer.AbstractActionListener#initParams()
     */
    @Override
    protected void initParams() {
        final CustFileChooser fileChooser = new CustFileChooser();
        final File file = fileChooser.getFile();
        if(file != null) {
            params.put(ImportDataActionContext.KEY_IMPORT_FILE, file);
            params.put(ImportDataActionContext.KEY_CUR_TAB_NAME, getCurTabName(file.getName()));
        }
    }

    private String getCurTabName(final String fileName) {
        if (fileName.endsWith(".xlsx")) {
            return StringUtils.substringBefore(fileName, ".xlsx");
        }
        if (fileName.endsWith(".xls")) {
            return StringUtils.substringBefore(fileName, ".xls");
        }
        return null;
    }
}
