package org.meetpl.recodingserver.domain.reviewer.repository;

import org.meetpl.recodingserver.domain.reviewer.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByReviewerId(Long reviewerId);
}
