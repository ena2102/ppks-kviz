package com.example.ppks_kviz_backend.websocket;

import com.example.ppks_kviz_backend.model.*;
import com.example.ppks_kviz_backend.service.ParticipantService;
import com.example.ppks_kviz_backend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {

    @Autowired
    private QuizService quizService;

    @MessageMapping("/start-quiz")
    @SendTo("/topic/quiz-started")
    public QuizStartedMessage startQuiz(QuizStartedMessage message) {
        quizService.startQuiz(message.getPin());
        return new QuizStartedMessage(message.getPin());
    }


}
