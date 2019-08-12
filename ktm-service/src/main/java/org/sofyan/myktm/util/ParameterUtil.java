package org.sofyan.myktm.util;

import java.util.Map;

public class ParameterUtil {

    private ParameterUtil() {}

    public static <T> T getParamValue(Map<String,Object> param, String key, Class<T> t) {

        Object objVal = param.get(key);
        if( objVal == null ) return null;

        return (T) objVal;

    }

}
