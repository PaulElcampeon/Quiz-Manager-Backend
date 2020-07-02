package com.pauloladele.quizmanager.models.quiz;

import lombok.Data;

@Data
public class CreateQuizResponse {

    private boolean success;

    public CreateQuizResponse() {}

    public CreateQuizResponse(boolean success) {
        this.success = success;
    }
}
