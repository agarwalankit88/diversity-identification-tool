package com.wellsfargo.hackett.diversificationidentitytool.business;

import com.wellsfargo.hackett.diversificationidentitytool.model.DiversificationResponse;
import com.wellsfargo.hackett.diversificationidentitytool.model.dto.BingWebSearchResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ScrapingService {

    public DiversificationResponse scrapeSearchResults(BingWebSearchResponse bingWebSearchResponse) {

        DiversificationResponse response = new DiversificationResponse();
        AtomicInteger count = new AtomicInteger(1);
        Optional.ofNullable(bingWebSearchResponse).map(bingWebSearchResponse1 -> bingWebSearchResponse1.getWebPages().getValue())
                .map(values -> {
                    Map<String, List<String>> map = new HashMap<>();
                    values.forEach(value -> map.put("url" + count.getAndIncrement(), List.of(value.getUrl())));
                    response.setResponse(map);
                    return null;
                });
        return response;
    }
}
