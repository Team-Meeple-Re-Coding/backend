package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillReader {
    private final SkillRepository skillRepository;
    public List<Skill> getSkillsByReviewerId(Long reviewerId){
        return skillRepository.findAllByReviewerId(reviewerId);
    }
}
