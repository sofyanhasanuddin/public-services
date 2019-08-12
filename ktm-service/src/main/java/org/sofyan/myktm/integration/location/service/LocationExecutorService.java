package org.sofyan.myktm.integration.location.service;

import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;

import java.util.Map;

public interface LocationExecutorService {

    String execute(PositionVo currPositionVo,
                   LocationServiceTypeConstant serviceType,
                   Map<String,Object> param);

}
