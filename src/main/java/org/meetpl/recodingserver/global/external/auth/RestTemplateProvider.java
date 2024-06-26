package org.meetpl.recodingserver.global.external.auth;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.member.domain.Platform;
import org.meetpl.recodingserver.global.external.auth.kakao.KakaoAuthProvider;
import org.meetpl.recodingserver.global.external.auth.kakao.KakaoUserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RestTemplateProvider {
    private final KakaoAuthProvider kakaoAuthProvider;

    public PlatformUserInfo getUserInfoUsingRestTemplate(Platform platform, String accessToken) {
        ResponseEntity<String> platformResponse = getUserInfoFromPlatform(platform, accessToken);
        return getUserInfoFromPlatformInfo(platform, platformResponse.getBody());
    }
    public String getAuthTokenByCode(String code){
        return kakaoAuthProvider.getAuthToken(code);
    }

    private ResponseEntity<String> getUserInfoFromPlatform(Platform platform, String accessToken) {
        if (platform.equals(Platform.KAKAO))
            return kakaoAuthProvider.createGetRequest(accessToken);
        return null;
    }

    private PlatformUserInfo getUserInfoFromPlatformInfo(Platform platform, String platformInfo) {
        if (platform.equals(Platform.KAKAO)) {
            KakaoUserInfo kakaoUserInfo = kakaoAuthProvider.getKakaoUserInfoFromPlatformInfo(platformInfo);
            return PlatformUserInfo.createPlatformUserInfo(
                    Long.toString(kakaoUserInfo.getId()),
                    kakaoUserInfo.getKakaoAccount().getEmail(),
                    getNickName(kakaoUserInfo),
                    getPicture(kakaoUserInfo));
        } else {
            return null;
        }
    }

    private String getNickName(KakaoUserInfo kakaoUserInfo) {
        if (kakaoUserInfo.getProperties() != null) {
            return kakaoUserInfo.getProperties().getNickname();
        } else {
            return "Unknown";
        }
    }

    private String getPicture(KakaoUserInfo kakaoUserInfo) {
        if (kakaoUserInfo.getProperties() != null) {
            return kakaoUserInfo.getProperties().getProfileImage();
        } else {
            return "Unknown";
        }
    }
}
