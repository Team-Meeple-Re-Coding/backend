package org.meetpl.recodingserver.domain.reviewer.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.codereview.domain.SkillType;
import org.meetpl.recodingserver.domain.member.domain.Member;

@Entity
@Table(name = "skill")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
}
