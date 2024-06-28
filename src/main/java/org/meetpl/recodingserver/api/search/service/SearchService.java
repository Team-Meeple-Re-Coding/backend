package org.meetpl.recodingserver.api.search.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.dto.req.SearchReqDto;
import org.meetpl.recodingserver.api.search.dto.res.MemberSimpleResDto;
import org.meetpl.recodingserver.api.search.dto.res.ReviewerInfoResDto;
import org.meetpl.recodingserver.api.search.dto.res.SearchResDto;
import org.meetpl.recodingserver.domain.member.service.MemberReader;
import org.meetpl.recodingserver.domain.review.service.ReviewReader;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.service.CareerReader;
import org.meetpl.recodingserver.domain.reviewer.service.ReviewerReader;
import org.meetpl.recodingserver.domain.reviewer.service.SkillReader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ReviewerReader reviewerReader;
    private final ReviewReader reviewReader;
    private final MemberReader memberReader;
    private final SkillReader skillReader;
    private final CareerReader careerReader;

    public SearchResDto searchReviewers(Pageable pageable, SearchReqDto searchReqDto){
        Page<Reviewer> reviewers = reviewerReader.getReviewerBySearchReqDto(pageable, searchReqDto);
        List<ReviewerInfoResDto> reviewerInfoResDtos = createReviewerInfoResDtoList(reviewers.getContent());
        return SearchResDto.of(reviewers.getTotalPages(), reviewerInfoResDtos, reviewers.getNumberOfElements());
    }
    private List<ReviewerInfoResDto> createReviewerInfoResDtoList(List<Reviewer> reviewers){
        return reviewers.stream().map(
                reviewer -> ReviewerInfoResDto.of(
                        MemberSimpleResDto.of(
                                memberReader.getMemberById(reviewer.getMember().getId()),
                                reviewer,
                                careerReader.getCareerByReviewerId(reviewer.getId())
                        ),
                        reviewer,
                        skillReader.getSkillsByReviewerId(reviewer.getId()),
                        reviewReader.findReviewCountByReviewerId(reviewer.getId())
                )
        ).collect(Collectors.toList());
    }
}
