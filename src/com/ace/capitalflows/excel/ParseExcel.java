// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Administrator
 *
 */
public abstract class ParseExcel {
    public void parseExcel(final File uploadFile) {
        try {
            if (uploadFile != null) {
                final XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(uploadFile));
                final XSSFSheet importSheet = wb.getSheet("import");
                parseSheet(importSheet);
            }
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param importSheet
     */
    private void parseSheet(final XSSFSheet importSheet) {
        final int lastRowNum = importSheet.getLastRowNum();
        for (int i = 1; i < lastRowNum-1; i++) {
            final XSSFRow row = importSheet.getRow(i);
            parseRow(row);
        }
    }

    /**
     * @param row
     */
    protected void parseRow(final XSSFRow row) {
    }

    public abstract Map<String, Object> getResult();

}
