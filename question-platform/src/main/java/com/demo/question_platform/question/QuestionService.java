package com.demo.question_platform.question;

import com.demo.question_platform.Exception.NotFoundException;
import com.demo.question_platform.answer.Answer;
import com.demo.question_platform.answer.AnswerRepository;
import com.demo.question_platform.vote.VoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Long insertQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);
        return savedQuestion.getId();
    }

    public Optional<Question> getQuestion(Long id) {
        return questionRepository.findById(id);
    }

    public VoteResponse vote(Long questionId, Long answerId) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new NotFoundException("Question not found"));

        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new NotFoundException("Answer not found"));

        answer.setVotes(answer.getVotes() + 1);
        answerRepository.save(answer);

        boolean isCorrect = false;
        if (question instanceof TriviaQuestion) {
            isCorrect = ((TriviaQuestion) question).getCorrectAnswer().getId().equals(answerId);
        }

        return new VoteResponse(answer.getVotes(), isCorrect);
    }
}

