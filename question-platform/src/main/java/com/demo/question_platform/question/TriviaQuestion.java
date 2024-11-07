package com.demo.question_platform.question;

import com.demo.question_platform.answer.Answer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class TriviaQuestion extends Question {


    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Answer correctAnswer;


    // Getter and Setter for correctAnswer
    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
