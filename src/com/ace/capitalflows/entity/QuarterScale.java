// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity;

/**
 * @author Administrator
 *
 */
public class QuarterScale {
    private int id;
    private String nianJD;
    private String residual;
    private String cuddington;
    private boolean isNianJd;
    public QuarterScale() {}
    public boolean isNianJd() {
        return isNianJd;
    }

    public void setNianJd(final boolean isNianJd) {
        this.isNianJd = isNianJd;
    }


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNianJD() {
        return nianJD;
    }

    public void setNianJD(final String nianJD) {
        this.nianJD = nianJD;
    }

    public String getResidual() {
        return residual;
    }

    public void setResidual(final String residual) {
        this.residual = residual;
    }

    public String getCuddington() {
        return cuddington;
    }

    public void setCuddington(final String cuddington) {
        this.cuddington = cuddington;
    }

}
