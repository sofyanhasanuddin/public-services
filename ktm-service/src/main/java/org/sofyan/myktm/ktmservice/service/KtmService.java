package org.sofyan.myktm.ktmservice.service;

import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.ktmservice.constant.KtmServiceType;
import org.sofyan.myktm.vo.MessageResponse;

import java.util.Map;

public interface KtmService {

    MessageResponse getData(PositionVo currPositionVo,
                            LocationServiceTypeConstant serviceType,
                            KtmServiceType ktmServiceType,
                            Map<String,Object> param);

    MessageResponse getData(PositionVo currPositionVo,
                            KtmServiceType ktmServiceType,
                            Map<String,Object> param);

    MessageResponse getData(KtmServiceType ktmServiceType,
                            Map<String,Object> param);

}
