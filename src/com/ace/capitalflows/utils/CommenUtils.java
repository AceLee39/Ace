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
    private static final String SUB_FORWARD_SLASH = "/";

    public static int parseNianYD(final String nianYD) {
        final String nian = StringUtils.substringBefore(nianYD, SUB_FORWARD_SLASH);
        final String yd = StringUtils.substringAfter(nianYD, SUB_FORWARD_SLASH);
        final String nianYd = nian + yd;
        return NumberUtils.toInt(nianYd, 0);
    }


    public static int parseNianJD(final String nianJD) {
        final String nian = StringUtils.substringBefore(nianJD, SUB_Q);
        final String jd = StringUtils.substringAfter(nianJD, SUB_Q);
        final String nianJd = nian + jd;
        return NumberUtils.toInt(nianJd, 0);
    }

    public static int parseNian(final String nianJD) {
        if (nianJD.contains(SUB_FORWARD_SLASH)) {
            return NumberUtils.toInt(StringUtils.substringBefore(nianJD, SUB_FORWARD_SLASH), 0);
        }
        if (nianJD.contains(SUB_Q)) {
            return NumberUtils.toInt(StringUtils.substringBefore(nianJD, SUB_Q), 0);
        }
        return 0;
    }

    public static int parseJDORYD(final String nianJD) {
        if (nianJD.contains(SUB_FORWARD_SLASH)) {
            return NumberUtils.toInt(StringUtils.substringAfter(nianJD, SUB_FORWARD_SLASH), 0);
        }
        if (nianJD.contains(SUB_Q)) {
            return NumberUtils.toInt(StringUtils.substringAfter(nianJD, SUB_Q), 0);
        }
        return 0;
    }

    public static boolean compareString(final String from, final String to) {
        if (from.contains(SUB_FORWARD_SLASH)) {
            return parseNianYD(from) >= parseNianYD(to);
        }
        if (from.contains(SUB_Q)) {
            return parseNianJD(from) >= parseNianJD(to);
        }
        return from.compareTo(to) > -1;
    }
}
