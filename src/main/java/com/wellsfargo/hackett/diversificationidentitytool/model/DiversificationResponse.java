package com.wellsfargo.hackett.diversificationidentitytool.model;

import java.util.List;
import java.util.Map;

public class DiversificationResponse {

    private Map<String, List<String>> response;

    public Map<String, List<String>> getResponse() {

        return response;
    }

    public void setResponse(Map<String, List<String>> response) {

        this.response = response;
    }
}