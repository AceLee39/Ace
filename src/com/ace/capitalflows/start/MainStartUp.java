// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.start;

import com.ace.capitalflows.ui.frame.MainFrame;
import com.ace.capitalflows.utils.PropertiesUtil;


/**
 * @author Administrator
 *
 */
public class MainStartUp {

    public static void main(final String[] args) {
       // System.out.println(YDResidualMysqlModel.class.getName());
       // System.out.println(Class.forName("com.ace.capitalflows.db.model.YDResidualMysqlModel"));
       PropertiesUtil.initDBInstance();
      MainFrame.getInstance().getUpdate().doClick();
      //  new RegisterFrame();
    }
}
