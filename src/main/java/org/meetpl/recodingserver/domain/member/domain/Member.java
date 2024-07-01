package org.meetpl.recodingserver.domain.member.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.global.external.auth.PlatformUserInfo;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String platformId;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    private String name;
    private String profile;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private Type type;
    private String refreshToken;

    public static Member createMember(PlatformUserInfo platformUserInfo, Platform platform) {
        return Member.builder()
                .platformId(platformUserInfo.getId())
                .platform(platform)
                .email(platformUserInfo.getEmail())
                .name(platformUserInfo.getName())
                .profile(platformUserInfo.getPicture())
                .build();
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public Member updateName(String name) {
        this.name = name;
        return this;
    }
}
