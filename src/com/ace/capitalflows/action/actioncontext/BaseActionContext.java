// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action.actioncontext;

import java.util.List;

import com.ace.capitalflows.entity.model.DataModel;
import com.ace.capitalflows.entity.model.DataModelFactory;

/**
 * @author Administrator
 *
 */
public class BaseActionContext implements ActionContext {
    public static final String KEY_TABLE_DATA = "tableData";
    public static final String KEY_COMBOBOX_DATA = "comboBoxData";
    public static final String KEY_CENTER_PANEL_NAME = "fileName";
    private String curTabName;
    private String[][] tableData;
    private List<String> comboBoxData;
    protected DataModel dataModel;

    /* (non-Javadoc)
     * @see com.ace.capitalflows.action.actioncontext.ActionContext#getObject()
     */
    @Override
    public Object getObject() {
        return null;
    }

    public DataModel getDataModel() {
        dataModel = DataModelFactory.getInstance().getDataModelByTabName(curTabName);
        return dataModel;
    }

    public String[][] getTableData() {
        return tableData;
    }
    public void setTableData(final String[][] tableData) {
        this.tableData = tableData;
    }
    public List<String> getComboBoxData() {
        return comboBoxData;
    }
    public void setComboBoxData(final List<String> comboBoxData) {
        this.comboBoxData = comboBoxData;
    }

    public String getCurTabName() {
        return curTabName;
    }

    public void setCurTabName(final String curTabName) {
        this.curTabName = curTabName;
    }
}
