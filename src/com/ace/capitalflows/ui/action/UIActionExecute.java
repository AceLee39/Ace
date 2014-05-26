// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.ui.action;

import java.util.Map;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Administrator
 *
 */
public class UIActionExecute {
    private static final String UI_ACTION_PATH = "com.ace.capitalflows.ui.action.";
    private static final String STR_ACTIONLISTENER = "ActionListener";
    private static final String STR_ACTION = "UIAction";

    @SuppressWarnings("rawtypes")
    public static Object execute(final String simpleActionListener, final Map<String, Object> params) {
        try {
            final String uiActionName = UI_ACTION_PATH + StringUtils.substringBeforeLast(simpleActionListener, STR_ACTIONLISTENER)
                    + STR_ACTION;
            final Class uiActionClass = ClassUtils.getClass(uiActionName);
            final UIAction uiAction = (UIAction) uiActionClass.newInstance();
            uiAction.execute(params);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
