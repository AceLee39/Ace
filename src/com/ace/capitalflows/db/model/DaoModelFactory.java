// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.db.model;



/**
 * @author Administrator
 *
 */
public class DaoModelFactory {

    private DaoModelFactory() {}

    private static class DaoModelFactoryInstance {
        private static final DaoModelFactory instance = new DaoModelFactory();
    }

    public static DaoModelFactory getInstance() {
        return DaoModelFactoryInstance.instance;
    }

    @SuppressWarnings("unchecked")
    public DaoModel getDaoModel(final String className) {
        DaoModel daoModel = null;
        try {
            final Class<DaoModel> clazz = (Class<DaoModel>) Class.forName(className);
            daoModel = clazz.newInstance();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        return daoModel;
    }
}
