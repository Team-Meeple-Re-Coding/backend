package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepository;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepositoryImpl;
import org.meetpl.recodingserver.global.error.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.meetpl.recodingserver.global.error.ErrorCode.REVIEWER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ReviewerReader {
    private final ReviewerRepositoryImpl reviewerRepository;
    private final ReviewerRepository reviewerJpaRepository;

    public Page<Reviewer> getReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto) {
        return reviewerRepository.findReviewerBySearchReqDto(pageable, searchReqDto);
    }

    public ReviewerDetailDto findReviewerDetailById(Long reviewId) {
        return reviewerRepository.findReviewerDetailById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException(REVIEWER_NOT_FOUND));
    }

    public Reviewer getReviewerByMemberId(Long memberId) {
        return reviewerJpaRepository.findReviewerByMemberId(memberId).orElseThrow(() -> new EntityNotFoundException(REVIEWER_NOT_FOUND));
    }
}
