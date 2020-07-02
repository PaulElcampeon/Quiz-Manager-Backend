package com.pauloladele.quizmanager.models.quiz;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "QUIZZES")
public class Quiz {

    @Id
    private String quizTitle;

    private List<QuizQuestion> questions;

}
