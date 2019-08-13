package org.sofyan.myktm.ktmservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sofyan.myktm.constant.MessageConstant;
import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;
import org.sofyan.myktm.integration.firebase.service.FirebaseServiceRest;
import org.sofyan.myktm.integration.firebase.vo.ktm.KtmSchedule;
import org.sofyan.myktm.ktmservice.service.ExecutorService;
import org.sofyan.myktm.util.SpringUtil;
import org.sofyan.myktm.vo.MessageResponse;
import org.sofyan.myktm.vo.RouteResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StationRouteServiceImpl implements ExecutorService {

    @Override
    public MessageResponse execute(Map<String,Object> param) {

        String jsonFireBaseResp = SpringUtil.getBean(FirebaseServiceRest.class)
                .get(FirebaseEndpointConstant.KTM_GET_ALL);

        ObjectMapper objMapper = new ObjectMapper();
        try {

            List<KtmSchedule> listKtmSchedule = objMapper.readValue(jsonFireBaseResp,
                    new TypeReference<List<KtmSchedule>>() {});

            List<RouteResponse> listRoute = new ArrayList<>();

            for(KtmSchedule ktmSchedule : listKtmSchedule) {
                listRoute.add( new RouteResponse(ktmSchedule.getRoute()));
            }

            if( listRoute.size() > 0 )
                return MessageResponse.success(MessageConstant.FOUND_ROUTE,
                    Collections.singletonMap("routes", listRoute));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return MessageResponse.error(MessageConstant.NO_DATA_FOUND);

    }
}
