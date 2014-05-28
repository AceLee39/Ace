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
    private JMenuItem yearData;
    private JMenuItem quarterData;
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
        yearData = new JMenuItem(UILabelConstant.UI_LABEL_YEARDATA);
        baseData.add(yearData);
        quarterData = new JMenuItem(UILabelConstant.UI_LABEL_QUARTERDATA);
        baseData.add(quarterData);
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
        final AbstractCenterPanel nianYd = new NianYdCenterPanel();
        monthScale.addActionListener(new CustMenuActionListener(nianYd));
        final AbstractCenterPanel nianJd = new NianJdCenterPanel();
        yearScale.addActionListener(new CustMenuActionListener(nianJd));

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
