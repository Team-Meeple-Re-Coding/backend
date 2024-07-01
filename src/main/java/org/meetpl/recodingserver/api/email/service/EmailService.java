package org.meetpl.recodingserver.api.email.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.meetpl.recodingserver.api.email.service.dto.req.EmailReqDto;
import org.meetpl.recodingserver.global.external.email.GmailClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final GmailClient gmailClient;

    public String sendMail(EmailReqDto emailReqDto) {
        int number = createNumber();
        MimeMessage message = gmailClient.CreateMail(emailReqDto.mail(), number);
        gmailClient.send(message);
        return String.valueOf(number);
    }

    private int createNumber() {
        return (int) (Math.random() * (90000)) + 100000;
    }
}
