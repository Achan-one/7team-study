package com.kdt.lotto.entity;

import java.util.*;

public class Lotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int LENGTH= 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        isNotOutOfLength(numbers);
        isNotOutOfRange(numbers);
        doNotHaveSameNumbers(numbers);

        //그대로 주면 주소가 연결됨. 복사해서 전달
        this.numbers = new ArrayList<>(numbers);
        orderByAscending();
    }

    public List<Integer> getNumber() {
        return this.numbers;
    }

    private void isNotOutOfRange(List<Integer> numbers){
        for(int num : numbers){
            if(num<START || num>END)
                throw new IllegalArgumentException();
        }
    }

    private void isNotOutOfLength(List<Integer> numbers){
        if(numbers.size() != LENGTH)
            throw new IllegalArgumentException();
    }

    private void doNotHaveSameNumbers(List<Integer> numbers){
        if(new HashSet<>(numbers).size() != LENGTH)
            throw new IllegalArgumentException();
    }

    private void orderByAscending(){
        Collections.sort(this.numbers);
    }
}
