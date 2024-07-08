package org.meetpl.recodingserver.api.reviewer.dto.req;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;

import java.util.List;

public record CreateReviewerReqDto(
        String corporation,
        String job,
        Integer careerYear,
        List<String> skills,
        String careerInfo
) {
    public Reviewer toReviewer(List<SkillType> skillTypes,Member member){
        List<Skill> skills = skillTypes.stream().map(Skill::from).toList();
        return Reviewer.of(
                null,
                corporation,
                null,
                null,
                null,
                careerInfo,
                careerYear,
                null,
                null,
                skills,
                member
        );
    }
}
