// Copyright (c) 2014 All rights reserved.
// ============================================================================
// CURRENT VERSION 1
// ============================================================================
// CHANGE LOG// 1 : 2014-XX-XX, Administrator, creation
// ============================================================================
package com.ace.capitalflows.entity.model;

import org.apache.commons.lang.StringUtils;

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
    public DataModel getDataModel(final String className, final String mode) {
        DataModel dataModel = null;
        try {
            final Class<DataModel> clazz = (Class<DataModel>) Class.forName(className);
            dataModel = clazz.newInstance();
            dataModel.setMode(mode);
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        }
        return dataModel;
    }

    public DataModel getDataModelByTabName(String centerName) {
        if (StringUtils.equals(centerName, Constant.CENTER_YEAR)) {
            centerName = Constant.CENTER_NIAN_JD;
        }
        if (StringUtils.equals(centerName, Constant.CENTER_YEAR_CUDDINGTON_DATA)) {
            centerName = Constant.CENTER_NIAN_JD_CUDDINGTON_DATA;
        }
        if (StringUtils.equals(centerName, Constant.CENTER_YEAR_RESIDUAL_DATA)) {
            centerName = Constant.CENTER_NIAN_JD_RESIDUAL_DATA;
        }
        final String tabName = StringUtils.substringBefore(centerName, Constant.SEPARATOR_SLASH);
        final String mode = StringUtils.substringAfter(centerName, Constant.SEPARATOR_SLASH);
        final String className = String.format(Constant.DATA_MODEL_PATH, tabName);
        return getDataModel(className, mode);
    }
}
