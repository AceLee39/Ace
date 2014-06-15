// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.ace.capitalflows.actionlistener.CustMenuActionListener;
import com.ace.capitalflows.actionlistener.DeleteAllDataActionListener;
import com.ace.capitalflows.actionlistener.ImportDataActionListener;
import com.ace.capitalflows.actionlistener.ShowCharActionListener;
import com.ace.capitalflows.actionlistener.UpdateDataActionListener;
import com.ace.capitalflows.constant.UILabelConstant;

/**
 * @author Ace.Li
 *
 */
@SuppressWarnings("serial")
public class CustMenuBar extends JMenuBar {
    private JMenuItem yearResidualData;
    private JMenuItem yearCuddingtonData;
    private JMenuItem quarterResidualData;
    private JMenuItem quarterCuddingtonData;
    private JMenuItem monthData;

    private JMenuItem yearFormula;
    private JMenuItem quarterFormula;
    private JMenuItem monthFormula;

    private JMenuItem yearScale;
    private JMenuItem quarterScale;
    private JMenuItem monthScale;

    private JMenuItem importData;
    private JMenuItem update;
    private JMenuItem deleteAll;
    private JMenuItem showChar;

    public CustMenuBar() {
        init();
        addButtonActionListener();
    }

    private void init() {
        final JMenu baseData = new JMenu(UILabelConstant.UI_LABEL_BASEDATA);
        yearCuddingtonData = new JMenuItem(UILabelConstant.UI_LABEL_YEAR_CUDDINGTON_DATA);
        baseData.add(yearCuddingtonData);
        yearResidualData = new JMenuItem(UILabelConstant.UI_LABEL_YEAR_RESIDUAL_DATA);
        baseData.add(yearResidualData);
        quarterCuddingtonData = new JMenuItem(UILabelConstant.UI_LABEL_QUARTER_CUDDINGTON_DATA);
        baseData.add(quarterCuddingtonData);
        quarterResidualData = new JMenuItem(UILabelConstant.UI_LABEL_QUARTER_RESIDUAL_DATA);
        baseData.add(quarterResidualData);
        monthData = new JMenuItem(UILabelConstant.UI_LABEL_MONTHDATA);
        baseData.add(monthData);
        this.add(baseData);

        final JMenu formula  = new JMenu(UILabelConstant.UI_LABEL_FORMULA);
        yearFormula = new JMenuItem(UILabelConstant.UI_LABEL_YEARFORMULA);
        formula.add(yearFormula);
        quarterFormula = new JMenuItem(UILabelConstant.UI_LABEL_QUARTERFORMULA);
        formula.add(quarterFormula);
        monthFormula = new JMenuItem(UILabelConstant.UI_LABEL_MONTHFORMULA);
        formula.add(monthFormula);
        this.add(formula);

        final JMenu scale  = new JMenu(UILabelConstant.UI_LABEL_SCALE);
        yearScale = new CustMenuItem("NianD");
        scale.add(yearScale);
        quarterScale = new CustMenuItem("NianJD");
        scale.add(quarterScale);
        monthScale = new CustMenuItem("NianYD");
        scale.add(monthScale);
        this.add(scale);

        final JMenu backend  = new JMenu(UILabelConstant.UI_LABEL_BACKEND);
        importData = new JMenuItem(UILabelConstant.UI_LABEL_IMPORTDATA);
        backend.add(importData);
        showChar = new JMenuItem(UILabelConstant.UI_LABEL_SHOWCHAR);
        backend.add(showChar);
        update = new JMenuItem(UILabelConstant.UI_LABEL_UPDATE);
        backend.add(update);
        deleteAll = new JMenuItem(UILabelConstant.UI_LABEL_DELETEALL);
        backend.add(deleteAll);
        this.add(backend);
        /*final JMenu menu = new JMenu("File");
        importData = new JMenuItem("Import Data");
        menu.add(importData);
        showChar = new JMenuItem("Show Chart");
        menu.add(showChar);
        this.add(menu);

        final JMenu edit = new JMenu("Edit");
        update = new JMenuItem("Update");
        edit.add(update);
        deleteAll = new JMenuItem("DeleteAllData");
        edit.add(deleteAll);
        this.add(edit);*/
    }

    protected void addButtonActionListener() {
        final AbstractCenterPanel nianD = new NianDCenterPanel();
        yearScale.addActionListener(new CustMenuActionListener(nianD));
        final AbstractCenterPanel nianYd = new NianYdCenterPanel();
        monthScale.addActionListener(new CustMenuActionListener(nianYd));
        final AbstractCenterPanel nianJd = new NianJdCenterPanel();
        quarterScale.addActionListener(new CustMenuActionListener(nianJd));

        final AbstractCenterPanel nianYdData = new NianYdDataCenterPanel();
        monthData.addActionListener(new CustMenuActionListener(nianYdData));
        final AbstractCenterPanel nianJdResidualData = new NianJdResidualDataCenterPanel();
        quarterResidualData.addActionListener(new CustMenuActionListener(nianJdResidualData));
        final AbstractCenterPanel nianJdCuddingtonData = new NianJdCuddingtonDataCenterPanel();
        quarterCuddingtonData.addActionListener(new CustMenuActionListener(nianJdCuddingtonData));
        final AbstractCenterPanel nianDResidualData = new NianDResidualDataCenterPanel();
        yearResidualData.addActionListener(new CustMenuActionListener(nianDResidualData));
        final AbstractCenterPanel nianDCuddingtonData = new NianDCuddingtonDataCenterPanel();
        yearCuddingtonData.addActionListener(new CustMenuActionListener(nianDCuddingtonData));



        importData.addActionListener(new ImportDataActionListener());
        update.addActionListener(new UpdateDataActionListener());
        deleteAll.addActionListener(new DeleteAllDataActionListener());
        showChar.addActionListener(new ShowCharActionListener());
    }

    /**
     * @return the update
     */
    public JMenuItem getUpdate() {
        return update;
    }
}
