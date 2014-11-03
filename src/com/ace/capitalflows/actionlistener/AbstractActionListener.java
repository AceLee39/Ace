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

import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.BaseActionContext;
import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.action.actioncontext.UpdateDataActionContext;
import com.ace.capitalflows.ui.action.UIActionExecute;
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
        final String centerPanelName = (String) params.get(ImportDataActionContext.KEY_CENTER_PANEL_NAME);
        if(StringUtils.isBlank(centerPanelName)) {
            return;
        }
        updateParams.put(BaseActionContext.KEY_CENTER_PANEL_NAME, centerPanelName);
        UIActionExecute.execute("UpdateDataActionListener", updateParams);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final String[][] dataArray = (String[][]) updateParams.get(UpdateDataActionContext.KEY_TABLE_DATA);
                final List<String> comboBoxDataList = (List<String>) updateParams.get(UpdateDataActionContext.KEY_COMBOBOX_DATA);
                MainFrame.getInstance().getCenterPanel().setTableModel(dataArray);
                MainFrame.getInstance().getCenterPanel().setComboBoxData(new Vector<String>(comboBoxDataList));
                if (StringUtils.equals(centerPanelName, MainFrame.getInstance().getCenterPanelName())) {
                    MainFrame.getInstance().getCenterPanel().getComboBoxPanel().updateData(comboBoxDataList);
                }
                MainFrame.getInstance().repaint();
            }
        });
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
