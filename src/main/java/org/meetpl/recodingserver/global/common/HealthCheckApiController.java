package org.meetpl.recodingserver.global.common;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class HealthCheckApiController {
    @Value("${app.kakao.client.id}")
    private String KAKAO_CLIENT_ID;

    @Value("${app.kakao.client.secret}")
    private String KAKAO_CLIENT_SECRET;

    @Value("${app.kakao.callback.url}")
    private String KAKAO_REDIRECT_URI;
    private static final String KAKAO_AUTH_ENDPOINT = "https://kauth.kakao.com/oauth/authorize";

    @GetMapping("/")
    public String CheckmateServer() {
        return "hi!";
    }
    @GetMapping("/oauth/kakao")
    public void kakaoOauth(HttpServletResponse response) throws IOException {
        String authUrl = KAKAO_AUTH_ENDPOINT +
                "?client_id=" + KAKAO_CLIENT_ID +
                "&redirect_uri=" + KAKAO_REDIRECT_URI +
                "&response_type=code";

        response.sendRedirect(authUrl);
    }
}
