// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.frame;

import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public abstract class BaseFrame extends JFrame{
    protected final Container container;

    public BaseFrame(final String title) {
        this.container = this.getContentPane();
        initComponent();
        addButtonActionListener();
        addIntoContainer();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(title);
    }

    protected abstract void addIntoContainer();

    protected abstract void initComponent();

    protected Container getCurContainer() {
        return container;
    }

    protected abstract void addButtonActionListener();
}
