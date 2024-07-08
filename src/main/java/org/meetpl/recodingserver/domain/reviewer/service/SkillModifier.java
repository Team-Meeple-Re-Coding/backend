package org.meetpl.recodingserver.domain.reviewer.service;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewer.domain.Reviewer;
import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.meetpl.recodingserver.domain.reviewer.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillModifier {
    public void addReviewer(List<Skill> skills, Reviewer reviewer){
        for(Skill skill : skills){
            skill.addReviewer(reviewer);
        }
    }
}
