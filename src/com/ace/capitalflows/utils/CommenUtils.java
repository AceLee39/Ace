// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Administrator
 *
 */
public class CommenUtils {
    private static final String SUB_Q = "Q";
    public static int parseNianJD(final String nianJD) {
        final String nian = StringUtils.substringBefore(nianJD, SUB_Q);
        final String jd = StringUtils.substringAfter(nianJD, SUB_Q);
        final String nianJd = nian + jd;
        return NumberUtils.toInt(nianJd, 0);
    }

    public static int parseNian(final String nianJD) {
        final String nian = StringUtils.substringBefore(nianJD, SUB_Q);
        return NumberUtils.toInt(nian, 0);
    }

    public static int parseJD(final String nianJD) {
        final String jd = StringUtils.substringAfter(nianJD, SUB_Q);
        return NumberUtils.toInt(jd, 1);
    }

    public static boolean compareString(final String from, final String to) {
        return from.compareTo(to) > -1;
    }
}
