package com.wellsfargo.hackett.diversificationidentitytool.model;

import java.util.List;

public class SourceData {

    private String snippet;
    private List<String> data;

    public SourceData(String snippet, List<String> data) {
        this.data = data;
        this.snippet = snippet;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
