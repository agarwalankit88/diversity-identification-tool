
package com.wellsfargo.hackett.diversificationidentitytool.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "webSearchUrl",
    "totalEstimatedMatches",
    "value",
    "someResultsRemoved"
})
@Generated("jsonschema2pojo")
public class WebPages implements Serializable
{

    @JsonProperty("webSearchUrl")
    private String webSearchUrl;
    @JsonProperty("totalEstimatedMatches")
    private Integer totalEstimatedMatches;
    @JsonProperty("value")
    private List<Value> value = null;
    @JsonProperty("someResultsRemoved")
    private Boolean someResultsRemoved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7654936447947272417L;

    @JsonProperty("webSearchUrl")
    public String getWebSearchUrl() {
        return webSearchUrl;
    }

    @JsonProperty("webSearchUrl")
    public void setWebSearchUrl(String webSearchUrl) {
        this.webSearchUrl = webSearchUrl;
    }

    @JsonProperty("totalEstimatedMatches")
    public Integer getTotalEstimatedMatches() {
        return totalEstimatedMatches;
    }

    @JsonProperty("totalEstimatedMatches")
    public void setTotalEstimatedMatches(Integer totalEstimatedMatches) {
        this.totalEstimatedMatches = totalEstimatedMatches;
    }

    @JsonProperty("value")
    public List<Value> getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(List<Value> value) {
        this.value = value;
    }

    @JsonProperty("someResultsRemoved")
    public Boolean getSomeResultsRemoved() {
        return someResultsRemoved;
    }

    @JsonProperty("someResultsRemoved")
    public void setSomeResultsRemoved(Boolean someResultsRemoved) {
        this.someResultsRemoved = someResultsRemoved;
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
