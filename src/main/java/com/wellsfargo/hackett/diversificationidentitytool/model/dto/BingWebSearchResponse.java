
package com.wellsfargo.hackett.diversificationidentitytool.model.dto;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_type",
        "queryContext",
        "webPages",
        "rankingResponse"
})
@Generated("jsonschema2pojo")
public class BingWebSearchResponse implements Serializable {

    @JsonProperty("_type")
    private String type;
    @JsonProperty("queryContext")
    private QueryContext queryContext;
    @JsonProperty("webPages")
    private WebPages webPages;
    @JsonProperty("rankingResponse")
    private RankingResponse rankingResponse;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -2785605762602992531L;

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("queryContext")
    public QueryContext getQueryContext() {
        return queryContext;
    }

    @JsonProperty("queryContext")
    public void setQueryContext(QueryContext queryContext) {
        this.queryContext = queryContext;
    }

    @JsonProperty("webPages")
    public WebPages getWebPages() {
        return webPages;
    }

    @JsonProperty("webPages")
    public void setWebPages(WebPages webPages) {
        this.webPages = webPages;
    }

    @JsonProperty("rankingResponse")
    public RankingResponse getRankingResponse() {
        return rankingResponse;
    }

    @JsonProperty("rankingResponse")
    public void setRankingResponse(RankingResponse rankingResponse) {
        this.rankingResponse = rankingResponse;
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
