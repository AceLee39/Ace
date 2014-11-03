// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.util.List;

import javax.swing.SwingUtilities;

import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.ui.frame.MainFrame;

/**
 * @author Administrator
 */
public class UpdateDataActionListener extends AbstractActionListener {

    /*
     * (non-Javadoc)
     * @see com.ace.capitalflows.actionlistener.AbstractActionListener#initParams()
     */
    @Override
    protected void initParams() {
        params.put(UpdateDataActionContext.KEY_CENTER_PANEL_NAME, MainFrame.getInstance().getCenterPanelName());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updatedFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final String[][] dataArray = (String[][]) params.get(UpdateDataActionContext.KEY_TABLE_DATA);
                MainFrame.getInstance().getCenterPanel().setTableModel(dataArray);
                final List<String> comboBoxDataList = (List<String>) params.get(UpdateDataActionContext.KEY_COMBOBOX_DATA);
                MainFrame.getInstance().getComboBoxPanel().updateData(comboBoxDataList);
                MainFrame.getInstance().repaint();
            }
        });
    }
}
