package org.sofyan.myktm.ktmservice.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.sofyan.myktm.constant.MessageConstant;
import org.sofyan.myktm.constant.ParamConstant;
import org.sofyan.myktm.integration.firebase.constant.FirebaseEndpointConstant;
import org.sofyan.myktm.integration.firebase.service.FirebaseServiceRest;
import org.sofyan.myktm.integration.firebase.vo.ktm.KtmSchedule;
import org.sofyan.myktm.integration.firebase.vo.ktm.Schedule;
import org.sofyan.myktm.integration.firebase.vo.ktm.Station;
import org.sofyan.myktm.integration.location.config.LocationConfig;
import org.sofyan.myktm.ktmservice.service.ExecutorService;
import org.sofyan.myktm.util.ParameterUtil;
import org.sofyan.myktm.util.SpringUtil;
import org.sofyan.myktm.vo.KtmNearbyStationResponse;
import org.sofyan.myktm.vo.MessageResponse;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class StationNearbyServiceImpl implements ExecutorService {

    @Override
    public MessageResponse execute(Map<String,Object> param) {

        List<KtmNearbyStationResponse> listSchedule = new ArrayList<>();

        Date currDate = new Date();

        LocationConfig locationConfig = ParameterUtil.getParamValue(param,ParamConstant.LOCATION_SERVICE_CONFIG,LocationConfig.class);

        String jsonLocationResp = ParameterUtil.getParamValue(param,ParamConstant.JSON_LOCATION_RESPOND, String.class);

        if(!StringUtils.hasText( JsonPath.parse( jsonLocationResp ).read(locationConfig.getJsonPathCheckRespons()).toString() ) )
            return MessageResponse.error("Response from location is empty");

        String nearByStationName = JsonPath.parse( jsonLocationResp ).read(locationConfig.getJsonPathFindName() ).toString();

        String jsonFireBaseResp = SpringUtil.getBean(FirebaseServiceRest.class).get(FirebaseEndpointConstant.KTM_GET_ALL);

        ObjectMapper objMapper = new ObjectMapper();
        try {

            List<KtmSchedule> listKtmSchedule = objMapper.readValue(jsonFireBaseResp, new TypeReference<List<KtmSchedule>>() {});

            for(KtmSchedule ktmSchedule : listKtmSchedule) {
                for(Station station : ktmSchedule.getListStation()) {

                    boolean foundStationAndTime = false;
                    String name = station.getName();

                    if( FuzzySearch.partialRatio( name.toLowerCase(), nearByStationName.toLowerCase() ) >= 90) {

                        for(Schedule sch : station.getListSchedule()) {
                            if( nearestTime(sch, currDate) ) {

                                listSchedule.add(new KtmNearbyStationResponse(ktmSchedule.getRoute(),
                                        station.getName(), sch.getTime()));

                                foundStationAndTime = true;
                                break;
                            }
                        }

                    }

                    if(foundStationAndTime) break;

                }
            }

            if( listSchedule.size() > 0 )
                return MessageResponse.success(MessageConstant.DATA_FOUND, listSchedule);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return MessageResponse.error(MessageConstant.NO_DATA_FOUND);

    }

    private boolean nearestTime(Schedule sch, Date currDate) {

        Calendar currCal = Calendar.getInstance();
        currCal.setTime(currDate);

        //For current time
        StringBuilder sbCurrTime = new StringBuilder();
        sbCurrTime.append(currCal.get(Calendar.HOUR_OF_DAY) > 9 ?
                currCal.get(Calendar.HOUR_OF_DAY) : "0" + currCal.get(Calendar.HOUR_OF_DAY));
        sbCurrTime.append(":");
        sbCurrTime.append(currCal.get(Calendar.MINUTE) > 9 ?
                currCal.get(Calendar.MINUTE) : "0" + currCal.get(Calendar.MINUTE));

        LocalTime localCurrTime = LocalTime.parse(sbCurrTime.toString());
        LocalTime localStationTime = LocalTime.parse(sch.getTime());

        return localStationTime.isAfter(localCurrTime);

    }


}
