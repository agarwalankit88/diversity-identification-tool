
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
    "answerType",
    "resultIndex",
    "value"
})
@Generated("jsonschema2pojo")
public class Item implements Serializable
{

    @JsonProperty("answerType")
    private String answerType;
    @JsonProperty("resultIndex")
    private Integer resultIndex;
    @JsonProperty("value")
    private Value__1 value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5838669540308485896L;

    @JsonProperty("answerType")
    public String getAnswerType() {
        return answerType;
    }

    @JsonProperty("answerType")
    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    @JsonProperty("resultIndex")
    public Integer getResultIndex() {
        return resultIndex;
    }

    @JsonProperty("resultIndex")
    public void setResultIndex(Integer resultIndex) {
        this.resultIndex = resultIndex;
    }

    @JsonProperty("value")
    public Value__1 getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value__1 value) {
        this.value = value;
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
