package org.meetpl.recodingserver.api.reviewer.dto.res;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;

import java.util.List;

public record ReviewerResDto(
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
    public static ReviewerResDto of(Member member, Reviewer reviewer){
        return new ReviewerResDto(
                member.getName(),
                reviewer.getSkills().stream().map(skill1 -> skill1.getSkillType().getStringSkill()).toList(),
                reviewer.getCorporation(),
                reviewer.getJob().getStringJob(),
                reviewer.getCareerYear(),
                null,
                null,
                reviewer.getCareerInfo(),
                reviewer.getCodeStyle(),
                reviewer.getIntro(),
                reviewer.getGithubLink()
        );
    }
}
