package org.meetpl.recodingserver.api.user.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.user.service.AuthService;
import org.meetpl.recodingserver.api.user.service.dto.res.MemberAuthResDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @GetMapping("/{code}")
    ResponseEntity<SuccessResponse<?>> singIn(@PathVariable(name = "code")String code){
        MemberAuthResDto memberAuthResDto = authService.signIn(code);
        return SuccessResponse.ok(memberAuthResDto);
    }
}
