package com.kdt.baseball.api;

import java.util.ArrayList;
import java.util.List;

public class Match {

    ///상태
    int NumberLength = 3;
    String answer;

    ///행동
    public void start(String  answer){
        validNumber(answer);
        this.answer = answer;
    }

    public void validNumber(String answer){
        isThreeLetters(answer);
        isNotIncludingZero(answer);
        isNotIncludingSameNumber(answer);
        isOnlyHavingNumbers(answer);
    }

    public String guess(String number){
        validNumber(number);
        List<Character> answerList = ReturntoList(answer);
        List<Character> numberList = ReturntoList(number);
        StringBuilder result = new StringBuilder();
        int strike = 0;
        int ball = 0;

        for(int index=0; index<NumberLength; index++){
            char currentNum = answerList.get(index);
            //값 존재 + 위치 일치 = 스트라이크
            if(currentNum == numberList.get(index))
                strike++;
            //값 존재 + 위치 불일치 = 볼
            else if (numberList.contains(currentNum)) {
                ball++;
            }
        }

        if(strike!=0 && ball!=0){
            result.append(strike);
            result.append(Call.STRIKE.label());
            result.append(" ");
            result.append(ball);
            result.append(Call.BALL.label());
        } else if (strike!=0) {
            result.append(strike);
            result.append(Call.STRIKE.label());
        } else if (ball!=0) {
            result.append(ball);
            result.append(Call.BALL.label());
        }
        else {
            result.append(Call.NOTHING.label());
        }

        return result.toString();
    }

    ///룰
    private void isThreeLetters(String answer){
        if(answer.length()!=NumberLength)
            throw new IllegalArgumentException();
    }

    private void isNotIncludingZero(String answer){
        List<Character> list = ReturntoList(answer);
        if(list.contains('0'))
            throw new IllegalArgumentException();
    }

    private void isNotIncludingSameNumber(String answer){
        List<Character> list = ReturntoList(answer);
        long length = list.stream().distinct().count();
        if (length!=NumberLength)
            throw new IllegalArgumentException();
    }

    private void isOnlyHavingNumbers(String answer){
        List<Character> list = ReturntoList(answer);
        for(char c : list){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException();
        }
    }

    ///추가 매서드
    //answer를 한 자리 수 단위로 쪼개어 list로 반환
    private List<Character> ReturntoList(String answer){
        List<Character> list = new ArrayList<>();
        for(char c : answer.toCharArray())
            list.add(c);
        return list;
    }
}
