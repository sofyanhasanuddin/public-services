package org.sofyan.myktm.ktmservice;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.ktmservice.constant.KtmServiceType;
import org.sofyan.myktm.ktmservice.service.KtmService;
import org.sofyan.myktm.util.PrintUtil;
import org.sofyan.myktm.vo.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KtmServiceApplicationTests {

    @Autowired
    private KtmService ktmSeviceImpl;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getNearestStationTest() {

        PositionVo p = new PositionVo();
        p.setLongitude("3.0860");
        p.setLatitude("101.6619");

        MessageResponse message = this.ktmSeviceImpl.getData(p,LocationServiceTypeConstant.NEARBY_STATION,
                KtmServiceType.KTM_NEAREST_STATION, new HashMap<>());

        System.out.println( PrintUtil.prettyPrintJson(message) );

    }

    @Test
    public void getKtmRouteTest() {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_ROUTE, new HashMap<>());
        System.out.println( PrintUtil.prettyPrintJson(message) );

    }

    @Test
    public void getKtmStationByRoute() {

        MessageResponse message = this.ktmSeviceImpl.getData(KtmServiceType.KTM_STATION_BY_ROUTE,
                Collections.singletonMap("route","TANJUNG MALIM - PELABUHAN KLANG"));
        System.out.println( PrintUtil.prettyPrintJson(message) );

    }

    @Test
    public void checkFuzzyWords() {

        String name = "KG.DATO HARUN".toLowerCase();
        String toCompare = "Kg. Dato Harun".toLowerCase();

        System.out.println(FuzzySearch.partialRatio(name,toCompare));

    }

}
