package org.meetpl.recodingserver.api.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.reviewer.dto.req.CreateReviewerReqDto;
import org.meetpl.recodingserver.api.reviewer.dto.req.UpdateReviewerReqDto;
import org.meetpl.recodingserver.api.reviewer.dto.res.ReviewerDetailResDto;
import org.meetpl.recodingserver.api.reviewer.mapper.ReviewerMapper;
import org.meetpl.recodingserver.domain.codereview.domain.CodeReview;
import org.meetpl.recodingserver.domain.member.domain.Member;
import org.meetpl.recodingserver.domain.member.service.MemberModifier;
import org.meetpl.recodingserver.domain.member.service.MemberReader;
import org.meetpl.recodingserver.domain.reviewer.domain.Job;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.meetpl.recodingserver.domain.reviewer.service.*;
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
    private final ReviewerModifier reviewerModifier;
    private final MemberReader memberReader;
    private final SkillReader skillReader;
    private final SkillModifier skillModifier;
    private final MemberModifier memberModifier;
    private final SkillAppender skillAppender;

    public ReviewerDetailResDto getReviewerDetail(Long reviewerId) {
        ReviewerDetailDto reviewerDetailDto = reviewerReader.findReviewerDetailById(reviewerId);
        List<SkillType> skills = convertSkillToSkillTypes(reviewerDetailDto.skills());
        Double reviewAvg = calculateReviewAvg(reviewerDetailDto.codeReviews());
        return reviewerMapper.toReviewerDetailResDto(reviewerDetailDto, skills, reviewAvg);
    }

    public void createReviewer(Long memberId, CreateReviewerReqDto createReviewerReqDto){
        Member member = memberReader.getMemberById(memberId);
        List<SkillType> skillTypes = createReviewerReqDto.skills().stream().map(SkillType::getEnumSkillTypeFromStringSkillType).toList();
        Reviewer reviewer = reviewerAppender.createReviewer(createReviewerReqDto.toReviewer(skillTypes, member));
        List<Skill> skills = skillTypes.stream().map(skillType -> Skill.createSkill(skillType,reviewer)).toList();
        skillAppender.saveSkill(skills);
    }

    public void updateReviewer(Long memberId, UpdateReviewerReqDto updateReviewerReqDto) {
        Member member = memberReader.getMemberById(memberId);
        memberModifier.updateName(member, updateReviewerReqDto.nickName());

        Reviewer reviewer = reviewerReader.getReviewerByMemberId(memberId);

        List<Skill> existingSkills = skillReader.getSkillsByReviewerId(reviewer.getId());

        List<SkillType> newSkillTypes = convertStringToSkillTypes(updateReviewerReqDto.skills());

        List<Skill> skillsToRemove = getSkillsToRemove(newSkillTypes, existingSkills);

        List<SkillType> skillTypesToAdd = getSkillTypesToAdd(newSkillTypes, existingSkills);

        Reviewer updateReviewer = updateReviewerReqDto.toReviewer(memberId, newSkillTypes,
                Job.getEnumJobFromStringJob(updateReviewerReqDto.job()), member);

        reviewerModifier.updateReviewer(updateReviewer);

        skillModifier.removeSkills(skillsToRemove);

        Reviewer finalReviewer = reviewer;

        List<Skill> skillsToAdd = getSkillsToAdd(skillTypesToAdd, finalReviewer);

        skillAppender.saveSkill(skillsToAdd);
    }
    private List<Skill> getSkillsToAdd(List<SkillType> skillTypesToAdd,  Reviewer finalReviewer){
        return skillTypesToAdd.stream()
                .map(skillType -> Skill.createSkill(skillType, finalReviewer))
                .toList();
    }
    private List<Skill> getSkillsToRemove(List<SkillType> newSkillTypes, List<Skill> existingSkills){
        return existingSkills.stream()
                .filter(skill -> !newSkillTypes.contains(skill.getSkillType()))
                .toList();
    }
    private List<SkillType> getSkillTypesToAdd(List<SkillType> newSkillTypes, List<Skill> existingSkills){
        return newSkillTypes.stream()
                .filter(skillType -> existingSkills.stream()
                        .noneMatch(skill -> skill.getSkillType() == skillType))
                .toList();
    }
    private List<SkillType> convertStringToSkillTypes(List<String> skills) {
        return skills.stream()
                .map(SkillType::getEnumSkillTypeFromStringSkillType)
                .collect(Collectors.toList());
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
