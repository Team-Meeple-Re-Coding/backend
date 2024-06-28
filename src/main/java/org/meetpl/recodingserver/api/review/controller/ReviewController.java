package org.meetpl.recodingserver.api.review.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.review.dto.res.ReviewsResDto;
import org.meetpl.recodingserver.api.review.service.ReviewService;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{reviewerId}")
    public ResponseEntity<SuccessResponse<?>> getReviewsForReviewer(@PathVariable final Long reviewerId,
                                                                    final Pageable pageable) {
        final ReviewsResDto responseDto = reviewService.getReviewsForReviewer(reviewerId, pageable);
        return SuccessResponse.ok(responseDto);
    }
}
