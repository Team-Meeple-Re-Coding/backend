package org.meetpl.recodingserver.domain.reviewer.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.member.domain.Member;

import java.time.LocalDate;

@Entity
@Table(name = "reviewer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Reviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String corporation;
    private LocalDate enterDate;
    private String githubLink;
    private String intro;
    private String codeStyle;
    private Integer reviewCount;
    private Integer reviewContentCount;
    @Enumerated(EnumType.STRING)
    private Job job;
    @OneToOne
    private CodeReview codeReview;
    @OneToOne
    private Member member;
}
