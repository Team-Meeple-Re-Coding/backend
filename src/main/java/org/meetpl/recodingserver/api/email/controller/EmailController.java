package org.meetpl.recodingserver.api.email.controller;

import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.email.service.EmailService;
import org.meetpl.recodingserver.api.email.service.dto.req.EmailReqDto;
import org.meetpl.recodingserver.global.common.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/email")
public class EmailController {
    private final EmailService emailService;
    @PostMapping("/send")
    public ResponseEntity<SuccessResponse<?>> mailSend(@RequestBody EmailReqDto emailReqDto) {
        String number = emailService.sendMail(emailReqDto);
        return SuccessResponse.ok(number);
    }
}
