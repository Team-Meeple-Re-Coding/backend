package org.meetpl.recodingserver.global.external.windyflo;

import lombok.Getter;

@Getter
public class QuestionRequest {
    private String question;

    public QuestionRequest(String question) {
        this.question = question;
    }

    // getter and setter
}
