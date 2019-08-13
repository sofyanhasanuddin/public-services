package org.sofyan.myktm.ctrl;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.sofyan.myktm.constant.ParamConstant;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.ktmservice.constant.KtmServiceType;
import org.sofyan.myktm.ktmservice.service.KtmService;
import org.sofyan.myktm.vo.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class MainCtrl {

    @Autowired
    private KtmService ktmSeviceImpl;

    @GetMapping(value = "/find-ktm-nearest-station/{longitude}/{latitude}/{time}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="Find nearest ktm station and its departure time based on your location and time ")
    public ResponseEntity<MessageResponse> findNearestStation(
            @ApiParam(value = "Latitude coordinate") @PathVariable("latitude") String latitude,
            @ApiParam(value = "Longitude coordinate") @PathVariable("longitude") String longitude,
            @ApiParam(value = "Time in HH:mm format") @PathVariable("time") String time) {

        PositionVo positionVo = new PositionVo();
        positionVo.setLongitude(longitude);
        positionVo.setLatitude(latitude);

        Map<String,Object> param = Maps.newHashMap();
        param.put(ParamConstant.TIME, time);

        MessageResponse message = this.ktmSeviceImpl.getData(positionVo,
                LocationServiceTypeConstant.NEARBY_STATION,
                KtmServiceType.KTM_NEAREST_STATION, param);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/find-ktm-route",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="Display all ktm route available")
    public ResponseEntity<MessageResponse> findKtmRoute() {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_ROUTE, new HashMap<>());

        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @GetMapping(value = "/find-ktm-station-by-route/{route}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value="Find all ktm stations based on route")
    public ResponseEntity<MessageResponse> findKtmStationByRoute(
            @ApiParam(value = "Train route") @PathVariable("route") String route) {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_STATION_BY_ROUTE,
                Collections.singletonMap(ParamConstant.ROUTE,route));

        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
