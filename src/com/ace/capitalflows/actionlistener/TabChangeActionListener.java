// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ace.capitalflows.ui.component.CustComboBoxPanel;
import com.ace.capitalflows.ui.frame.MainFrame;
import com.ace.capitalflows.utils.DataUtils;

/**
 * @author Administrator
 *
 */
public class TabChangeActionListener implements ChangeListener{

    private void updateTable(final String from, final String to) {
        final String[][] tableData = MainFrame.getInstance().getCurTabPanel().getTableData();
        final String[][] updateData = DataUtils.updataTableData(tableData, from, to);
        MainFrame.getInstance().getCurTabPanel().setTableModel(updateData);
    }

    /* (non-Javadoc)
     * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
     */
    @Override
    public void stateChanged(final ChangeEvent e) {
        final CustComboBoxPanel comboBoxPanel = CustComboBoxPanel.getInstance();
        final String from = (String) comboBoxPanel.getFromCombobox().getSelectedItem();
        final String to = (String) comboBoxPanel.getToCombobox().getSelectedItem();
        updateTable(from, to);
    }
}
