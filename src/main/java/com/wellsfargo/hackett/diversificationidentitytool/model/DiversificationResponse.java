package com.wellsfargo.hackett.diversificationidentitytool.model;

import java.util.Map;

public class DiversificationResponse {

    private Map<String, SourceData> response;

    public Map<String, SourceData> getResponse() {

        return response;
    }

    public void setResponse(Map<String, SourceData> response) {

        this.response = response;
    }

}