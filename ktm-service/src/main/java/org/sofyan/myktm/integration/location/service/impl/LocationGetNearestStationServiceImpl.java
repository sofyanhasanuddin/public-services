package org.sofyan.myktm.integration.location.service.impl;

import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.service.LocationExecutorService;
import org.sofyan.myktm.integration.location.service.LocationServiceRest;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.util.SpringUtil;

import java.util.Map;

public class LocationGetNearestStationServiceImpl implements LocationExecutorService {

    @Override
    public String execute(PositionVo currPositionVo, LocationServiceTypeConstant serviceType,
                          Map<String,Object> param) {

        return SpringUtil.getBean(LocationServiceRest.class).getData(currPositionVo,serviceType);

    }
}
