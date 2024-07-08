package org.meetpl.recodingserver.domain.reviewer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.domain.reviewee.domain.ReviewType;
import org.meetpl.recodingserver.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_JOB_TYPE;
import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_REVIEW_TYPE;

@RequiredArgsConstructor
@Getter
public enum Job {
    FRONTEND("프론트"),
    BACKEND("백엔드");
    private final String stringJob;
    public static Job getEnumJobFromStringJob(String stringJob) {
        return Arrays.stream(values())
                .filter(job -> job.stringJob.equals(stringJob))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_JOB_TYPE));
    }
}
