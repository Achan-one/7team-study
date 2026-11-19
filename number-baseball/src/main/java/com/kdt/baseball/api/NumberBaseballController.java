package com.kdt.baseball.api;

import com.kdt.baseball.AnswerGenerator;
import com.kdt.baseball.BallNumber;
import com.kdt.baseball.Game;
import com.kdt.baseball.RandomAnswerGenerator;

public class NumberBaseballController implements NumberBaseballApi {

    private final AnswerGenerator answerGenerator = new RandomAnswerGenerator();
    private Game game;

    @Override
    public void start(String answer) {
        this.game = new Game(BallNumber.of(answer));
    }

    @Override
    public String guess(String number) {
        return game.guess(BallNumber.of(number)).toString();
    }

    @Override
    public int attempts() {
        return game.getAttempts();
    }

    @Override
    public String status() {
        return game.status().name();
    }

    @Override
    public String randomAnswer() {
        return answerGenerator.generate().toString();
    }
}