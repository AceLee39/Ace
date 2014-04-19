// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.action;

import com.ace.capitalflows.action.actioncontext.ActionContext;



/**
 * @author Administrator
 *
 */
public interface Action<T extends ActionContext>{
    void execute(T actionContext);
}
