package org.sofyan.myktm.integration.location.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class RestUtil {

    private RestUtil() {}

    public static MultiValueMap convertMapToMultiValueMap(Map<String,String> mapToConvert) {

        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        for (Map.Entry<String, String> entry : mapToConvert.entrySet()) {
            params.add(entry.getKey(), entry.getValue());
        }

        return params;

    }

}
