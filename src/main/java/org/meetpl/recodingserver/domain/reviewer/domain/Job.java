package org.meetpl.recodingserver.domain.reviewer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Job {
    FRONTEND("프론트");
    private final String stringJob;
}
