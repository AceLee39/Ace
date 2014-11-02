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
import com.ace.capitalflows.constant.Constant;
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
            String fileName = getFileName(file.getName());
            if (StringUtils.equals(fileName, "NianD")) {
                fileName = Constant.CENTER_YEAR;
            }
            params.put(ImportDataActionContext.KEY_CENTER_PANEL_NAME, fileName);
        }
    }

    private String getFileName(final String fileName) {
        if (fileName.endsWith(".xlsx")) {
            return StringUtils.substringBefore(fileName, ".xlsx");
        }
        if (fileName.endsWith(".xls")) {
            return StringUtils.substringBefore(fileName, ".xls");
        }
        return null;
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.actionlistener.AbstractActionListener#updatedFrame()
     */
    /*@Override
    protected void updatedFrame() {
    }*/
}
