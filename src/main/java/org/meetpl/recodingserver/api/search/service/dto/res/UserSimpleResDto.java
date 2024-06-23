package org.meetpl.recodingserver.api.search.service.dto.res;

public record UserSimpleResDto(
        String name,
        String corporation,
        String job,
        String career
) {
}
