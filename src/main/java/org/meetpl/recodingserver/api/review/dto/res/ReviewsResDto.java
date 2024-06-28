package org.meetpl.recodingserver.api.review.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import org.meetpl.recodingserver.global.common.PageInfo;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReviewsResDto(
        List<ReviewDetailResDto> reviews,
        PageInfo pageInfo
) {
    public static ReviewsResDto of(List<ReviewDetailResDto> reviews, PageInfo pageInfo) {
        return ReviewsResDto.builder()
                .reviews(reviews)
                .pageInfo(pageInfo)
                .build();
    }
}
