package com.example.ppks_kviz_backend.service;

import com.example.ppks_kviz_backend.model.Question;
import com.example.ppks_kviz_backend.model.Quiz;
import com.example.ppks_kviz_backend.repository.QuestionRepository;
import com.example.ppks_kviz_backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Question getByQuizAndQuestionIndex(int quizPin, int questionIndex) {

        Quiz quiz = quizRepository.findByPin(quizPin);
        List<Question> questions = questionRepository.findByQuiz(quiz);
        Question rightQuestion = new Question();

        for (Question question : questions) {
            if (question.getIndex() == questionIndex) {
                rightQuestion = question;
            }
        }

        return rightQuestion;
    }
}
