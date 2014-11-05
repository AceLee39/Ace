// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.collections.CollectionUtils;

import com.ace.capitalflows.constant.Constant;
import com.ace.capitalflows.entity.FormulaElem;

/**
 * @author Ace.Li
 *
 */
public class FormulaDetailPanel extends JPanel {
    List<FormulaElem> residuals = new ArrayList<FormulaElem>();
    List<FormulaElem> cuddingtons = new ArrayList<FormulaElem>();
    List<FormulaElem> ydResiduals = new ArrayList<FormulaElem>();
    /**
     * @param residualFormula
     * @param cuddingtonFormula
     */
    public FormulaDetailPanel(final Map<String, List<FormulaElem>> feMap) {
        this.setLayout(new GridLayout(20, 2));
        residuals = feMap.get(Constant.PTY_RESIDUALS);
        cuddingtons = feMap.get(Constant.PTY_CUDDINGTONS);
        ydResiduals = feMap.get(Constant.PTY_YD_RESIDUALS);
        builderLabel("月度规模参数（间接法）：", ydResiduals);
        builderLabel("直接法参数  : ", cuddingtons);
        this.add(new JLabel());
        builderLabel("间接法参数  : ", residuals);
    }

    /**
     * @param string
     * @param residuals
     */
    private void builderLabel(final String string, final List<FormulaElem> residuals) {
        if (CollectionUtils.isNotEmpty(residuals)) {
            this.add(new JLabel(string));
            this.add(new JLabel());
            for (final FormulaElem fe : residuals) {
                this.add(new JLabel(fe.getFieldId() + " : " + fe.getFieldLabel()));
            }
        }
    }
}
