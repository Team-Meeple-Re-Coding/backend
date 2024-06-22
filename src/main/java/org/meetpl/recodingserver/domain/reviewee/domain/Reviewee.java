package org.meetpl.recodingserver.domain.reviewee.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.member.domain.Member;

import java.time.LocalDate;

@Entity
@Table(name = "reviewee")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Reviewee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String applicationFormLink;
    private String chattingLink;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne
    private CodeReview codeReview;
}
