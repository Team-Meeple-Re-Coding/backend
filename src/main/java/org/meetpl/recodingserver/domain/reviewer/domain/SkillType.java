package org.meetpl.recodingserver.domain.reviewer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SkillType {
    JAVA("자바");
    private final String stringSkill;
}
