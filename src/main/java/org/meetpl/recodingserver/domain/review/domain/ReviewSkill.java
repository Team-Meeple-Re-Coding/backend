package org.meetpl.recodingserver.domain.review.domain;

import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "reviewe_skill")
@Getter
@Entity
public class ReviewSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;
}
