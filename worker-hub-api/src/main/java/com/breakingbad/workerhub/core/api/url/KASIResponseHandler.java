package com.breakingbad.workerhub.core.api.url;

import com.breakingbad.workerhub.core.api.model.KASiResponse;
import com.breakingbad.workerhub.core.parser.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class KASIResponseHandler implements APIResponseHandler<KASiResponse> {

    private final String json;

    private static final String RESPONSE = "response";

    private static final String BODY = "body";

    private static final String TOTAL_COUNT = "totalCount";

    private static final String ITEMS = "items";

    private static final String ITEM = "item";

    private static final String DATE_NAME = "dateName";

    private static final String LOC_DATE = "locdate";

    @Override
    @SuppressWarnings("unchecked")
    public KASiResponse handle() throws JsonProcessingException {
        List<Map<String, Object>> result = new ArrayList<>();

        Map<String, Object> map = JsonParser.toMap(json);
        Map<String, Object> response = (Map<String, Object>) map.get(RESPONSE);
        Map<String, Object> body = (Map<String, Object>) response.get(BODY);

        int totalCount = (int) body.get(TOTAL_COUNT);

        if (totalCount <= 0) {
            return new KASiResponse();
        }

        if (totalCount == 1) {
            Map<String, Object> items = (Map<String, Object>) body.get(ITEMS);
            Map<String, Object> item = (Map<String, Object>) items.get(ITEM);
            result.add(item);
        }

        if (totalCount > 1) {
            Map<String, Object> items = (Map<String, Object>) body.get(ITEMS);
            List<Map<String, Object>> item = (List<Map<String, Object>>) items.get(ITEM);
            result.addAll(item);
        }

        return convert(result);
    }

    private KASiResponse convert(List<Map<String, Object>> result) {
        List<KASiResponse.Items> items = new ArrayList<>();
        KASiResponse kasiResponses = new KASiResponse(items);
        result.forEach(map ->
                items.add(new KASiResponse.Items((String) map.get(DATE_NAME), (Integer) map.get(LOC_DATE)))
        );

        return kasiResponses;
    }

}
