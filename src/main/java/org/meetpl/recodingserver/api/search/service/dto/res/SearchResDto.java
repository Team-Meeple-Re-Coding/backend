package org.meetpl.recodingserver.api.search.service.dto.res;

import org.springframework.data.domain.Page;

public record SearchResDto(
        Integer cnt,
        Page<ReviewerInfoResDto> reviewers,
        Integer page

) {
}
