package com.wellsfargo.hackett.diversificationidentitytool.business;

import java.io.Serializable;
import java.util.HashMap;

public class SearchResults implements Serializable {
    HashMap<String, String> relevantHeaders;
    String jsonResponse;

    SearchResults(HashMap<String, String> headers, String json) {
        relevantHeaders = headers;
        jsonResponse = json;
    }

    public HashMap<String, String> getRelevantHeaders() {
        return relevantHeaders;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }
}
