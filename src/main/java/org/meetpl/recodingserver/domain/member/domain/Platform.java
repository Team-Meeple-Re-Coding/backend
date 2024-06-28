package org.meetpl.recodingserver.domain.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_PLATFORM_TYPE;


@RequiredArgsConstructor
@Getter
public enum Platform {
    GOOGLE("google"),
    KAKAO("kakao"),
    WITHDRAW("withdraw");

    private final String stringPlatform;

    public static Platform getEnumPlatformFromStringPlatform(String stringPlatform) {
        return Arrays.stream(values())
                .filter(platform -> platform.stringPlatform.equals(stringPlatform))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_PLATFORM_TYPE));
    }
}

