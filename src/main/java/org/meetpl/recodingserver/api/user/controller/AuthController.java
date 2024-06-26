package org.meetpl.recodingserver.api.user.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.user.service.AuthService;
import org.meetpl.recodingserver.api.user.service.dto.res.MemberAuthResDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @GetMapping
    ResponseEntity<SuccessResponse<?>> singIn(@RequestParam(name = "code") String code) throws JsonProcessingException {
        MemberAuthResDto memberAuthResDto = authService.signIn(code);
        return SuccessResponse.ok(memberAuthResDto);
    }
}
