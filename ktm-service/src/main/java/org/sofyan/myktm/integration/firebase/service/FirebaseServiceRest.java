package org.sofyan.myktm.integration.firebase.service;

import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;

import java.util.List;

public interface FirebaseServiceRest {

    public void put(List<?> list, FirebaseEndpointConstant endpoint);

    public String get(FirebaseEndpointConstant endpoint);

}
