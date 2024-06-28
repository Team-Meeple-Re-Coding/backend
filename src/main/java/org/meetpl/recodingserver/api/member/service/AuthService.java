package org.meetpl.recodingserver.api.member.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.member.service.dto.res.MemberAuthResDto;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.member.domain.Platform;
import org.meetpl.recodingserver.domain.member.service.MemberModifier;
import org.meetpl.recodingserver.domain.member.service.MemberReader;
import org.meetpl.recodingserver.global.config.auth.TokenInfo;
import org.meetpl.recodingserver.global.config.jwt.JwtProvider;
import org.meetpl.recodingserver.global.external.auth.PlatformUserInfo;
import org.meetpl.recodingserver.global.external.auth.RestTemplateProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

import static org.meetpl.recodingserver.domain.member.domain.Platform.getEnumPlatformFromStringPlatform;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService{
    private final JwtProvider jwtProvider;
    private final RestTemplateProvider restTemplateProvider;
    private final MemberReader memberReader;
    private final MemberModifier memberModifier;
    public MemberAuthResDto signIn(String code) throws JsonProcessingException {
        String authToken = restTemplateProvider.getAuthTokenByCode(code);
        Platform platform = getEnumPlatformFromStringPlatform("kakao");
        PlatformUserInfo platformUser = getPlatformUserInfoFromRestTemplate(platform, authToken);
        Member getMember = saveMember(platformUser, platform);
        Boolean isFirstLogin = Objects.isNull(getMember.getPlatformId()) ? Boolean.TRUE : Boolean.FALSE;
        TokenInfo tokenInfo = issueAccessTokenAndRefreshToken(getMember);
        updateRefreshToken(tokenInfo.getRefreshToken(), getMember);
        return MemberAuthResDto.of(getMember, tokenInfo, isFirstLogin);
    }
    private void updateRefreshToken(String refreshToken, Member member) {
        member.updateRefreshToken(refreshToken);
    }
    private PlatformUserInfo getPlatformUserInfoFromRestTemplate(Platform platform, String authToken) {
        return restTemplateProvider.getUserInfoUsingRestTemplate(platform, authToken);
    }
    private TokenInfo issueAccessTokenAndRefreshToken(Member member) {
        return TokenInfo.of(
                jwtProvider.getIssueToken(member.getId(), true),
                jwtProvider.getIssueToken(member.getId(), false)
        );
    }
    private Member saveMember(PlatformUserInfo platformUserInfo, Platform platform) {
        Member createdMember = getUserByPlatformUserInfo(platformUserInfo, platform);
        return memberModifier.save(createdMember);
    }
    private Member getUserByPlatformUserInfo(PlatformUserInfo platformUserInfo, Platform platform) {
        Optional<Member> optionalUser = memberReader.findByPlatformId(platformUserInfo.getId());
        return optionalUser.orElseGet(() -> Member.createMember(platformUserInfo, platform));
    }
}
