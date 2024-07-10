package org.meetpl.recodingserver.domain.review.domain;

import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.reviewee.domain.Reviewee;
import org.meetpl.recodingserver.global.common.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Table(name = "review")
@Getter
@Entity
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    private String contents;
    @OneToMany(mappedBy = "review")
    @Builder.Default
    private List<ReviewSkill> skills = new ArrayList<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewee_id")
    private Reviewee reviewee;
}
