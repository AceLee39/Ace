// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.start;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.ActionDispatch;
import com.ace.capitalflows.action.actioncontext.ImportDataActionContext;
import com.ace.capitalflows.ui.frame.RegisterFrame;
import com.ace.capitalflows.utils.DBUtils;
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
//      PropertiesUtil.initDBOracleInstance();
      final String isInit = DBUtils.getAttributeByKey("isInit");
      if (StringUtils.equalsIgnoreCase(isInit, "false")) {
          final Map<String, File> fileMap = new HashMap<String, File>();
          fileMap.put("NianD", new File("files/NianD.xlsx"));
          fileMap.put("NianJd", new File("files/NianJd.xlsx"));
          fileMap.put("NianYd", new File("files/NianYd.xlsx"));
          for (final String fileName : fileMap.keySet()) {
              final ImportDataActionContext importData = new ImportDataActionContext();
              importData.setImportFile(fileMap.get(fileName));
              importData.setCurTabName(fileName);
              ActionDispatch.execute(importData);
          }
          DBUtils.updateAttributeValue("isInit", "true");
      }
      /*SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            MainFrame.getInstance().getUpdate().doClick();
        }
    });*/
//      System.out.println("main end");
        new RegisterFrame();
    }
}
