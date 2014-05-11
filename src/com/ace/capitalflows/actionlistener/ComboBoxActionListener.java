// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.awt.event.ActionEvent;

import com.ace.capitalflows.ui.component.CustComboBoxPanel;
import com.ace.capitalflows.ui.frame.MainFrame;
import com.ace.capitalflows.utils.DataUtils;

/**
 * @author Administrator
 *
 */
public class ComboBoxActionListener extends AbstractActionListener{

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final CustComboBoxPanel comboBoxPanel = CustComboBoxPanel.getInstance();
        final String from = (String) comboBoxPanel.getFromCombobox().getSelectedItem();
        final String to = (String) comboBoxPanel.getToCombobox().getSelectedItem();
        updateTable(from, to);
    }

    private void updateTable(final String from, final String to) {
        final String[][] tableData = MainFrame.getInstance().getCurTabPanel().getTableData();
        final String[][] updateData = DataUtils.updataTableData(tableData, from, to);
        MainFrame.getInstance().getCurTabPanel().setTableModel(updateData);
    }
}
