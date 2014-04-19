// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.util.List;

import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.ui.component.CustComboBoxPanel;
import com.ace.capitalflows.ui.component.CustTablePanel;
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
        params.put(UpdateDataActionContext.KEY_CUR_TAB_NAME, MainFrame.getInstance().getCurTabName());
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void updatedFrame() {
        final String[][] dataArray = (String[][]) params.get(UpdateDataActionContext.KEY_TABLE_DATA);
        CustTablePanel.getInstance().setTableModel(dataArray);
        final List<String> comboBoxDataList = (List<String>) params.get(UpdateDataActionContext.KEY_COMBOBOX_DATA);
        CustComboBoxPanel.getInstance().updateData(comboBoxDataList);
        MainFrame.getInstance().repaint();
    }
}
