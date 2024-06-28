package org.meetpl.recodingserver.api.member.service.dto.res;

import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.global.config.auth.TokenInfo;

public record MemberAuthResDto(
        Long memberId,
        String email,
        String name,
        String picture,
        String accessToken,
        String refreshToken,
        Boolean isFirst

) {
    public static MemberAuthResDto of(Member member, TokenInfo token, Boolean isFirst){
        return new MemberAuthResDto(member.getId(), member.getEmail(), member.getName(), member.getProfile(), token.getAccessToken(), token.getRefreshToken(),isFirst);
    }
}
