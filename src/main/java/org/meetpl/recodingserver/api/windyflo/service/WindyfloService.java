package org.meetpl.recodingserver.api.windyflo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewGitReqDto;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewReqDto;
import org.meetpl.recodingserver.api.windyflo.service.dto.res.AiReviewResDto;
import org.meetpl.recodingserver.global.external.windyflo.WindyfloClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WindyfloService{
    private final WindyfloClient windyfloClient;
    private final ObjectMapper objectMapper;
    public AiReviewResDto postAiCodeReview(AiReviewReqDto aiReviewReqDto) throws JsonProcessingException {
        return extractReviewRes(windyfloClient.aiCodeReview(aiReviewReqDto));
    }
    public AiReviewResDto postAiCodeReviewGit(AiReviewGitReqDto aiReviewReqDto) throws JsonProcessingException {
        return extractReviewGitRes(windyfloClient.aiCodeReviewGit(aiReviewReqDto));
    }


    public AiReviewResDto extractReviewRes(Object input) throws JsonProcessingException {
        JsonNode rootNode = objectMapper.readTree(input.toString());
        JsonNode jsonNode = rootNode.get("json");
        String style = jsonNode.path("style").asText();
        String code = jsonNode.path("code").asText();
        return AiReviewResDto.of(style, code);
    }
    public AiReviewResDto extractReviewGitRes(Object input) throws JsonProcessingException {
        JsonNode rootNode = objectMapper.readTree(input.toString());
        String textContent = rootNode.get("text").asText();
        JsonNode jsonNode = objectMapper.readTree(textContent);
        String style = jsonNode.path("style").asText();
        String code = jsonNode.path("code").asText();
        return AiReviewResDto.of(style, code);
    }
}
