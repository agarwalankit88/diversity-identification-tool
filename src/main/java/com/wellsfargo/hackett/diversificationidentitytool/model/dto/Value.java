
package com.wellsfargo.hackett.diversificationidentitytool.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "url",
    "thumbnailUrl",
    "isFamilyFriendly",
    "displayUrl",
    "snippet",
    "dateLastCrawled",
    "language",
    "isNavigational"
})
@Generated("jsonschema2pojo")
public class Value implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("isFamilyFriendly")
    private Boolean isFamilyFriendly;
    @JsonProperty("displayUrl")
    private String displayUrl;
    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("dateLastCrawled")
    private String dateLastCrawled;
    @JsonProperty("language")
    private String language;
    @JsonProperty("isNavigational")
    private Boolean isNavigational;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2513566050501597549L;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @JsonProperty("thumbnailUrl")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @JsonProperty("isFamilyFriendly")
    public Boolean getIsFamilyFriendly() {
        return isFamilyFriendly;
    }

    @JsonProperty("isFamilyFriendly")
    public void setIsFamilyFriendly(Boolean isFamilyFriendly) {
        this.isFamilyFriendly = isFamilyFriendly;
    }

    @JsonProperty("displayUrl")
    public String getDisplayUrl() {
        return displayUrl;
    }

    @JsonProperty("displayUrl")
    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("dateLastCrawled")
    public String getDateLastCrawled() {
        return dateLastCrawled;
    }

    @JsonProperty("dateLastCrawled")
    public void setDateLastCrawled(String dateLastCrawled) {
        this.dateLastCrawled = dateLastCrawled;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("isNavigational")
    public Boolean getIsNavigational() {
        return isNavigational;
    }

    @JsonProperty("isNavigational")
    public void setIsNavigational(Boolean isNavigational) {
        this.isNavigational = isNavigational;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
