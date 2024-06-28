package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.api.search.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ReviewerRepositoryCustom {
    Page<Reviewer> findReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto);
    Optional<ReviewerDetailDto> findReviewerDetailById(Long reviewerId);
}
