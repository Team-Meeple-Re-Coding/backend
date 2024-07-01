package org.meetpl.recodingserver.api.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.reviewer.dto.req.CreateReviewerReqDto;
import org.meetpl.recodingserver.api.reviewer.dto.res.ReviewerDetailResDto;
import org.meetpl.recodingserver.api.reviewer.mapper.ReviewerMapper;
import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.member.service.MemberReader;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.meetpl.recodingserver.domain.reviewer.service.ReviewerAppender;
import org.meetpl.recodingserver.domain.reviewer.service.ReviewerReader;
import org.meetpl.recodingserver.domain.reviewer.service.SkillReader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewerService {
    private final ReviewerReader reviewerReader;
    private final ReviewerMapper reviewerMapper;
    private final ReviewerAppender reviewerAppender;
    private final MemberReader memberReader;
    private final SkillReader skillReader;

    public ReviewerDetailResDto getReviewerDetail(Long reviewerId) {
        ReviewerDetailDto reviewerDetailDto = reviewerReader.findReviewerDetailById(reviewerId);
        List<SkillType> skills = convertSkillToSkillTypes(reviewerDetailDto.skills());
        Double reviewAvg = calculateReviewAvg(reviewerDetailDto.codeReviews());
        return reviewerMapper.toReviewerDetailResDto(reviewerDetailDto, skills, reviewAvg);
    }

    public void createReviewer(Long memberId, CreateReviewerReqDto createReviewerReqDto){
        Member member = memberReader.getMemberById(memberId);
        List<Skill> skills = createReviewerReqDto.skills().stream().map(
                skill -> skillReader.getSkillsBySkillType()
        ).toList();
        reviewerAppender.createReviewer(createReviewerReqDto.toReviewer(skills, member));
    }

    private List<SkillType> convertSkillToSkillTypes(List<Skill> skills) {
        return skills.stream()
                .map(Skill::getSkillType)
                .collect(Collectors.toList());
    }

    private Double calculateReviewAvg(List<CodeReview> codeReviews) {
        return codeReviews.stream()
                .mapToDouble(codeReview -> codeReview.getReviewee().getReview().getRating())
                .average()
                .orElse(0.0);
    }
}
