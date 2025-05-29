package com.example.ppks_kviz_backend.controller;

import com.example.ppks_kviz_backend.model.*;
import com.example.ppks_kviz_backend.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @PostMapping("/join")
    public ParticipantDTO joinQuiz(@RequestBody ParticipantJoinRequest request) {
        return participantService.joinQuiz(request.getName(), request.getSessionPin());
    }

    @GetMapping("get/{participantId}")
    public ParticipantDTO getParticipant(@PathVariable("participantId") String participantId) {
        return participantService.getParticipantById(participantId);
    }

    @PostMapping("/save-answer")
    public void saveAnswer(@RequestBody AnswerDTO answerDTO) {
        participantService.saveAnswer(answerDTO);
    }

    @GetMapping("/scores/{quizPin}")
    public List<ParticipantDTO> getScores(@PathVariable("quizPin") int quizPin) {
        return participantService.getScores(quizPin);
    }
}
