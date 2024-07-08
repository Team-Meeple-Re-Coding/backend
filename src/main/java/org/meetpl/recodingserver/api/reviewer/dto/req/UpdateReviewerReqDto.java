package org.meetpl.recodingserver.api.reviewer.dto.req;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.reviewer.domain.Job;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;

import java.util.List;

public record UpdateReviewerReqDto(
        String nickName,
        List<String> skills,
        String corporation,
        String job,
        Integer careerYear,
        String skill,
        String jobInfo,
        String careerInfo,
        String codeStyle,
        String intro,
        String githubLink
) {
    public Reviewer toReviewer(Long reviewerId, List<SkillType> skillTypes, Job job, Member member){
        List<Skill> skills = skillTypes.stream().map(Skill::from).toList();
        return Reviewer.of(
                reviewerId,
                corporation,
                githubLink,
                intro,
                codeStyle,
                careerInfo,
                careerYear,
                job,
                null,
                skills,
                member
        );
    }
}
