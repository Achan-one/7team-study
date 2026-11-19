package com.kdt.baseball;

import java.util.ArrayList;
import java.util.List;

public class Score {
    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        validateNotNegative(strike,ball);
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

    private static void validateNotNegative(int strike, int ball){
        if(strike < 0 || ball < 0){
            throw new IllegalArgumentException("스트라이크와 볼은 0 이상이어야 합니다.");
        }
    }

    private static void validateTotal(int strike, int ball){
        if(strike+ball > GameRule.SIZE){
            throw new IllegalArgumentException("스트라이크와 볼의 합은 자릿수보다 작아야 합니다.");
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}