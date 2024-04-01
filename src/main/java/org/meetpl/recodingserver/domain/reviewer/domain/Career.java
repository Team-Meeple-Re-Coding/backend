package org.meetpl.recodingserver.domain.reviewer.domain;
import jakarta.persistence.*;
import lombok.*;
import org.meetpl.recodingserver.domain.member.domain.Member;

@Entity
@Table(name = "career")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Career {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
}
