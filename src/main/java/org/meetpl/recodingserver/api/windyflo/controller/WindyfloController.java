package org.meetpl.recodingserver.api.windyflo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.windyflo.service.WindyfloService;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewGitReqDto;
import org.meetpl.recodingserver.api.windyflo.service.dto.req.AiReviewReqDto;
import org.meetpl.recodingserver.api.windyflo.service.dto.res.AiReviewResDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/windyflo")
public class WindyfloController {

    private final WindyfloService windyfloService;

    @PostMapping("/codeReview")
    ResponseEntity<SuccessResponse<?>> aiCodeReview(@RequestBody AiReviewReqDto aiReviewReqDto) throws JsonProcessingException {
        AiReviewResDto aiReviewResDto = windyfloService.postAiCodeReview(aiReviewReqDto);
        return SuccessResponse.ok(aiReviewResDto);
    }
    @PostMapping("/git/codeReview")
    ResponseEntity<SuccessResponse<?>> aiCodeReviewGit(@RequestBody AiReviewGitReqDto aiReviewReqDto) throws JsonProcessingException {
        AiReviewResDto aiReviewResDto = windyfloService.postAiCodeReviewGit(aiReviewReqDto);
        return SuccessResponse.ok(aiReviewResDto);
    }
}
