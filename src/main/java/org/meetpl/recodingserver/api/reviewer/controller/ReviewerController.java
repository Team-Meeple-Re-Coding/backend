package org.meetpl.recodingserver.api.reviewer.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.reviewer.dto.res.ReviewerDetailResDto;
import org.meetpl.recodingserver.api.reviewer.service.ReviewerService;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewerController {
    private final ReviewerService reviewerService;

    @GetMapping("/{reviewerId}")
    public ResponseEntity<SuccessResponse<?>> getReviewerDetail(@PathVariable final Long reviewerId) {
        final ReviewerDetailResDto responseDto = reviewerService.getReviewerDetail(reviewerId);
        return SuccessResponse.ok(responseDto);
    }
}
