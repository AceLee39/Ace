// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.util.List;
import java.util.Vector;

/**
 * @author Administrator
 *
 */
public interface DaoModel {
    @SuppressWarnings("rawtypes")
    void batchInsert(List items);
    void deleteAll();
    @SuppressWarnings("rawtypes")
    List findAll();
    @SuppressWarnings("rawtypes")
    Vector findComboBoxData();
}
