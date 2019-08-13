package org.sofyan.myktm.ktmservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sofyan.myktm.constant.MessageConstant;
import org.sofyan.myktm.constant.ParamConstant;
import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;
import org.sofyan.myktm.integration.firebase.service.FirebaseServiceRest;
import org.sofyan.myktm.integration.firebase.vo.ktm.KtmSchedule;
import org.sofyan.myktm.ktmservice.service.ExecutorService;
import org.sofyan.myktm.util.ParameterUtil;
import org.sofyan.myktm.util.SpringUtil;
import org.sofyan.myktm.vo.MessageResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StationsByRouteServiceImpl implements ExecutorService {

    @Override
    public MessageResponse execute(Map<String, Object> param) {

        String route = ParameterUtil.getParamValue(param,ParamConstant.ROUTE,String.class);

        String jsonFireBaseResp = SpringUtil.getBean(FirebaseServiceRest.class)
                .get(FirebaseEndpointConstant.KTM_GET_ALL);

        ObjectMapper objMapper = new ObjectMapper();
        try {

            List<KtmSchedule> listKtmSchedule = objMapper.readValue(jsonFireBaseResp,
                    new TypeReference<List<KtmSchedule>>() {});

            for(KtmSchedule ktmSchedule : listKtmSchedule) {
                if(ktmSchedule.getRoute().equalsIgnoreCase(route)) {
                    return MessageResponse.success(MessageConstant.DATA_FOUND,ktmSchedule);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return MessageResponse.success(MessageConstant.NO_DATA_FOUND);


    }

}
