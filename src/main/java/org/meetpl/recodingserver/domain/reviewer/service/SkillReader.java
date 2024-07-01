package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.domain.SkillType;
import org.meetpl.recodingserver.domain.reviewer.repository.SkillRepository;
import org.meetpl.recodingserver.global.error.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.meetpl.recodingserver.global.error.ErrorCode.SKILL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SkillReader {
    private final SkillRepository skillRepository;
    public List<Skill> getSkillsByReviewerId(Long reviewerId){
        return skillRepository.findAllByReviewerId(reviewerId);
    }
    public Skill getSkillBySkillType(SkillType skillType){
        return skillRepository.findBySkillType(skillType).orElseThrow( () -> new EntityNotFoundException(SKILL_NOT_FOUND));
    }
}
