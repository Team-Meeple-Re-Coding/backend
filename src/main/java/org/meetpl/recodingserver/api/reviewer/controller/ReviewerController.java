package org.meetpl.recodingserver.api.reviewer.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.reviewer.dto.req.CreateReviewerReqDto;
import org.meetpl.recodingserver.api.reviewer.dto.res.ReviewerDetailResDto;
import org.meetpl.recodingserver.api.reviewer.service.ReviewerService;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.meetpl.recodingserver.global.config.auth.UserId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reviewer")
public class ReviewerController {
    private final ReviewerService reviewerService;

    @GetMapping("/{reviewerId}")
    public ResponseEntity<SuccessResponse<?>> getReviewerDetail(@PathVariable final Long reviewerId) {
        final ReviewerDetailResDto responseDto = reviewerService.getReviewerDetail(reviewerId);
        return SuccessResponse.ok(responseDto);
    }
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> createReviewer(@UserId Long memberId, @RequestBody final CreateReviewerReqDto createReviewerReqDto) {
        reviewerService.createReviewer(memberId, createReviewerReqDto);
        return SuccessResponse.ok(null);
    }
}