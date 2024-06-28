package org.meetpl.recodingserver.api.review.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.review.dto.res.ReviewDetailResDto;
import org.meetpl.recodingserver.api.review.dto.res.ReviewsResDto;
import org.meetpl.recodingserver.api.review.mapper.ReviewMapper;
import org.meetpl.recodingserver.domain.review.domain.ReviewSkill;
import org.meetpl.recodingserver.domain.review.dto.ReviewDetailDto;
import org.meetpl.recodingserver.domain.review.service.ReviewReader;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.global.common.PageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewService {
    private final ReviewReader reviewReader;
    private final ReviewMapper reviewMapper;

    public ReviewsResDto getReviewsForReviewer(Long reviewerId, Pageable pageable) {
        Page<ReviewDetailDto> reviewDetailDtoList = reviewReader.findReviewDetailDtoListByReviewerId(reviewerId, pageable);
        PageInfo pageInfo = PageInfo.of(reviewDetailDtoList);
        List<ReviewDetailResDto> reviewDetailResDtoList = createReviewDtailResDtoList(reviewDetailDtoList.getContent());
        return reviewMapper.toReviewsResDto(reviewDetailResDtoList, pageInfo);
    }

    private List<ReviewDetailResDto> createReviewDtailResDtoList(List<ReviewDetailDto> reviewDetailDtoList) {
        return reviewDetailDtoList.stream()
                .map(reviewDetailDto ->
                        reviewMapper.toReviewDetailDto(
                                reviewDetailDto,
                                convertSkillToSkillTypes(reviewDetailDto.review().getSkills())
                        ))
                .collect(Collectors.toList());
    }

    private List<SkillType> convertSkillToSkillTypes(List<ReviewSkill> skills) {
        return skills.stream()
                .map(ReviewSkill::getSkillType)
                .collect(Collectors.toList());
    }
}
