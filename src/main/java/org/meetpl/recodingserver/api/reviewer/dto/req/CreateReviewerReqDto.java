package org.meetpl.recodingserver.api.reviewer.dto.req;

import org.meetpl.recodingserver.domain.reviewer.domain.Skill;

import java.util.List;

public record CreateReviewerReqDto(
        String corporation,
        String job,
        String careerYear,
        List<Skill> skills,
        List<String> careerInfos
) {
}
