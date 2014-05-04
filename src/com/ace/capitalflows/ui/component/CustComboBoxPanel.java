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
    private JComboBox<String> fromCombobox;
    private JComboBox<String> toCombobox;
    private Vector<String> comboBoxData = new Vector<String>();
    private Vector<String> toComboBoxData;
    private Vector<String> fromComboBoxData;
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
        this.comboBoxData = comboBoxData;
        fromCombobox.setModel(new DefaultComboBoxModel<String>(comboBoxData));
        toCombobox.setModel(new DefaultComboBoxModel<String>(reverseData()));
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

    public JComboBox<String> getFromCombobox() {
        return fromCombobox;
    }

    public void setFromCombobox(final JComboBox<String> fromCombobox) {
        this.fromCombobox = fromCombobox;
    }

    public JComboBox<String> getToCombobox() {
        return toCombobox;
    }

    public void setToCombobox(final JComboBox<String> toCombobox) {
        this.toCombobox = toCombobox;
    }

    /**
     *
     */
    private void addIntoLayout() {
        this.add(new JLabel("从", JLabel.CENTER));
        this.add(fromCombobox);
        this.add(new JLabel("到", JLabel.CENTER));
        this.add(toCombobox);
    }

    private void initComponent() {
        fromCombobox = new JComboBox<String>(fromComboBoxData);
        toCombobox = new JComboBox<String>(toComboBoxData);
    }


    public void setComboBoxData(final List<String> comboBoxDataList) {
        comboBoxData = new Vector<String>(comboBoxDataList);
    }

    public void updateData(final List<String> comboBoxDataList) {
        this.setComboBoxData(comboBoxDataList);
        fromCombobox.setModel(new DefaultComboBoxModel<String>(comboBoxData));
        toCombobox.setModel(new DefaultComboBoxModel<String>(reverseData()));
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

}
