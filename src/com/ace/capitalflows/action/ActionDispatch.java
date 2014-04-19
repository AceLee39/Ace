// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import com.ace.capitalflows.action.actioncontext.ActionContext;

/**
 * @author Administrator
 *
 */
public class ActionDispatch {
    private static final String ACTION_PATH = "com.ace.capitalflows.action.";
    private static final String STR_CONTEXT = "Context";
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void execute(final ActionContext actionContext) {
        try {
            final String actionContextName = actionContext.getClass().getSimpleName();
            final String actionName = StringUtils.substringBeforeLast(actionContextName, STR_CONTEXT);
            final String actionPath = ACTION_PATH + actionName;
            final Action action = (Action) ClassUtils.getClass(actionPath).newInstance();
            action.execute(actionContext);
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
