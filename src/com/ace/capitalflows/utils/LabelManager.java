// Copyright (c) 1998-2014 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2014-XX-XX, Ace.Li, creation
// ============================================================================
package com.ace.capitalflows.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Ace.Li
 *
 */
public class LabelManager {
    private static Properties properties = new Properties();
    private static final String LABEL_SETTING = "setting/PanelKey_To_Label.properties";
    private static LabelManager instance;

    static {
        try {
            final InputStream is = new FileInputStream(LABEL_SETTING);
            properties.load(is);
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private static class LabelManagerInstance {
        private static final LabelManager instance = new LabelManager();
    }

    public static LabelManager getInstance() {
        if(instance == null) {
            instance = LabelManagerInstance.instance;
        }
        return instance;
    }

    public static String getString(final String panelKey) {
        return properties.getProperty(panelKey);
    }

}
