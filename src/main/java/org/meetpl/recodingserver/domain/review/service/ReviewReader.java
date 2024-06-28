package org.meetpl.recodingserver.domain.review.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.meetpl.recodingserver.domain.review.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewReader {
    private final ReviewRepository reviewRepository;

    public Page<ReviewDetailDto> findReviewDetailDtoListByReviewerId(Long reviewerId, Pageable pageable) {
        return reviewRepository.findReviewDetailDtoListByReviewerId(reviewerId, pageable);
    }

    public Long findReviewCountByReviewerId(Long reviewerId) {
        return reviewRepository.findReviewCountByReviewerId(reviewerId);
    }
}
