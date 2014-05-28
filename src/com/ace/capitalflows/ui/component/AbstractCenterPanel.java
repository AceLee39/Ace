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
    protected final CustTablePanel tablePanel;
    protected final CustComboBoxPanel comboBoxPanel;
    protected Vector<String> comboBoxData;
    protected String centerPanelName;

    public AbstractCenterPanel() {
        centerPanelName = initCenterPanelName();
        dataModel = initDataModel();
        comboBoxData = initComboBoxData();
        comboBoxPanel = new CustComboBoxPanel(comboBoxData);
        this.add(comboBoxPanel, BorderLayout.NORTH);
        final String[][] tableData = initTableData();
        final String[] tableHeaderData = initTableHeader();
        tablePanel = new CustTablePanel();
        tablePanel.setTableModel(tableData, tableHeaderData);
        this.add(tablePanel, BorderLayout.CENTER);
    }

    /**
     * @return the centerPanelName
     */
    public String getCenterPanelName() {
        return centerPanelName;
    }

    protected abstract String initCenterPanelName();

    protected abstract DataModel initDataModel();

    protected abstract Vector<String> initComboBoxData();

    protected abstract String[][] initTableData();

    protected abstract String[] initTableHeader();

    public void setTableModel(final String[][] tableData) {
        tablePanel.setTableModel(tableData);
    }

    public void setComboBoxData(final Vector<String> comboBoxData) {
        this.comboBoxData = comboBoxData;
    }

    public String[][] getTableData() {
        return tablePanel.getTableData();
    }

    public String[][] getCurTableData() {
        return tablePanel.getCurTableData();
    }

    public Vector<String> getComboBoxData() {
        return comboBoxData;
    }

    /**
     * @return the comboBoxPanel
     */
    public CustComboBoxPanel getComboBoxPanel() {
        return comboBoxPanel;
    }
}
