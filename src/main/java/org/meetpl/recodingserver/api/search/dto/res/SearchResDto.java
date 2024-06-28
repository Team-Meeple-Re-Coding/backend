package org.meetpl.recodingserver.api.search.dto.res;

import java.util.List;

public record SearchResDto(
        Integer cnt,
        List<ReviewerInfoResDto> reviewers,
        Integer page

) {
    public static SearchResDto of(Integer cnt, List<ReviewerInfoResDto> reviewers, Integer page){
        return new SearchResDto(cnt, reviewers, page);
    }
}
