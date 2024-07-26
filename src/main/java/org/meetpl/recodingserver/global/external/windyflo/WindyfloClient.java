package org.meetpl.recodingserver.global.external.windyflo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewGitReqDto;
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
    private final String AI_CODEREVIEW_URL = "https://windyflo.com/api/v1/prediction/3d0e863a-fe60-4e8b-8b23-9a030d0afc42";
    private final String AI_GIT_CODEREVIEW_URL = "https://windyflo.com/api/v1/prediction/ba19fd63-8c83-441c-a2de-3d3d0e682925";
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
    public JsonNode aiCodeReviewGit(AiReviewGitReqDto aiReviewReqDto) {
        ObjectNode requestBody = objectMapper.createObjectNode();
        requestBody.put("CODE_STYLE", aiReviewReqDto.CODE_STYLE());
        requestBody.put("CLASS_NAME", aiReviewReqDto.CLASS_NAME());
        QuestionRequest questionRequest = new QuestionRequest(requestBody.toString());

        return webClient.post()
                .uri(AI_GIT_CODEREVIEW_URL)
                .bodyValue(questionRequest)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }

}
