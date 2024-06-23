package org.meetpl.recodingserver.api.search.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.service.SearchService;
import org.meetpl.recodingserver.api.search.service.dto.req.SearchReqDto;
import org.meetpl.recodingserver.api.search.service.dto.res.SearchResDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    private SearchService searchService;
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> searchReviewer(@RequestBody SearchReqDto searchReqDto){
        SearchResDto searchResDto = searchService.searchReviewers(searchReqDto);
        return SuccessResponse.ok(searchResDto);
    }
}
