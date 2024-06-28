package org.meetpl.recodingserver.api.review.mapper;

import org.meetpl.recodingserver.api.review.dto.res.ReviewDetailResDto;
import org.meetpl.recodingserver.api.review.dto.res.ReviewsResDto;
import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.global.common.PageInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewMapper {
    public ReviewDetailResDto toReviewDetailDto(ReviewDetailDto dto, List<SkillType> skills) {
        return ReviewDetailResDto.of(dto, skills);
    }

    public ReviewsResDto toReviewsResDto(List<ReviewDetailResDto> resDtoList, PageInfo pageInfo) {
        return ReviewsResDto.of(resDtoList, pageInfo);
    }
}
