package org.meetpl.recodingserver.domain.reviewee.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.global.error.exception.InvalidValueException;

import java.util.Arrays;

import static org.meetpl.recodingserver.global.error.ErrorCode.INVALID_REVIEW_TYPE;

@RequiredArgsConstructor
@Getter
public enum ReviewType {
    KIND("친절해요");

    private final String stringReviewType;

    public static ReviewType getEnumReviewTypeFromStringReviewType(String stringReviewType) {
        return Arrays.stream(values())
                .filter(reviewType -> reviewType.stringReviewType.equals(stringReviewType))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_REVIEW_TYPE));
    }
}
