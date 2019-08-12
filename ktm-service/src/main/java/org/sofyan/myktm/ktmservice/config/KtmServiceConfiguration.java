package org.sofyan.myktm.ktmservice.config;

import com.google.common.collect.ImmutableMap;
import org.sofyan.myktm.ktmservice.constant.KtmServiceType;
import org.sofyan.myktm.ktmservice.service.impl.StationNearbyServiceImpl;
import org.sofyan.myktm.ktmservice.service.impl.StationRouteServiceImpl;
import org.sofyan.myktm.ktmservice.service.impl.StationsByRouteServiceImpl;
import org.sofyan.myktm.util.builder.GenericBuilder;

import java.util.HashMap;
import java.util.Map;

public class KtmServiceConfiguration {

    private KtmServiceConfiguration() {};

    private static Map<KtmServiceType, KtmServiceConfig> services = createMapServices();

    private static Map<KtmServiceType, KtmServiceConfig> createMapServices() {

        KtmServiceConfig nearestStation = GenericBuilder.of(KtmServiceConfig::new)
                .with(KtmServiceConfig::setKtmServiceType,KtmServiceType.KTM_NEAREST_STATION)
                .with(KtmServiceConfig::setExecutorService,StationNearbyServiceImpl.class.getName().toString())
                .with(KtmServiceConfig::setKtmConfigParam, new KtmServiceConfigParam() {
                    @Override
                    public Map<String, String> getParams() {

                        Map<String,String> map = new HashMap<>();

                        return map;

                    }
                })
                .build();

        KtmServiceConfig stationRoute = GenericBuilder.of(KtmServiceConfig::new)
                .with(KtmServiceConfig::setKtmServiceType,KtmServiceType.KTM_ROUTE)
                .with(KtmServiceConfig::setExecutorService,StationRouteServiceImpl.class.getName().toString())
                .with(KtmServiceConfig::setKtmConfigParam, new KtmServiceConfigParam() {
                    @Override
                    public Map<String, String> getParams() {

                        Map<String,String> map = new HashMap<>();

                        return map;

                    }
                })
                .build();

        KtmServiceConfig stationsByRoute = GenericBuilder.of(KtmServiceConfig::new)
                .with(KtmServiceConfig::setKtmServiceType,KtmServiceType.KTM_STATION_BY_ROUTE)
                .with(KtmServiceConfig::setExecutorService,StationsByRouteServiceImpl.class.getName().toString())
                .with(KtmServiceConfig::setKtmConfigParam, new KtmServiceConfigParam() {
                    @Override
                    public Map<String, String> getParams() {

                        Map<String,String> map = new HashMap<>();

                        return map;

                    }
                })
                .build();

        return ImmutableMap.<KtmServiceType, KtmServiceConfig> builder()
                .put(KtmServiceType.KTM_NEAREST_STATION,nearestStation)
                .put(KtmServiceType.KTM_ROUTE,stationRoute)
                .put(KtmServiceType.KTM_STATION_BY_ROUTE, stationsByRoute)
                .build();
    }

    public static KtmServiceConfig getService(KtmServiceType serviceType) {

        if (!services.containsKey(serviceType))
            throw new RuntimeException(String.format("Cannot find Kod for : %s ", serviceType.getValue()));

        return services.get(serviceType);

    }

}
