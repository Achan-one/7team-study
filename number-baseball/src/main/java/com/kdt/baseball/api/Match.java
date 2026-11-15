package com.kdt.baseball.api;

import java.util.ArrayList;
import java.util.List;

public class Match {

    ///상태
    int NumberLength = 3;

    ///행동
    public void CheckNumber(String answer){
        isThreeLetters(answer);
        isNotIncludingZero(answer);
        isNotIncludingSameNumber(answer);
        isOnlyHavingNumbers(answer);
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
