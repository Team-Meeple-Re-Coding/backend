package org.meetpl.recodingserver.api.search.service.dto.res;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;

import java.util.List;

public record ReviewerInfoResDto(
        MemberSimpleResDto member,
        String intro,
        String job,
        List<String> stacks,
        Integer reviewCnt,
        Integer reviewContentCnt
) {
    public static ReviewerInfoResDto of(MemberSimpleResDto member, Reviewer reviewer, List<Skill> skills){
        return new ReviewerInfoResDto(
                member,
                reviewer.getIntro(),
                reviewer.getJob().getStringJob(),
                skills.stream().map(skill -> skill.getSkillType().getStringSkill()).toList(),
                reviewer.getReviewCount(),
                reviewer.getReviewContentCount()
        );
    }
}
