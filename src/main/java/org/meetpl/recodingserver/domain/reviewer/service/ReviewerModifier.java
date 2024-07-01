package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewerModifier {
    private final ReviewerRepository reviewerRepository;

    public void updateReviewer(Reviewer reviewer){
        reviewerRepository.save(reviewer);
    }
}
