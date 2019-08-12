package org.sofyan.myktm.integration.firebase.service.impl;

import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;
import org.sofyan.myktm.integration.firebase.service.FirebaseServiceRest;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FirebaseServiceRestImpl implements FirebaseServiceRest {

    private static String AUTH_KEY = "EfooyKel6p6QP1K3pdiyv0jZL6unDDzWEP4WKTNb";
    private static String AUTH = "?auth=" + AUTH_KEY;

    @CacheEvict(allEntries = true)
    public void put(List<?> list, FirebaseEndpointConstant endpoint) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(constructFinalUrl(endpoint), list);

    }

    @Cacheable(key = "#endpoint.value", value = "getFirebaseCache")
    public String get(FirebaseEndpointConstant endpoint) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(constructFinalUrl(endpoint), String.class);

    }

    private String constructFinalUrl(FirebaseEndpointConstant endpoint) {

        String endPoint = StringUtils.endsWithIgnoreCase(endpoint.getValue(),FirebaseEndpointConstant.JSON.getValue()) ?
                endpoint.getValue() : endpoint.getValue() + FirebaseEndpointConstant.JSON.getValue();

        return FirebaseEndpointConstant.BASE.getValue() + endPoint + AUTH;

    }

}
