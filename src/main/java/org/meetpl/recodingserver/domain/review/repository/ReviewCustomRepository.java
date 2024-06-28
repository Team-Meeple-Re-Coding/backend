package org.meetpl.recodingserver.domain.review.repository;

import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewCustomRepository {
    Page<ReviewDetailDto> findReviewDetailDtoListByReviewerId(Long reviewerId, Pageable pageable);

    Long findReviewCountByReviewerId(Long reviewerId);
}
