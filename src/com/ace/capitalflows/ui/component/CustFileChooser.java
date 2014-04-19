// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CustFileChooser extends JFileChooser {

    public File getFile() {
        File file = null;
        this.setFileSelectionMode(JFileChooser.FILES_ONLY);
        final int selected = this.showOpenDialog(null);
        if(selected == JFileChooser.APPROVE_OPTION) {
            file = this.getSelectedFile();
        }
        return file;
    }
}
