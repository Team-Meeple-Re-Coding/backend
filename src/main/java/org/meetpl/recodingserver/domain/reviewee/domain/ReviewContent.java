package org.meetpl.recodingserver.domain.reviewee.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review_content")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer gpa;
    @OneToOne
    private ReviewContent reviewContent;
}
