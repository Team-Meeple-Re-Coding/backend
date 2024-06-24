package org.meetpl.recodingserver.domain.codereview.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;

@Entity
@Table(name = "review_skill")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ReviewSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
}
