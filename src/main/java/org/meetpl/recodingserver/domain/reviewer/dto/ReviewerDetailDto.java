package org.meetpl.recodingserver.domain.reviewer.dto;

import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.review.domain.Review;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;

import java.util.List;

public record ReviewerDetailDto(
        Long reviewId,
        String name,
        String profile,
        String corporation,
        String githubLink,
        String intro,
        String codeStyle,
        String careerInfo,
        Integer careerYear,
        List<CodeReview> codeReviews,
        List<Skill> skills
) {
}
