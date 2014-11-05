// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.ace.capitalflows.constant.Constant;
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
    List<FormulaElem> ydResidualFormula = new ArrayList<FormulaElem>();
    private FormulaPanel formula;
    private FormulaDetailPanel formulaDetail;
    /**
     * @param title
     */
    public ShowFormulaJFrame(final String title, final List<FormulaElem> residualFormula
            , final List<FormulaElem> cuddingtonFormula, final List<FormulaElem> ydResidualFormula) {
        this.residualFormula = residualFormula;
        this.cuddingtonFormula = cuddingtonFormula;
        this.ydResidualFormula = ydResidualFormula;
        this.container = this.getContentPane();
        initComponent();
        addButtonActionListener();
        addIntoContainer();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        final double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        this.setSize((int)width/4*3,(int)height/2);//设置大小
        this.setLocation(0,0); //设置窗体居中显示
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
        final Map<String, List<FormulaElem>> feMap = new HashMap<String, List<FormulaElem>>();
        feMap.put(Constant.PTY_RESIDUALS, residualFormula);
        feMap.put(Constant.PTY_YD_RESIDUALS, ydResidualFormula);
        feMap.put(Constant.PTY_CUDDINGTONS, cuddingtonFormula);
        formula = new FormulaPanel(feMap);
        formulaDetail = new FormulaDetailPanel(feMap);
    }
}
