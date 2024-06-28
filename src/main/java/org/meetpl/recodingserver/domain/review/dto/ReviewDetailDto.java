package org.meetpl.recodingserver.domain.review.dto;

import org.meetpl.recodingserver.domain.review.domain.Review;

public record ReviewDetailDto(
        Review review,
        String name,
        String profile,
        String request,
        String projectInfo
) {
}
