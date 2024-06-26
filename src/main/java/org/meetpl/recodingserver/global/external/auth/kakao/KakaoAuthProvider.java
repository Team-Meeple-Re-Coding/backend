package org.meetpl.recodingserver.global.external.auth.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.global.error.exception.InternalServerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.meetpl.recodingserver.global.error.ErrorCode.JSON_PARSING_ERROR;
import static org.meetpl.recodingserver.global.external.auth.kakao.KakaoToken.createKakaoToken;


@RequiredArgsConstructor
@Component
public class KakaoAuthProvider {
    private final static String KAKAO_URL = "https://kapi.kakao.com/v2/user/me";
    private static final String KAKAO_TOKEN_ENDPOINT = "https://kauth.kakao.com/oauth/token";
    private static final String HEADER_TYPE = "Authorization";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${app.kakao.client.id}")
    private String KAKAO_CLIENT_ID;

    @Value("${app.kakao.client.secret}")
    private String KAKAO_CLIENT_SECRET;

    @Value("${app.kakao.callback.url}")
    private String KAKAO_REDIRECT_URI;

    public String getAuthToken(String code){
//        RestTemplate restTemplate = new RestTemplate();
        String accessToken = restTemplate.postForObject(KAKAO_TOKEN_ENDPOINT +
                "?grant_type=authorization_code" +
                "&client_id=" + KAKAO_CLIENT_ID +
                "&client_secret=" + KAKAO_CLIENT_SECRET +
                "&redirect_uri=" + KAKAO_REDIRECT_URI +
                "&code=" + code, null, String.class);
        return accessToken;
    }
    public ResponseEntity<String> createGetRequest(String accessToken) {
        KakaoToken kakaoToken = createKakaoToken(accessToken);
        String kakaoAccessToken = kakaoToken.getAccessTokenWithTokenType();
        HttpEntity<String> request = createHttpEntityFromKakaoToken(kakaoAccessToken);
        return restTemplate.exchange(KAKAO_URL, HttpMethod.GET, request, String.class);
    }

    public KakaoUserInfo getKakaoUserInfoFromPlatformInfo(String platformInfo) {
        KakaoUserInfo kakaoUserInfo;
        try {
            kakaoUserInfo = objectMapper.readValue(platformInfo, KakaoUserInfo.class);
        } catch (JsonProcessingException e) {
            throw new InternalServerException(JSON_PARSING_ERROR);
        }
        return kakaoUserInfo;
    }

    private HttpEntity<String> createHttpEntityFromKakaoToken(String kakaoAccessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_TYPE, kakaoAccessToken);
        return new HttpEntity<>(headers);
    }
}
