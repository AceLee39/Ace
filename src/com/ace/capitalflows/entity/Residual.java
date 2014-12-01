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
public class Residual {
    private int id;
    private String nianJD;
    private double s;
    private double l1;
    private double l2;
    private double l3;
    private double l4;
    private double l5;
    private double l6;
    private double l7;
    private double l8;
    private double l9;
    private double l10;
    private double l11;
    private double l12;
    private double l13;
    private double l14;
    private double l15;
    private double l16;
    private boolean isNianJd;
    private String residual;

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
    public double getS() {
        return s;
    }
    public void setS(final double s) {
        this.s = s;
    }
    public double getL1() {
        return l1;
    }
    public void setL1(final double l1) {
        this.l1 = l1;
    }
    public double getL2() {
        return l2;
    }
    public void setL2(final double l2) {
        this.l2 = l2;
    }
    public double getL3() {
        return l3;
    }
    public void setL3(final double l3) {
        this.l3 = l3;
    }
    public double getL4() {
        return l4;
    }
    public void setL4(final double l4) {
        this.l4 = l4;
    }
    public double getL5() {
        return l5;
    }
    public void setL5(final double l5) {
        this.l5 = l5;
    }
    public double getL6() {
        return l6;
    }
    public void setL6(final double l6) {
        this.l6 = l6;
    }
    public double getL7() {
        return l7;
    }
    public void setL7(final double l7) {
        this.l7 = l7;
    }
    public double getL8() {
        return l8;
    }
    public void setL8(final double l8) {
        this.l8 = l8;
    }
    public double getL9() {
        return l9;
    }
    public void setL9(final double l9) {
        this.l9 = l9;
    }
    public double getL10() {
        return l10;
    }
    public void setL10(final double l10) {
        this.l10 = l10;
    }
    public double getL11() {
        return l11;
    }
    public void setL11(final double l11) {
        this.l11 = l11;
    }
    public double getL12() {
        return l12;
    }
    public void setL12(final double l12) {
        this.l12 = l12;
    }
    public double getL13() {
        return l13;
    }
    public void setL13(final double l13) {
        this.l13 = l13;
    }
    public double getL14() {
        return l14;
    }
    public void setL14(final double l14) {
        this.l14 = l14;
    }
    public double getL15() {
        return l15;
    }
    public void setL15(final double l15) {
        this.l15 = l15;
    }
    public double getL16() {
        return l16;
    }
    public void setL16(final double l16) {
        this.l16 = l16;
    }
    @Override
    public String toString() {
        return "Residual [id=" + id + ", nianJD=" + nianJD + ", s=" + s + ", l1=" + l1 + ", l2=" + l2 + ", l3=" + l3
                + ", l4=" + l4 + ", l5=" + l5 + ", l6=" + l6 + ", l7=" + l7 + ", l8=" + l8 + ", l9=" + l9 + ", l10="
                + l10 + ", l11=" + l11 + ", l12=" + l12 + ", l13=" + l13 + ", l14=" + l14 + ", l15=" + l15 + ", l16="
                + l16 + "]";
    }

    public void calculate() {
        this.residual = String.format("%.2f", s - (l1 + l2 + l3 + l4 + l5 + l6 + l7 + l8 + l9 + l10 + l11 + l12 + l13 + l14 + l15 + l16));
    }

    public void setResidual(final String residual) {
        this.residual = residual;
    }

    public String getResidual() {
        return this.residual;
    }

}
