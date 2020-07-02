package com.pauloladele.quizmanager.models.quiz;

import lombok.Data;

@Data
public class UpdateQuizResponse {

    private boolean success;

    public UpdateQuizResponse(){}

    public UpdateQuizResponse(boolean success) {
        this.success = success;
    }
}
