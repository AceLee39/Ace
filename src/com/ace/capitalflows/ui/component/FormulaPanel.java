// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.GridLayout;
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
public class FormulaPanel extends JPanel {

    /**
     * @param residualFormula
     * @param cuddingtonFormula
     */
    public FormulaPanel(final Map<String, List<FormulaElem>> feMap) {
        this.setLayout(new GridLayout(2, 4));
        final List<FormulaElem> residualFormula = feMap.get(Constant.PTY_RESIDUALS);
        final List<FormulaElem> cuddingtonFormula = feMap.get(Constant.PTY_CUDDINGTONS);
        final List<FormulaElem> ydResidualFormula = feMap.get(Constant.PTY_YD_RESIDUALS);

        builderLabel("直接法 : ", "SCF1 = ", cuddingtonFormula);
        builderLabel("间接法 : ", "SCF2 = ", residualFormula);
        builderLabel("月度规模计算公式（只用间接法）：", "SCF2 = ", ydResidualFormula);
    }

    /**
     * @param string
     * @param string2
     * @param formulas
     */
    private void builderLabel(final String string, final String string2, final List<FormulaElem> formulas) {
        if (CollectionUtils.isNotEmpty(formulas)) {
            this.add(new JLabel(string, JLabel.CENTER));
            final StringBuilder sb = new StringBuilder();
            sb.append(string2);
            boolean first = true;
            for (final FormulaElem fe : formulas) {
                if (!first) {
                    sb.append(" " + fe.getFlag() + " ");
                }
                first = false;
                sb.append(fe.getFieldId());
            }
            this.add(new JLabel(sb.toString(), JLabel.CENTER));
        }
    }
}
