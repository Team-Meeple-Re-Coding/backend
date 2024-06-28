package org.meetpl.recodingserver.api.reviewer.dto.res;

import lombok.AccessLevel;
import lombok.Builder;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;

import java.util.List;

@Builder(access = AccessLevel.PRIVATE)
public record ReviewerDetailResDto(
        Long reviewId,
        String name,
        String profile,
        String corporation,
        String githubLink,
        String intro,
        String codeStyle,
        String careerInfo,
        Integer careerYear,
        Integer codeReviewCount,
        Double reviewAvg,
        List<SkillType> skills
) {
    public static ReviewerDetailResDto of(ReviewerDetailDto reviewerDetailDto,
                                          List<SkillType> skills,
                                          Double reviewAvg) {
        return ReviewerDetailResDto.builder()
                .reviewId(reviewerDetailDto.reviewId())
                .name(reviewerDetailDto.name())
                .profile(reviewerDetailDto.profile())
                .corporation(reviewerDetailDto.corporation())
                .githubLink(reviewerDetailDto.githubLink())
                .intro(reviewerDetailDto.intro())
                .codeStyle(reviewerDetailDto.codeStyle())
                .careerInfo(reviewerDetailDto.careerInfo())
                .careerYear(reviewerDetailDto.careerYear())
                .codeReviewCount(reviewerDetailDto.codeReviews().size())
                .reviewAvg(reviewAvg)
                .skills(skills)
                .build();
    }
}
