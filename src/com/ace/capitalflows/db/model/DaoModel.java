// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.Residual;

/**
 * @author Administrator
 *
 */
public interface DaoModel {
    public List<Cuddington> findCuddingtons();
    public List<Residual> findResiduals();
    public void batchInsert(Map<String, Object> result);
    public void deleteAll();
    @SuppressWarnings("rawtypes")
    public List findScaleAll();
    @SuppressWarnings("rawtypes")
    public List findDataAll();
    @SuppressWarnings("rawtypes")
    public Vector findComboBoxData();
    public void setNianJd(boolean isNianJd);
}
