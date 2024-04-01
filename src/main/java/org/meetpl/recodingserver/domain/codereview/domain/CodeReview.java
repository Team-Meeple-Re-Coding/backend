package org.meetpl.recodingserver.domain.codereview.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;

@Entity
@Table(name = "code_review")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CodeReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String request;
    private String projectInfo;
    @OneToOne
    private Reviewer reviewer;
}
