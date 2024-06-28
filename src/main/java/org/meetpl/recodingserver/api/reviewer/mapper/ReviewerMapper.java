package org.meetpl.recodingserver.api.reviewer.mapper;

import org.meetpl.recodingserver.api.reviewer.dto.res.ReviewerDetailResDto;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.domain.reviewer.dto.ReviewerDetailDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewerMapper {
    public ReviewerDetailResDto toReviewerDetailResDto(ReviewerDetailDto reviewerDetailDto,
                                                       List<SkillType> skills,
                                                       Double reviewAvg) {
        return ReviewerDetailResDto.of(reviewerDetailDto, skills, reviewAvg);
    }
}
