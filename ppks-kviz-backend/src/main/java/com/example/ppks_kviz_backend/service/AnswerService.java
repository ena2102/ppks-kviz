package com.example.ppks_kviz_backend.service;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {

   /* @Autowired
    private ParticipantAnswerRepository answerRepository;
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    public boolean submitAnswer(Participant participant, Question question, Long answerOptionId) {
        if (answerRepository.findByParticipantAndQuestion(participant, question).isPresent()) return false;

        AnswerOption selectedOption = answerOptionRepository.findById(answerOptionId).orElseThrow();

        ParticipantAnswer answer = new ParticipantAnswer();
        answer.setParticipant(participant);
        answer.setQuestion(question);
       //answer.setAnswerOption(selectedOption);
        //answer.setSubmittedAt(LocalDateTime.now());

        answerRepository.save(answer);

        if (selectedOption.isCorrect()) {
            participant.setScore(participant.getScore() + 1);
            participantRepository.save(participant);
        }
        return true;
    }

    public Optional<ParticipantAnswer> getAnswer(Participant participant, Question question) {
        return answerRepository.findByParticipantAndQuestion(participant, question);
    }
    */
}

