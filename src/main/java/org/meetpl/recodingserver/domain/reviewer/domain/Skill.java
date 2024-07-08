package org.meetpl.recodingserver.domain.reviewer.domain;
import jakarta.persistence.*;
import lombok.*;

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

    public static Skill createSkill(SkillType skillType, Reviewer reviewer){
        return Skill.builder()
                .skillType(skillType)
                .reviewer(reviewer)
                .build();
    }
    public static Skill from(SkillType skillType){
        return Skill.builder()
                .skillType(skillType)
                .reviewer(null)
                .build();
    }
}
