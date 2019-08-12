package org.sofyan.myktm.integration.location.service;

import org.sofyan.myktm.integration.location.config.LocationConfiguration;
import org.sofyan.myktm.integration.location.constant.LocationServiceRestConstant;
import org.sofyan.myktm.integration.location.constant.LocationServiceTypeConstant;
import org.sofyan.myktm.integration.location.util.RestUtil;
import org.sofyan.myktm.integration.location.vo.request.PositionVo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LocationServiceRest {

    public String getData(PositionVo currPositionVo,
                          LocationServiceTypeConstant serviceType) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        MultiValueMap params = RestUtil.convertMapToMultiValueMap(LocationConfiguration.getService(serviceType).getConfigParam().getParams(currPositionVo));

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(constructRestUrl(currPositionVo,serviceType))
                .queryParams(params);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        return response.getBody();

    }

    private String constructRestUrl(PositionVo positionVo, LocationServiceTypeConstant serviceType) {

        return LocationServiceRestConstant.URL.getValue() + LocationConfiguration.getService(serviceType).getServiceEndpoint();

    }

}
