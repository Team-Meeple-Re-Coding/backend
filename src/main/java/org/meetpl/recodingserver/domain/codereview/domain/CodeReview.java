package org.meetpl.recodingserver.domain.codereview.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.reviewee.domain.Reviewee;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.global.common.BaseTimeEntity;

@Entity
@Table(name = "code_review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class CodeReview extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String request;
    private String projectInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewee_id")
    private Reviewee reviewee;
}
