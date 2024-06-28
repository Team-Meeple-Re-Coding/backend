package org.meetpl.recodingserver.api.search.dto.res;

import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;

import java.util.List;

public record ReviewerInfoResDto(
        MemberSimpleResDto member,
        String intro,
        String job,
        List<String> stacks,
        Long codeReviewCount,
        Integer reviewContentCnt
) {
    public static ReviewerInfoResDto of(MemberSimpleResDto member, Reviewer reviewer, List<Skill> skills, Long reviewCnt) {
        return new ReviewerInfoResDto(
                member,
                reviewer.getIntro(),
                reviewer.getJob().getStringJob(),
                skills.stream().map(skill -> skill.getSkillType().getStringSkill()).toList(),
                reviewCnt,
                reviewer.getCodeReviews().size()
        );
    }
}
