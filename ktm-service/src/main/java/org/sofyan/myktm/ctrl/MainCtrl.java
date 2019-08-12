package org.sofyan.myktm.ctrl;

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
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api")
public class MainCtrl {

    @Autowired
    private KtmService ktmSeviceImpl;

    @GetMapping(value = "/find-ktm-nearest-station/{longitude}/{latitude}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> findNearestStation(
            @PathVariable("longitude") String longitude,
            @PathVariable("latitude") String latitude) {

        PositionVo positionVo = new PositionVo();
        positionVo.setLongitude(longitude);
        positionVo.setLatitude(latitude);

        MessageResponse message = this.ktmSeviceImpl.getData(positionVo,LocationServiceTypeConstant.NEARBY_STATION,
                KtmServiceType.KTM_NEAREST_STATION, new HashMap<>());

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/find-ktm-route",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> findKtmRoute() {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_ROUTE, new HashMap<>());

        return new ResponseEntity<>(message, HttpStatus.OK);

    }

    @GetMapping(value = "/find-ktm-station-by-route/{route}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MessageResponse> findKtmStationByRoute(@PathVariable("route") String route) {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_STATION_BY_ROUTE,
                Collections.singletonMap(ParamConstant.ROUTE,route));

        return new ResponseEntity<>(message, HttpStatus.OK);

    }

}
