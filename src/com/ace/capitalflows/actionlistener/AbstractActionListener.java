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
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.ui.action.UIActionExecute;
import com.ace.capitalflows.ui.component.CustComboBoxPanel;
import com.ace.capitalflows.ui.frame.MainFrame;

/**
 * @author Administrator
 *
 */
public abstract class AbstractActionListener implements ActionListener {
    protected final Map<String, Object> params = new HashMap<String, Object>();


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
        repaintFrame();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    private void repaintFrame() {
        final Map<String, Object> updateParams = new HashMap<String, Object>();
        final String tabName = (String) params.get(ImportDataActionContext.KEY_CUR_TAB_NAME);
        if(StringUtils.isBlank(tabName)) {
            return;
        }
        updateParams.put(BaseActionContext.KEY_CUR_TAB_NAME, tabName);
        UIActionExecute.execute("UpdateDataActionListener", updateParams);
        final String[][] dataArray = (String[][]) updateParams.get(UpdateDataActionContext.KEY_TABLE_DATA);
        final List<String> comboBoxDataList = (List<String>) updateParams.get(UpdateDataActionContext.KEY_COMBOBOX_DATA);
        MainFrame.getInstance().getCenterPanel(tabName).setTableModel(dataArray);
        MainFrame.getInstance().getCenterPanel(tabName).setComboBoxData(new Vector<String>(comboBoxDataList));
        if (StringUtils.equals(tabName, MainFrame.getInstance().getCurTabName())) {
            CustComboBoxPanel.getInstance().setNeedReset(Boolean.TRUE);
            CustComboBoxPanel.getInstance().updateData(comboBoxDataList);
            CustComboBoxPanel.getInstance().setNeedReset(Boolean.FALSE);
        }
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
