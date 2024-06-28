package org.meetpl.recodingserver.api.search.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.search.service.SearchService;
import org.meetpl.recodingserver.api.search.dto.req.SearchReqDto;
import org.meetpl.recodingserver.api.search.dto.res.SearchResDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {
    private SearchService searchService;
    @PostMapping
    public ResponseEntity<SuccessResponse<?>> searchReviewer(@RequestParam(value = "page", defaultValue = "0") int page, @RequestBody SearchReqDto searchReqDto){
        SearchResDto searchResDto = searchService.searchReviewers(PageRequest.of(page, 9) ,searchReqDto);
        return SuccessResponse.ok(searchResDto);
    }
}
