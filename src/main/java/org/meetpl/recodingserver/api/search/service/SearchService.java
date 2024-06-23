package org.meetpl.recodingserver.api.search.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.service.dto.req.SearchReqDto;
import org.meetpl.recodingserver.api.search.service.dto.res.ReviewerInfoResDto;
import org.meetpl.recodingserver.api.search.service.dto.res.SearchResDto;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ReviewerReader reviewerReader;
    private final MemberReader memberReader;
    private final SkillReader skillReader;

    public SearchResDto searchReviewers(SearchReqDto searchReqDto){
        List<Reviewer> reviewers = reviewerReader.getReviewerBySearchReqDto(searchReqDto);
        List<ReviewerInfoResDto> reviewerInfoResDtos = createReviewerInfoResDtoList(reviewers);

    }
    private List<ReviewerInfoResDto> createReviewerInfoResDtoList(List<Reviewer> reviewers){
        return reviewers.stream().map(
                reviewer -> ReviewerInfoResDto.of(
                        memberReader.getMemberById(reviewer.getMember().getId()),
                        reviewer,
                        skillReader.getSkillsByReviewerId(reviewer.getId())
                )
        ).toList();
    }
}
