package org.sofyan.myktm.ktmservice;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.service.LocationServiceRest;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationIntegrationTest {

    @Autowired
    private LocationServiceRest locationServiceRest;

    @Test
    public void getNearestKTMStation() {

        PositionVo p = new PositionVo();
        p.setLongitude("3.0861");
        p.setLatitude("101.6338");

        String pathToSearch = "$.Res.Stations.Stn.*";

        String jsonResp = this.locationServiceRest.getData(p,LocationServiceTypeConstant.NEARBY_STATION);
        System.out.println( JsonPath.parse( jsonResp ).read(pathToSearch).toString() );

    }

    @Test
    public void getNearestKTMStationName() {

        PositionVo p = new PositionVo();
        p.setLongitude("3.0861");
        p.setLatitude("101.6338");

        String pathToSearch = "$.Res.Stations.Stn[0].name";

        String jsonResp = this.locationServiceRest.getData(p,LocationServiceTypeConstant.NEARBY_STATION);
        System.out.println( JsonPath.parse( jsonResp ).read(pathToSearch).toString() );

    }

    @Test
    public void checkExistUseJsonPath() {

        PositionVo p = new PositionVo();
        p.setLongitude("3.0861");
        p.setLatitude("101.6338");

        String pathToSearch = "$.Res[?(@.Stations)]";

        String jsonResp = this.locationServiceRest.getData(p,LocationServiceTypeConstant.NEARBY_STATION);
        System.out.println( JsonPath.parse( jsonResp ).read(pathToSearch).toString() );

    }

}
