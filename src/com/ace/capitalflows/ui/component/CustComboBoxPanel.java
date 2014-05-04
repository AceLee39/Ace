// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.component;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ace.capitalflows.actionlistener.ComboBoxActionListener;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class CustComboBoxPanel extends JPanel {
    private JComboBox fromCombobox;
    private JComboBox toCombobox;
    private Vector<String> comboBoxData = new Vector<String>();
    private Vector<String> toComboBoxData;
    private Vector<String> fromComboBoxData;
    private boolean isNeedReset = Boolean.TRUE;
    private static CustComboBoxPanel instance;

    private CustComboBoxPanel() {
        this.setLayout(new GridLayout(1, 5));
        initData();
        initComponent();
        initActionListener();
        addIntoLayout();
    }

    private static class CustComboBoxPanelInstance {
        private static CustComboBoxPanel instance = new CustComboBoxPanel();
    }

    public static CustComboBoxPanel getInstance() {
        if(instance == null) {
            instance = CustComboBoxPanelInstance.instance;
        }
        return instance;
    }

    /**
     *
     */
    private void initData() {
        fromComboBoxData = new Vector<String>(comboBoxData);
        toComboBoxData = new Vector<String>(comboBoxData);
        reverseToData();
    }

    public void setComboBoxData(final Vector<String> comboBoxData) {
        if (isNeedReset) {
            this.comboBoxData = comboBoxData;
            fromCombobox.setModel(new DefaultComboBoxModel(comboBoxData));
            toCombobox.setModel(new DefaultComboBoxModel(reverseData()));
        }
    }

    /**
     *
     */
    private void reverseToData() {
        final List<String> toDataList = new ArrayList<String>(toComboBoxData);
        Collections.reverse(toDataList);
        setToComboBoxData(new Vector<String>(toDataList));
    }

    /**
     *
     */
    private void initActionListener() {
        fromCombobox.addActionListener(new ComboBoxActionListener());
        toCombobox.addActionListener(new ComboBoxActionListener());
    }

    public JComboBox getFromCombobox() {
        return fromCombobox;
    }

    public void setFromCombobox(final JComboBox fromCombobox) {
        this.fromCombobox = fromCombobox;
    }

    public JComboBox getToCombobox() {
        return toCombobox;
    }

    public void setToCombobox(final JComboBox toCombobox) {
        this.toCombobox = toCombobox;
    }

    /**
     *
     */
    private void addIntoLayout() {
        this.add(new JLabel("ä»?, JLabel.CENTER));
        this.add(fromCombobox);
        this.add(new JLabel("åˆ?, JLabel.CENTER));
        this.add(toCombobox);
    }

    private void initComponent() {
        fromCombobox = new JComboBox(fromComboBoxData);
        toCombobox = new JComboBox(toComboBoxData);
    }


    public void setComboBoxData(final List<String> comboBoxDataList) {
        comboBoxData = new Vector<String>(comboBoxDataList);
    }

    public void updateData(final List<String> comboBoxDataList) {
        this.setComboBoxData(comboBoxDataList);
        fromCombobox.setModel(new DefaultComboBoxModel(comboBoxData));
        toCombobox.setModel(new DefaultComboBoxModel(reverseData()));
    }

    private Vector<String> reverseData() {
        final List<String> toDataList = new ArrayList<String>(comboBoxData);
        Collections.reverse(toDataList);
        return new Vector<String>(toDataList);
    }

    public Vector<String> getToComboBoxData() {
        return toComboBoxData;
    }

    public void setToComboBoxData(final Vector<String> toComboBoxData) {
        this.toComboBoxData = toComboBoxData;
    }

    public Vector<String> getFromComboBoxData() {
        return fromComboBoxData;
    }

    public void setFromComboBoxData(final Vector<String> fromComboBoxData) {
        this.fromComboBoxData = fromComboBoxData;
    }

    /**
     * @return the isNeedReset
     */
    public boolean isNeedReset() {
        return isNeedReset;
    }

    /**
     * @param isNeedReset the isNeedReset to set
     */
    public void setNeedReset(final boolean isNeedReset) {
        this.isNeedReset = isNeedReset;
    }
}
