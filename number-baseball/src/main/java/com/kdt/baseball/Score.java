package com.kdt.baseball;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString(){
        List<String> scoreList = new ArrayList<>();

        if(strike > 0){
            scoreList.add(strike + "스트라이크");
        }
        if(ball > 0){
            scoreList.add(ball + "볼");
        }

        if(scoreList.isEmpty()){
            return "낫싱";
        }

        return String.join(" ", scoreList);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}