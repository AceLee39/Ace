// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.FormulaElem;
import com.ace.capitalflows.ui.frame.ShowFormulaJFrame;

/**
 * @author Administrator
 *
 */
public class ShowFormulaActionListener implements ActionListener {
    private final String formula;
    private final String[] residualElems = new String[]{"S","L1","L2","L3","L4","L5","L6","L7","L8"
            ,"L9","L10","L11","L12","L13","L14","L15","L16"};
    private final String[] residualLabels = new String[]{"外汇占款增量（S）","职工报酬差额（L1）","各级政府差额(L2)"
            ,"资本帐户差额(L3)","我国在外直接投资差额(L4)","股本证券差额(L5)","(中)长期债券差额(L6)","(中)长期债券差额(L7)"
            ,"长期差额(L8)","长期差额(L9)","货币和存款差额(L10)","长期差额(L11)","长期差额(L12)"
            ,"长期差额(L13)","长期差额(L14)","FDI实际值（L15）","贸易中的实际顺差（L16）"};
    private final String[] cuddingtonElems = new String[]{"S1", "S2","S3","S4", "S5","S6","S7", "S8"
            ,"S9","S10", "S11","S12","S13", "S14","S15"};
    private final String[] cuddingtonLabels = new String[]{"投资收益差额(S1)","其它部门差额(S2)"
            ,"货币市场工具差额(S3)","股本证券差额(S4)","货币市场工具差额(S5)","短期差额(S6)"
            ,"短期差额(S7)","短期差额(S8)","短期差额(S9)","短期差额(S10)","货币和存款差额(S11)"
            ,"短期差额(S12)","FDI中短期资本（20%）（S13）","贸易中的短期资本(S14)","调整项（90%）（S15）"};
    private final String[] ydResidualElems = new String[]{"S","FDI","FBT"};
    private final String[] ydResidualLabels = new String[]{"外汇占款增量S（美元）","调整后FDI","实际贸易顺差FBT"};
    public ShowFormulaActionListener(final String formula) {
        this.formula = formula;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent arg0) {
        if (formula.equalsIgnoreCase(Constant.FORMULA_YEAR) || formula.equalsIgnoreCase(Constant.FORMULA_QUARTER)) {
            final List<FormulaElem> residualForm = buildResidualForm();
            final List<FormulaElem> cuddingtonForm = buildCuddingtonForm();
            final ShowFormulaJFrame sff = new ShowFormulaJFrame(formula,
                    residualForm, cuddingtonForm, null);
            sff.setVisible(true);
        } else if (formula.equalsIgnoreCase(Constant.FORMULA_MONTH)) {
            final List<FormulaElem> ydResidualForm = buildYdResidualForm();
            final ShowFormulaJFrame sff = new ShowFormulaJFrame(formula,
                    null, null, ydResidualForm);
            sff.setVisible(true);
        }
    }

    /**
     * @return
     */
    private List<FormulaElem> buildYdResidualForm() {
        final ArrayList<FormulaElem> ydResidualForm = new ArrayList<FormulaElem>();
        for (int i = 0, length=ydResidualElems.length; i < length; i++) {
            final FormulaElem fe = new FormulaElem("-", ydResidualElems[i], ydResidualLabels[i]);
            ydResidualForm.add(fe);
        }
        return ydResidualForm;
    }

    /**
     * @return
     */
    private List<FormulaElem> buildCuddingtonForm() {
        final ArrayList<FormulaElem> cuddingtonForm = new ArrayList<FormulaElem>();
        for (int i = 0, length=cuddingtonElems.length; i < length; i++) {
            final FormulaElem fe = new FormulaElem("+", cuddingtonElems[i], cuddingtonLabels[i]);
            cuddingtonForm.add(fe);
        }
        return cuddingtonForm;
    }

    /**
     * @return
     */
    private List<FormulaElem> buildResidualForm() {
        final ArrayList<FormulaElem> residualForm = new ArrayList<FormulaElem>();
        for (int i = 0, length=residualElems.length; i < length; i++) {
            final FormulaElem fe = new FormulaElem("-", residualElems[i], residualLabels[i]);
            residualForm.add(fe);
        }
        return residualForm;
    }

}
