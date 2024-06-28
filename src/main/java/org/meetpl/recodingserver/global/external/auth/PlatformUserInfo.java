package org.meetpl.recodingserver.global.external.auth;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlatformUserInfo {
    private String id;
    private String email;
    private String name;
    private String picture;

    public static PlatformUserInfo createPlatformUserInfo(String id, String email, String name, String picture) {
        return PlatformUserInfo.builder()
                .id(id)
                .email(email)
                .name(name)
                .picture(picture)
                .build();
    }
}
