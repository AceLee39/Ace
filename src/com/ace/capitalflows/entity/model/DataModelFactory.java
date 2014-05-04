// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import com.ace.capitalflows.constant.Constant;



/**
 * @author Administrator
 *
 */
public class DataModelFactory {

    private DataModelFactory() {}

    private static class DataModelFactoryInstance {
        private static final DataModelFactory instance = new DataModelFactory();
    }

    public static DataModelFactory getInstance() {
        return DataModelFactoryInstance.instance;
    }

    @SuppressWarnings("unchecked")
    public DataModel getDataModel(final String className) {
        DataModel dataModel = null;
        try {
            final Class<DataModel> clazz = (Class<DataModel>) Class.forName(className);
            dataModel = clazz.newInstance();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        return dataModel;
    }

    public DataModel getDataModelByTabName(final String tabName) {
        return getDataModel(String.format(Constant.DATA_MODEL_PATH, tabName));
    }
}
