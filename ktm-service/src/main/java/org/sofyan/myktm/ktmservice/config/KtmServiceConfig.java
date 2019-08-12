package org.sofyan.myktm.ktmservice.config;

import org.sofyan.myktm.ktmservice.constant.KtmServiceType;

public class KtmServiceConfig {

    private KtmServiceType ktmServiceType;
    private String executorService;
    private KtmServiceConfigParam ktmConfigParam;

    public KtmServiceType getKtmServiceType() {
        return ktmServiceType;
    }

    public void setKtmServiceType(KtmServiceType ktmServiceType) {
        this.ktmServiceType = ktmServiceType;
    }

    public String getExecutorService() {
        return executorService;
    }

    public void setExecutorService(String executorService) {
        this.executorService = executorService;
    }

    public KtmServiceConfigParam getKtmConfigParam() {
        return ktmConfigParam;
    }

    public void setKtmConfigParam(KtmServiceConfigParam ktmConfigParam) {
        this.ktmConfigParam = ktmConfigParam;
    }

}
