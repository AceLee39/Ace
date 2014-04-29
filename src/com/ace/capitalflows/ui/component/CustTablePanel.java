// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CustTablePanel extends JPanel {
    private final JTable table = new JTable();
    private TableModel tableModel;
    private String[][] tableData;
    private String[] tableHeaderData;
    private String[][] curTableData;

    public CustTablePanel() {
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        final JScrollPane jsTable = new JScrollPane(table);
        this.add(jsTable);
    }

    public void setTableModel(final String[][] tableData, final String[] tableHeaderData) {
        this.tableData = tableData;
        this.curTableData = tableData;
        this.tableHeaderData = tableHeaderData;
        tableModel = new DefaultTableModel(tableData, tableHeaderData);
        table.setModel(tableModel);
    }

    public void setTableModel(final String[][] tableData) {
        if (this.tableData.length == 0) {
            this.tableData = tableData;
        }
        this.curTableData = tableData;
        tableModel = new DefaultTableModel(tableData, tableHeaderData);
        table.setModel(tableModel);
    }


    public String[][] getCurTableData() {
        return curTableData;
    }

    public void setCurTableData(final String[][] curTableData) {
        this.curTableData = curTableData;
    }

    public String[][] getTableData() {
        return tableData;
    }

    public void setTableData(final String[][] tableData) {
        this.tableData = tableData;
        this.setTableModel(tableData);
    }

    public String[] getTableHeaderData() {
        return tableHeaderData;
    }

    public void setTableHeaderData(final String[] tableHeaderData) {
        this.tableHeaderData = tableHeaderData;
    }

}
