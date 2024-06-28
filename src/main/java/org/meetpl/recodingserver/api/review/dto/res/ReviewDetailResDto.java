package org.meetpl.recodingserver.api.review.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;

import java.time.LocalDateTime;
import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReviewDetailResDto(
        Long reviewId,
        String name,
        String profile,
        Integer rating,
        String contents,
        String request,
        String projectInfo,
        LocalDateTime createDate,
        List<SkillType> skills
) {
    public static ReviewDetailResDto of(ReviewDetailDto reviewDetailDto, List<SkillType> skills) {
        return ReviewDetailResDto.builder()
                .reviewId(reviewDetailDto.review().getId())
                .name(reviewDetailDto.name())
                .profile(reviewDetailDto.profile())
                .rating(reviewDetailDto.review().getRating())
                .contents(reviewDetailDto.review().getContents())
                .request(reviewDetailDto.request())
                .projectInfo(reviewDetailDto.projectInfo())
                .createDate(reviewDetailDto.review().getCreateDate())
                .skills(skills)
                .build();
    }
}
