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
public class YDResidual {
    private int id;
    private String nianYD;
    private double s;
    private double fdi;
    private double fbt;
    private String ydResidual;

    public YDResidual() {}

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNianYD() {
        return nianYD;
    }

    public void setNianYD(final String nianYD) {
        this.nianYD = nianYD;
    }

    public double getS() {
        return s;
    }

    public void setS(final double s) {
        this.s = s;
    }

    public double getFdi() {
        return fdi;
    }

    public void setFdi(final double fdi) {
        this.fdi = fdi;
    }

    public double getFbt() {
        return fbt;
    }

    public void setFbt(final double fbt) {
        this.fbt = fbt;
    }


    public String getYdResidual() {
        return ydResidual;
    }

    public void setYdResidual(final String ydResidual) {
        this.ydResidual = ydResidual;
    }

    public void calculate() {
        this.ydResidual = String.format("%.2f", s - (fdi + fbt));
    }

}
