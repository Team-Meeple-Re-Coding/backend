package org.meetpl.recodingserver.domain.reviewer.domain;

import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.global.common.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reviewer")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Reviewer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String corporation;
    private String githubLink;
    private String intro;
    private String codeStyle;
    private String careerInfo;
    private Integer careerYear;
    @Enumerated(EnumType.STRING)
    private Job job;
    @OneToMany(mappedBy = "reviewer")
    @Builder.Default
    private List<CodeReview> codeReviews = new ArrayList<>();
    @OneToMany(mappedBy = "reviewer")
    @Builder.Default
    private List<Skill> skills = new ArrayList<>();
    @OneToOne
    private Member member;
    public static Reviewer of(Long id, String corporation, String githubLink, String intro, String codeStyle, String careerInfo
    , Integer careerYear, Job job, List<CodeReview> codeReviews, List<Skill> skills, Member member){
        return Reviewer.builder()
                .id(id)
                .corporation(corporation)
                .githubLink(githubLink)
                .intro(intro)
                .codeStyle(codeStyle)
                .careerInfo(careerInfo)
                .careerYear(careerYear)
                .job(job)
                .codeReviews(codeReviews)
                .skills(skills)
                .member(member)
                .build();
    }
}
