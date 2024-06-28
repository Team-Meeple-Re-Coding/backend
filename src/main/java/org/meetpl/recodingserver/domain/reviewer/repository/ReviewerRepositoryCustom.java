package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.api.search.service.dto.req.SearchReqDto;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewerRepositoryCustom {
    Page<Reviewer> findReviewerBySearchReqDto(Pageable pageable, SearchReqDto searchReqDto);
}
