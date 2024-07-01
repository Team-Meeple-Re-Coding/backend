package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewerAppender {
    private final ReviewerRepository reviewerRepository;
    @Transactional
    public void createReviewer(Reviewer reviewer){
        reviewerRepository.save(reviewer);
    }
}
