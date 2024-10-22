package org.meetpl.recodingserver.global.external.windyflo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewReqDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WindyfloClient {
    private final String AI_CODEREVIEW_URL = "https://windyflo.com/api/v1/prediction/83466e2d-3e29-4a67-aca3-01fd168400f2";
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public JsonNode aiCodeReview(AiReviewReqDto aiReviewReqDto) {
        ObjectNode requestBody = objectMapper.createObjectNode();
        requestBody.put("code", aiReviewReqDto.code());
        requestBody.put("style", aiReviewReqDto.style());
        QuestionRequest questionRequest = new QuestionRequest(requestBody.toString());

        return webClient.post()
                .uri(AI_CODEREVIEW_URL)
                .bodyValue(questionRequest)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }
}
