package org.meetpl.recodingserver.api.search.service.dto.res;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.reviewer.domain.Career;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;

public record MemberSimpleResDto(
        String name,
        String corporation,
        String job,
        String career
) {
    public static MemberSimpleResDto of(Member member, Reviewer reviewer, Career career){
        return new MemberSimpleResDto(member.getName(), reviewer.getCorporation(), reviewer.getJob().getStringJob(), career.getContent());
    }
}
