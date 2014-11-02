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
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.Cuddington;
import com.ace.capitalflows.entity.QuarterScale;
import com.ace.capitalflows.entity.Residual;

/**
 * @author Ace.Li
 *
 */
public class NianDParseExcel extends ParseExcel{
    private final List<Cuddington> cuddingtons = new ArrayList<Cuddington>();
    private final List<Residual> residuals = new ArrayList<Residual>();
    private final List<QuarterScale> quarterScales = new ArrayList<QuarterScale>();

    /**
     * @param row
     */
    @Override
    protected void parseRow(final XSSFRow row) {
        final QuarterScale quarterScale = new QuarterScale();
        final Cuddington cuddington = new Cuddington();
        cuddington.setNianJD(row.getCell(0).toString());
        cuddington.setS1(toDouble(row.getCell(2)));
        cuddington.setS2(toDouble(row.getCell(4)));
        cuddington.setS3(toDouble(row.getCell(11)));
        cuddington.setS4(toDouble(row.getCell(12)));
        cuddington.setS5(toDouble(row.getCell(14)));
        cuddington.setS6(toDouble(row.getCell(16)));
        cuddington.setS7(toDouble(row.getCell(18)));
        cuddington.setS8(toDouble(row.getCell(21)));
        cuddington.setS9(toDouble(row.getCell(23)));
        cuddington.setS10(toDouble(row.getCell(25)));
        cuddington.setS11(toDouble(row.getCell(26)));
        cuddington.setS12(toDouble(row.getCell(28)));
        cuddington.setS13(toDouble(row.getCell(7)));
        cuddington.setS14(toDouble(row.getCell(30)));
        cuddington.setS15(toDouble(row.getCell(29)));
        cuddington.setNianJd(Boolean.FALSE);
        cuddington.calculate();
        quarterScale.setNianJD(cuddington.getNianJD());
        quarterScale.setCuddington(cuddington.getCuddington());
        cuddingtons.add(cuddington);
        final Residual residual = new Residual();
        residual.setNianJD(row.getCell(0).toString());
        residual.setS(toDouble(row.getCell(32)));
        residual.setL1(toDouble(row.getCell(1)));
        residual.setL2(toDouble(row.getCell(3)));
        residual.setL3(toDouble(row.getCell(5)));
        residual.setL4(toDouble(row.getCell(6)));
        residual.setL5(toDouble(row.getCell(9)));
        residual.setL6(toDouble(row.getCell(10)));
        residual.setL7(toDouble(row.getCell(13)));
        residual.setL8(toDouble(row.getCell(15)));
        residual.setL9(toDouble(row.getCell(17)));
        residual.setL10(toDouble(row.getCell(19)));
        residual.setL11(toDouble(row.getCell(20)));
        residual.setL12(toDouble(row.getCell(22)));
        residual.setL13(toDouble(row.getCell(24)));
        residual.setL14(toDouble(row.getCell(27)));
        residual.setL15(toDouble(row.getCell(8)));
        residual.setL16(toDouble(row.getCell(31)));
        residual.setNianJd(Boolean.FALSE);
        residual.calculate();
        quarterScale.setResidual(residual.getResidual());
        residuals.add(residual);
        quarterScale.setNianJd(Boolean.FALSE);
        quarterScales.add(quarterScale);
    }


    private double toDouble(final XSSFCell xssfCell) {
        return Double.valueOf(xssfCell.getRawValue());
    }

    /**
     * @return the cuddingtons
     */
    public List<Cuddington> getCuddingtons() {
        return cuddingtons;
    }


    public List<QuarterScale> getQuarterScales() {
        return quarterScales;
    }

    /**
     * @return the residuals
     */
    public List<Residual> getResiduals() {
        return residuals;
    }


    /* (non-Javadoc)
     * @see com.ace.capitalflows.excel.ParseExcel#getResult()
     */
    @Override
    public Map<String, Object> getResult() {
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constant.PTY_CUDDINGTONS, cuddingtons);
        result.put(Constant.PTY_RESIDUALS, residuals);
        result.put(Constant.PTY_QUARTER_SCALES, quarterScales);
        return result;
    }

    /**
     * @param importSheet
     */
    @Override
    protected void parseSheet(final XSSFSheet importSheet) {
        final int lastRowNum = importSheet.getLastRowNum() + 2;
        System.out.println("lastRowNum : " + lastRowNum);
        for (int i = 1; i < lastRowNum-1; i++) {
            final XSSFRow row = importSheet.getRow(i);
            parseRow(row);
        }
    }
}
