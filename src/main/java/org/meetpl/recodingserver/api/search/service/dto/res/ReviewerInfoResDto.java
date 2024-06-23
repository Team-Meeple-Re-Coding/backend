package org.meetpl.recodingserver.api.search.service.dto.res;

import java.util.List;

public record ReviewerInfoResDto(
        UserSimpleResDto user,
        String description,
        String job,
        List<String> stacks,
        Integer codeReviewCnt,
        Integer reviewCnt
) {
}
