package org.meetpl.recodingserver.domain.reviewee.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review_tag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @OneToOne
    private Reviewee reviewee;
}
