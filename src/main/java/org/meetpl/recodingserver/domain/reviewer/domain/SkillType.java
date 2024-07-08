package org.meetpl.recodingserver.domain.reviewer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.member.domain.Platform;
import org.meetpl.recodingserver.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_PLATFORM_TYPE;
import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_SKILL_TYPE;

@RequiredArgsConstructor
@Getter
public enum SkillType {
    JAVA("자바");
    private final String stringSkill;

    public static SkillType getEnumSkillTypeFromStringSkillType(String stringSkillType) {
        return Arrays.stream(values())
                .filter(skillType -> skillType.stringSkill.equals(stringSkillType))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_SKILL_TYPE));
    }
}
