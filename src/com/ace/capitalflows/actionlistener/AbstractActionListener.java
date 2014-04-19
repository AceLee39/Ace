// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.ui.action.UIActionExecute;
import com.ace.capitalflows.ui.component.CustComboBoxPanel;
import com.ace.capitalflows.ui.component.CustTablePanel;
import com.ace.capitalflows.ui.frame.MainFrame;

/**
 * @author Administrator
 *
 */
public abstract class AbstractActionListener implements ActionListener {
    protected final Map<String, Object> params = new HashMap<>();


    /* (non-Javadoc)
     * @see com.ace.capitalflows.composer.Composer#doUpdated()
     */
    public void doUpdated() {
        initParams();
        doUIAction();
        updatedFrame();
    }


    @Override
    public void actionPerformed(final ActionEvent e) {
        doUpdated();
    }




    /**
     *
     */
    protected void updatedFrame() {
        if (StringUtils.equals(params.get(ImportDataActionContext.KEY_CUR_TAB_NAME).toString(),
                MainFrame.getInstance().getCurTabName())) {
            repaintFrame();
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    private void repaintFrame() {
        final Map<String, Object> updateParams = new HashMap<String, Object>();
        updateParams.put(BaseActionContext.KEY_CUR_TAB_NAME, params.get(ImportDataActionContext.KEY_CUR_TAB_NAME));
        UIActionExecute.execute("UpdateDataActionListener", updateParams);
        final String[][] dataArray = (String[][]) updateParams.get(UpdateDataActionContext.KEY_TABLE_DATA);
        CustTablePanel.getInstance().setTableModel(dataArray);
        final List<String> comboBoxDataList = (List<String>) updateParams.get(UpdateDataActionContext.KEY_COMBOBOX_DATA);
        CustComboBoxPanel.getInstance().updateData(comboBoxDataList);
        MainFrame.getInstance().repaint();
    }


    /**
     *
     */
    protected void initParams() {

    }

    /**
     *
     */
    protected void doUIAction() {
        UIActionExecute.execute(this.getClass().getSimpleName(), params);
    }

}
