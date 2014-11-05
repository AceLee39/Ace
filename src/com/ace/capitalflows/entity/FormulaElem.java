// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.entity;

/**
 * @author Ace.Li
 *
 */
public class FormulaElem {
    private String flag;
    private String fieldId;
    private String fieldLabel;

    public FormulaElem(final String flag, final String fieldId, final String fieldLabel) {
        this.flag = flag;
        this.fieldId = fieldId;
        this.fieldLabel = fieldLabel;
    }
    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }
    /**
     * @param flag the flag to set
     */
    public void setFlag(final String flag) {
        this.flag = flag;
    }
    /**
     * @return the fieldId
     */
    public String getFieldId() {
        return fieldId;
    }
    /**
     * @param fieldId the fieldId to set
     */
    public void setFieldId(final String fieldId) {
        this.fieldId = fieldId;
    }
    /**
     * @return the fieldLabel
     */
    public String getFieldLabel() {
        return fieldLabel;
    }
    /**
     * @param fieldLabel the fieldLabel to set
     */
    public void setFieldLabel(final String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }
}
