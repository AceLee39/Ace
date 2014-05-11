// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class PropertiesUtil {
    private static Properties properties = new Properties();
    private static final String DB_SETTING = "setting/DBSetting.properties";
    private static final String DB_ORACLE_SETTING = "setting/DBOracleSetting.properties";
    private static PropertiesUtil instance = null;

    private PropertiesUtil(final String filePath) {
        try {
            final InputStream is = new FileInputStream(filePath);
            properties.load(is);
            //properties.load(PropertiesUtil.class.getResourceAsStream(DB_SETTING));
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesUtil initDBInstance() {
        if (instance == null) {
            instance = DBPropertiesInstance.instance;
        }
        return instance;
    }

    public static PropertiesUtil initDBOracleInstance() {
        if (instance == null) {
            instance = DBOraclePropertiesInstance.instance;
        }
        return instance;
    }

    public static String getString(final String key) {
        return properties.getProperty(key);
    }


    private static class DBPropertiesInstance {
        private static PropertiesUtil instance = new PropertiesUtil(DB_SETTING);
    }

    private static class DBOraclePropertiesInstance {
        private static PropertiesUtil instance = new PropertiesUtil(DB_ORACLE_SETTING);
    }
}
