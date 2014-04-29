// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;

import com.ace.capitalflows.entity.model.DataModel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractCenterPanel extends JPanel {
    protected final DataModel dataModel;
    final CustTablePanel tablePanel;

    public AbstractCenterPanel() {
        dataModel = initDataModel();
        final Vector<String> comboBoxData = initComboBoxData();
        final CustComboBoxPanel comboBoxPanel = CustComboBoxPanel.getInstance();
        comboBoxPanel.setComboBoxData(comboBoxData);
        final String[][] tableData = initTableData();
        final String[] tableHeaderData = initTableHeader();
        tablePanel = new CustTablePanel();
        tablePanel.setTableModel(tableData, tableHeaderData);
        this.add(tablePanel, BorderLayout.CENTER);
    }

    protected abstract DataModel initDataModel();

    protected abstract Vector<String> initComboBoxData();

    protected abstract String[][] initTableData();

    protected abstract String[] initTableHeader();

}
