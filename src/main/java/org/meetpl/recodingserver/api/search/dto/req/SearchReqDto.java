package org.meetpl.recodingserver.api.search.dto.req;

public record SearchReqDto(
        String corporation,
        String job,
        String career,
        String skill

) {
}
