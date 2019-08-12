package org.sofyan.myktm.ktmservice.service;

import org.sofyan.myktm.vo.MessageResponse;

import java.util.Map;

public interface ExecutorService {

    MessageResponse execute(Map<String, Object> param);

}
