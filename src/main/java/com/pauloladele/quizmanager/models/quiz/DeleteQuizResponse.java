package com.pauloladele.quizmanager.models.quiz;

import lombok.Data;

@Data
public class DeleteQuizResponse {

    private boolean success;

    public DeleteQuizResponse(){}

    public DeleteQuizResponse(boolean success) {
        this.success = success;
    }
}
