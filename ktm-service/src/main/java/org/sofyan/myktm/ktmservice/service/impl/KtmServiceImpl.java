package org.sofyan.myktm.ktmservice.service.impl;

import org.sofyan.myktm.constant.MessageConstant;
import org.sofyan.myktm.constant.ParamConstant;
import org.sofyan.myktm.integration.location.config.LocationConfiguration;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.service.LocationExecutorService;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.ktmservice.config.KtmServiceConfiguration;
import org.sofyan.myktm.ktmservice.constant.KtmServiceType;
import org.sofyan.myktm.ktmservice.service.ExecutorService;
import org.sofyan.myktm.ktmservice.service.KtmService;
import org.sofyan.myktm.vo.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KtmServiceImpl implements KtmService {

    @Override
    public MessageResponse getData(PositionVo currPositionVo,
                                   LocationServiceTypeConstant locationServiceType,
                                   KtmServiceType ktmServiceType,
                                   Map<String,Object> param) {

        try {

            LocationExecutorService locationService = (LocationExecutorService) Class.forName(
                    LocationConfiguration.getService(locationServiceType).getLocationServiceImpl()).newInstance();

            String locationResp = locationService.execute(currPositionVo,locationServiceType, param);
            param.put(ParamConstant.JSON_LOCATION_RESPOND,locationResp);
            param.put(ParamConstant.LOCATION_SERVICE_CONFIG,LocationConfiguration.getService(locationServiceType));

            ExecutorService  executorService = (ExecutorService) Class.forName(
                    KtmServiceConfiguration.getService(ktmServiceType).getExecutorService()).newInstance();

            return executorService.execute( param );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return MessageResponse.success(MessageConstant.NO_DATA_FOUND);

    }

    @Override
    public MessageResponse getData(PositionVo currPositionVo, KtmServiceType ktmServiceType,
                                   Map<String,Object> param) {

        ExecutorService  executorService = null;
        try {

            executorService = (ExecutorService) Class.forName(
                    KtmServiceConfiguration.getService(ktmServiceType).getExecutorService()).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        executorService.execute(param);

        return MessageResponse.success(MessageConstant.NO_DATA_FOUND);

    }

    @Override
    public MessageResponse getData(KtmServiceType ktmServiceType,
                                   Map<String,Object> param) {

        ExecutorService  executorService = null;
        try {

            executorService = (ExecutorService) Class.forName(
                    KtmServiceConfiguration.getService(ktmServiceType).getExecutorService()).newInstance();

            return executorService.execute(param);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return MessageResponse.success(MessageConstant.NO_DATA_FOUND);

    }

}
