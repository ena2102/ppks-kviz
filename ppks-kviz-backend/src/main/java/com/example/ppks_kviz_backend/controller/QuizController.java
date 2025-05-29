package com.example.ppks_kviz_backend.controller;

import com.example.ppks_kviz_backend.model.CreateQuizDTO;
import com.example.ppks_kviz_backend.model.Quiz;
import com.example.ppks_kviz_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody CreateQuizDTO createQuizDTO) {
        return quizService.createQuiz(createQuizDTO.getTitle(), createQuizDTO.getPin(), createQuizDTO.getQuestions());
    }
}
