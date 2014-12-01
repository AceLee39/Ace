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
public class Cuddington {
    private int id;
    private String nianJD;
    private double s1;
    private double s2;
    private double s3;
    private double s4;
    private double s5;
    private double s6;
    private double s7;
    private double s8;
    private double s9;
    private double s10;
    private double s11;
    private double s12;
    private double s13;
    private double s14;
    private double s15;
    private boolean isNianJd;
    private String cuddington;
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
    public double getS1() {
        return s1;
    }
    public void setS1(final double s1) {
        this.s1 = s1;
    }
    public double getS2() {
        return s2;
    }
    public void setS2(final double s2) {
        this.s2 = s2;
    }
    public double getS3() {
        return s3;
    }
    public void setS3(final double s3) {
        this.s3 = s3;
    }
    public double getS4() {
        return s4;
    }
    public void setS4(final double s4) {
        this.s4 = s4;
    }

    public boolean isNianJd() {
        return isNianJd;
    }
    public void setNianJd(final boolean isNianJd) {
        this.isNianJd = isNianJd;
    }
    public double getS5() {
        return s5;
    }
    public void setS5(final double s5) {
        this.s5 = s5;
    }
    public double getS6() {
        return s6;
    }
    public void setS6(final double s6) {
        this.s6 = s6;
    }
    public double getS7() {
        return s7;
    }
    public void setS7(final double s7) {
        this.s7 = s7;
    }
    public double getS8() {
        return s8;
    }
    public void setS8(final double s8) {
        this.s8 = s8;
    }
    public double getS9() {
        return s9;
    }
    public void setS9(final double s9) {
        this.s9 = s9;
    }
    public double getS10() {
        return s10;
    }
    public void setS10(final double s10) {
        this.s10 = s10;
    }
    public double getS11() {
        return s11;
    }
    public void setS11(final double s11) {
        this.s11 = s11;
    }
    public double getS12() {
        return s12;
    }
    public void setS12(final double s12) {
        this.s12 = s12;
    }
    public double getS13() {
        return s13;
    }
    public void setS13(final double s13) {
        this.s13 = s13;
    }
    public double getS14() {
        return s14;
    }
    public void setS14(final double s14) {
        this.s14 = s14;
    }
    public double getS15() {
        return s15;
    }
    public void setS15(final double s15) {
        this.s15 = s15;
    }
    @Override
    public String toString() {
        return "Cuddington [id=" + id + ", nianJD=" + nianJD + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + ", s4="
                + s4 + ", s5=" + s5 + ", s6=" + s6 + ", s7=" + s7 + ", s8=" + s8 + ", s9=" + s9 + ", s10=" + s10
                + ", s11=" + s11 + ", s12=" + s12 + ", s13=" + s13 + ", s14=" + s14 + ", s15=" + s15 + "]";
    }

    public void setCuddington(final String cuddington) {
        this.cuddington = cuddington;
    }

    public void calculate() {
        this.cuddington = String.format("%.2f", s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 +s9 + s10 + s11 + s12 + s13 + s14 + s15);
    }

    public String getCuddington() {
        return this.cuddington;
    }
}
