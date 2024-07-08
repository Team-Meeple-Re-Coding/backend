package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.repository.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillModifier {
    private final SkillRepository skillRepository;

    @Transactional
    public void removeSkills(List<Skill> skillsToRemove) {
        if (skillsToRemove == null || skillsToRemove.isEmpty()) {
            return;
        }

        List<Long> skillIdsToRemove = skillsToRemove.stream()
                .map(Skill::getId)
                .toList();

        skillRepository.deleteAllById(skillIdsToRemove);
    }
}
