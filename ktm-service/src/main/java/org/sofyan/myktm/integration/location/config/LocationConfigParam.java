package org.sofyan.myktm.integration.location.config;

import org.sofyan.myktm.integration.location.vo.request.PositionVo;

import java.util.Map;

public interface LocationConfigParam {

    Map<String,String> getParams(PositionVo positionVo);

}
