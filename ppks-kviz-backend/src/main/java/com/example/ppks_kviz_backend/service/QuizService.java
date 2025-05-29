package com.example.ppks_kviz_backend.service;

import com.example.ppks_kviz_backend.model.Question;
import com.example.ppks_kviz_backend.model.QuestionDTO;
import com.example.ppks_kviz_backend.model.Quiz;
import com.example.ppks_kviz_backend.repository.QuestionRepository;
import com.example.ppks_kviz_backend.repository.QuizRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Quiz createQuiz(String title, int pin, List<QuestionDTO> questionDTOs) {
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setPin(pin);
        quiz.setActive(false);
        Quiz savedQuiz = quizRepository.save(quiz);

        int index = 1;

        for (QuestionDTO dto : questionDTOs) {
            Question question = new Question();
            question.setQuestionText(dto.getQuestionText());
            question.setOptionA(dto.getOptionA());
            question.setOptionB(dto.getOptionB());
            question.setOptionC(dto.getOptionC());
            question.setOptionD(dto.getOptionD());
            question.setCorrectOption(dto.getCorrectOption());
            question.setQuiz(savedQuiz);
            question.setIndex(index);

            questionRepository.save(question);
            index++;
        }

        return savedQuiz;
    }

    @Transactional
    public void startQuiz(int pin) {
        Quiz quiz = quizRepository.findByPin(pin);
        quiz.setActive(true);
        quizRepository.save(quiz);

        List<Question> questions = questionRepository.findByQuiz(quiz);

        for (int i = 0; i < questions.size(); i++) {
            final int questionIndex = i; // FIX: mora biti final ili effectively final
            scheduler.schedule(() -> {
                Question q = questions.get(questionIndex);

                QuestionDTO dto = new QuestionDTO();
                dto.setQuestionIndex(questionIndex);
                dto.setQuestionText(q.getQuestionText());
                dto.setOptionA(q.getOptionA());
                dto.setOptionB(q.getOptionB());
                dto.setOptionC(q.getOptionC());
                dto.setOptionD(q.getOptionD());

                messagingTemplate.convertAndSend("/topic/quiz/" + pin, dto);
            }, questionIndex * 20L, TimeUnit.SECONDS); // 20 sekundi razmaka
        }

        // Zakazano deaktiviranje kviza i slanje "quiz-ended" kao JSON
        long delay = questions.size() * 20L;
        scheduler.schedule(() -> {
            quiz.setActive(false);
            quizRepository.save(quiz);

            Map<String, String> endSignal = new HashMap<>();
            endSignal.put("type", "FINISHED");

            messagingTemplate.convertAndSend("/topic/quiz/" + pin, endSignal);
        }, delay, TimeUnit.SECONDS);
    }




    public Quiz findByPin(int pin) {
        return quizRepository.findByPin(pin);
    }


}

