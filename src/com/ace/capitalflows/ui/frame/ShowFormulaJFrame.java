// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.ace.capitalflows.entity.FormulaElem;
import com.ace.capitalflows.ui.component.FormulaDetailPanel;
import com.ace.capitalflows.ui.component.FormulaPanel;


/**
 * @author Administrator
 *
 */
public class ShowFormulaJFrame extends JFrame {
    protected final Container container;
    List<FormulaElem> residualFormula = new ArrayList<FormulaElem>();
    List<FormulaElem> cuddingtonFormula = new ArrayList<FormulaElem>();
    private FormulaPanel formula;
    private FormulaDetailPanel formulaDetail;
    /**
     * @param title
     */
    public ShowFormulaJFrame(final String title, final List<FormulaElem> residualFormula, final List<FormulaElem> cuddingtonFormula) {
        this.residualFormula = residualFormula;
        this.cuddingtonFormula = cuddingtonFormula;
        this.container = this.getContentPane();
        initComponent();
        addButtonActionListener();
        addIntoContainer();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
    }

    /**
     *
     */
    private void addButtonActionListener() {

    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#addIntoContainer()
     */
    private void addIntoContainer() {
        container.setLayout(new BorderLayout());
        this.add(formula, BorderLayout.NORTH);
        this.add(formulaDetail, BorderLayout.CENTER);
    }

    /* (non-Javadoc)
     * @see com.ace.capitalflows.ui.frame.BaseFrame#initComponent()
     */
    private void initComponent() {
        formula = new FormulaPanel(residualFormula, cuddingtonFormula);
        formulaDetail = new FormulaDetailPanel(residualFormula, cuddingtonFormula);
    }
}
