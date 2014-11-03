// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.constant;

/**
 * @author Ace.Li
 *
 */
public interface Constant {
    //ParseExcel
    public static final String PTY_YD_RESIDUALS = "ydResiduals";
    public static final String PTY_CUDDINGTONS = "cuddingtons";
    public static final String PTY_RESIDUALS = "residuals";
    public static final String PTY_QUARTER_SCALES = "quarterScales";
    //TAB
    public static final String CENTER_NIAN_JD = "NianJd/Scale";
    public static final String CENTER_NIAN_YD = "NianYd/Scale";
    public static final String CENTER_YEAR = "Year/Scale";
    public static final String CENTER_NIAN_D = "NianD";
    public static final String CENTER_NIAN_YD_DATA = "NianYd/Data";
    public static final String CENTER_YEAR_RESIDUAL_DATA = "Year/ResidualData";
    public static final String CENTER_YEAR_CUDDINGTON_DATA = "Year/CuddingtonData";
    public static final String CENTER_NIAN_JD_RESIDUAL_DATA = "NianJd/ResidualData";
    public static final String CENTER_NIAN_JD_CUDDINGTON_DATA = "NianJd/CuddingtonData";
    //DataModelPath
    public static final String DATA_MODEL_PATH = "com.ace.capitalflows.entity.model.%1$sDataModel";

    //ChartFramePath
    public static final String CHART_FRAME_PATH = "com.ace.capitalflows.ui.frame.chart.%1$sChartFrame";

    //Common
    public static final String SEPARATOR_SLASH = "/";
    String MODE_SCALE = "Scale";
    String MODE_DATA = "Data";

    //FORMULA
    String FORMULA_YEAR = "Year";
    String FORMULA_QUARTER = "Quarter";
    String FORMULA_MONTH = "Month";
}
