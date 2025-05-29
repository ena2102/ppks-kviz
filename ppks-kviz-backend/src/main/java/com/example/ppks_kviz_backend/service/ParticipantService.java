package com.example.ppks_kviz_backend.service;

import com.example.ppks_kviz_backend.model.*;
import com.example.ppks_kviz_backend.repository.AnswerRepository;
import com.example.ppks_kviz_backend.repository.ParticipantRepository;
import com.example.ppks_kviz_backend.repository.QuestionRepository;
import com.example.ppks_kviz_backend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionService questionService;

    public ParticipantDTO joinQuiz(String name, int sessionPin) {
        Quiz quiz = quizRepository.findByPin(sessionPin);

        Participant participant = new Participant();
        participant.setName(name);
        participant.setQuiz(quiz);

        Participant savedParticipant = participantRepository.save(participant);

        return new ParticipantDTO(savedParticipant.getParticipantId(), savedParticipant.getName(), savedParticipant.getQuiz().getPin());
    }

    public void saveAnswer(AnswerDTO answerDTO) {
        Participant participant = participantRepository.findById(answerDTO.getParticipantId())
                .orElseThrow(() -> new RuntimeException("Sudionik s ID-om " + answerDTO.getParticipantId() + " ne postoji."));

        Question question = questionService.getByQuizAndQuestionIndex(answerDTO.getQuizPin(), (answerDTO.getQuestionIndex() + 1));

        boolean isCorrect = question.getCorrectOption().equalsIgnoreCase(answerDTO.getSelectedOption());
        if (isCorrect) {
            participant.setScore(participant.getScore() + 1);
            participantRepository.save(participant);
        }

        Answer answer = new Answer();
        answer.setParticipant(participant);
        answer.setQuestion(question);
        answer.setSelectedOption(answerDTO.getSelectedOption());
        answer.setSubmittedAt(answerDTO.getSubmittedAt());
        answer.setCorrect(isCorrect);
        answerRepository.save(answer);
    }

    public ParticipantDTO getParticipantById(@PathVariable("participantId") String participantId) {
        long id = Long.parseLong(participantId);
        Participant participant = participantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sudionik s ID-om " + id + " ne postoji."));

        return new ParticipantDTO(participant.getParticipantId(), participant.getName(), participant.getQuiz().getPin());
    }

    public List<ParticipantDTO> getScores(int quizPin) {
        Quiz quiz = quizRepository.findByPin(quizPin);
        List<Participant> participants = participantRepository.findByQuiz(quiz);

        return participants.stream()
                .map(participant -> new ParticipantDTO(participant.getParticipantId(), participant.getName(), participant.getQuiz().getPin(), participant.getScore()))
                .toList();
    }
}
