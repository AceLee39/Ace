// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.collections.CollectionUtils;

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
    public FormulaPanel(final List<FormulaElem> residualFormula, final List<FormulaElem> cuddingtonFormula) {
        this.setLayout(new BorderLayout());
        if (CollectionUtils.isNotEmpty(residualFormula)) {
            this.add(new JLabel("间接法 : "), BorderLayout.NORTH);
            final StringBuilder sb = new StringBuilder();
            sb.append("SCF1 = ");
            final boolean first = true;
            for (final FormulaElem fe : residualFormula) {
                if (!first) {
                    sb.append(" " + fe.getFlag() + " ");
                }
                sb.append(fe.getFieldId());
            }
        }
    }
}
