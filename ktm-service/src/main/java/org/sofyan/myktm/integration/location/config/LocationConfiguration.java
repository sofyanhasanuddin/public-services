package org.sofyan.myktm.integration.location.config;

import com.google.common.collect.ImmutableMap;
import org.sofyan.myktm.integration.location.constant.LocationServiceRestConstant;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.service.impl.LocationGetNearestStationServiceImpl;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.sofyan.myktm.util.builder.GenericBuilder;

import java.util.HashMap;
import java.util.Map;

public class LocationConfiguration {

    private LocationConfiguration() {};

    private static Map<LocationServiceTypeConstant, LocationConfig> services = createMapServices();

    private static Map<LocationServiceTypeConstant, LocationConfig> createMapServices() {

        LocationConfig nearByStation = GenericBuilder.of(LocationConfig::new)
                .with(LocationConfig::setServiceType,LocationServiceTypeConstant.NEARBY_STATION)
                .with(LocationConfig::setServiceEndpoint,"stations/by_geocoord.json")
                .with(LocationConfig::setJsonPathCheckRespons,"$.Res[?(@.Stations)]")
                .with(LocationConfig::setJsonPathFindName,"$.Res.Stations.Stn[0].name")
                .with(LocationConfig::setJsonPathFindErrorMessage,"$.Res.Message.text")
                .with(LocationConfig::setLocationServiceImpl,LocationGetNearestStationServiceImpl.class.getName())
                .with(LocationConfig::setConfigParam, new LocationConfigParam() {
                    @Override
                    public Map<String, String> getParams(PositionVo positionVo) {

                        Map<String,String> map = new HashMap<>();
                        map.put("center", positionVo.getLongitudeLatitude());
                        map.put("app_id", LocationServiceRestConstant.APP_ID.getValue());
                        map.put("app_code", LocationServiceRestConstant.APP_CODE.getValue());
                        map.put("max", "1");
                        map.put("radius", "1000");

                        return map;

                    }
                })
                .build();

        return ImmutableMap.<LocationServiceTypeConstant, LocationConfig> builder()
                .put(LocationServiceTypeConstant.NEARBY_STATION,nearByStation)
                .build();
    }

    public static LocationConfig getService(LocationServiceTypeConstant serviceType) {

        if (!services.containsKey(serviceType))
            throw new RuntimeException(String.format("Cannot find Kod for : %s ", serviceType.getValue()));

        return services.get(serviceType);

    }

}
