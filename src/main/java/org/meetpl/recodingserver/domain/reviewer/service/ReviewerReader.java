package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.service.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepository;
import org.meetpl.recodingserver.domain.reviewer.repository.ReviewerRepositoryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewerReader {
    private final ReviewerRepositoryImpl reviewerRepository;
    public Page<Reviewer> getReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto) {
        return reviewerRepository.findReviewerBySearchReqDto(pageable, searchReqDto);
    }
}
