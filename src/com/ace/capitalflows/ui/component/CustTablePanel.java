// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        final DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
        // tcr.setHorizontalAlignment(JLabel.CENTER);
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
        table.setDefaultRenderer(Object.class, tcr);
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        table.setForeground(Color.green);
        table.getTableHeader().setForeground(Color.red);
        final double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        final double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        table.setPreferredScrollableViewportSize(new Dimension(((int)width-25), 550));
        table.setEnabled(Boolean.FALSE);
        final JScrollPane jsTable = new JScrollPane(table);
//        jsTable.setHorizontalScrollBar(new JScrollBar(JScrollBar.HORIZONTAL));
//        jsTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
        if (this.tableData == null || this.tableData.length == 0) {
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
