// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.YDResidual;

/**
 * @author Ace.Li
 *
 */
public class NianYdParseExcel extends ParseExcel{
    private final List<YDResidual> ydResiduals = new ArrayList<YDResidual>();

    /**
     * @param row
     */
    @Override
    protected void parseRow(final XSSFRow row) {
        final YDResidual ydResidual = new YDResidual();
        ydResidual.setNianYD(row.getCell(0).toString());
        ydResidual.setS(toDouble(row.getCell(1)));
        ydResidual.setFdi(toDouble(row.getCell(2)));
        ydResidual.setFbt(toDouble(row.getCell(3)));
        ydResidual.calculate();
        ydResiduals.add(ydResidual);
    }


    private double toDouble(final XSSFCell xssfCell) {
        return Double.valueOf(xssfCell.getRawValue());
    }


    public List<YDResidual> getYdResiduals() {
        return ydResiduals;
    }


    /* (non-Javadoc)
     * @see com.ace.capitalflows.excel.ParseExcel#getResult()
     */
    @Override
    public Map<String, Object> getResult() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constant.PTY_YD_RESIDUALS, ydResiduals);
        return result;
    }
}
