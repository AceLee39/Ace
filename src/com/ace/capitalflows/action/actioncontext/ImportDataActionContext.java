// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action.actioncontext;

import java.io.File;

/**
 * @author Administrator
 *
 */
public class ImportDataActionContext extends BaseActionContext{
    public static final String KEY_IMPORT_FILE = "importFile";
    private File importFile;

    public File getImportFile() {
        return importFile;
    }
    public void setImportFile(final File importFile) {
        this.importFile = importFile;
    }
}
