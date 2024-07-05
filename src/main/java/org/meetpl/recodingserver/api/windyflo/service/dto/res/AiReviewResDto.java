package org.meetpl.recodingserver.api.windyflo.service.dto.res;

public record AiReviewResDto(
        String style,
        String code
) {
    public static AiReviewResDto of(String style, String code) {
        return new AiReviewResDto(style, code);
    }
}
