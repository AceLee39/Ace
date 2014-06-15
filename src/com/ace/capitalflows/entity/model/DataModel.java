// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.Map;
import java.util.Vector;

import com.ace.capitalflows.db.model.DaoModel;

/**
 * @author Administrator
 *
 */
public interface DataModel {
    String[][] getTableData();
    Vector<String> getComboBoxData();
    void batchInsert(Map<String, Object> result);
    void deleteAll();
    void setMode(String mode);
    void setNianJd(boolean isNianJd);
    DaoModel getDaoModel();
    void setResidual(boolean isResidual);
}
