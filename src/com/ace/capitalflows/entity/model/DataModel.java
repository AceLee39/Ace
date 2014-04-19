// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import java.util.List;
import java.util.Vector;

/**
 * @author Administrator
 *
 */
public interface DataModel {
    String[][] getTableData();
    Vector<String> getComboBoxData();
    @SuppressWarnings("rawtypes")
    void batchInsert(List ...lists);
    void deleteAll();
}
