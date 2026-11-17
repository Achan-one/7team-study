package com.kdt.lotto.entity;

import java.util.*;

public class Lotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int NUMBERLENGTH= 6;
    private static final int BONUSLENGTH= 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validNumber(numbers);
        //그대로 주면 주소가 연결됨. 복사해서 전달
        this.numbers = new ArrayList<>(numbers);
        orderByAscending();
    }

    public Lotto(List<Integer> numbers, int bonus){
        validNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
        validBonus(bonus);
        orderByAscending();
    }

    public List<Integer> getNumber() {
        return this.numbers;
    }

    private void validNumber(List<Integer> numbers){
        isNotOutOfLength(numbers, NUMBERLENGTH);
        isNotOutOfRange(numbers);
        doNotHaveSameNumbers(numbers);
    }

    private void validBonus(int bonus){
        List<Integer> checkBonus = List.of(bonus);
        isNotOutOfRange(checkBonus);
        isNotOutOfLength(checkBonus, BONUSLENGTH);
        doNotHaveSameNumbersWithBonus(checkBonus, this.numbers);
    }

    private void isNotOutOfRange(List<Integer> numbers){
        for(int num : numbers){
            if(num<START || num>END)
                throw new IllegalArgumentException();
        }
    }

    private void isNotOutOfLength(List<Integer> numbers, int length){
        if(numbers.size() != length)
            throw new IllegalArgumentException();
    }

    private void doNotHaveSameNumbers(List<Integer> numbers){
        if(new HashSet<>(numbers).size() != NUMBERLENGTH)
            throw new IllegalArgumentException();
    }

    private void doNotHaveSameNumbersWithBonus(List<Integer> bonus, List<Integer> numbers){
        if(numbers.contains(bonus.get(0)))
            throw new IllegalArgumentException();
    }

    private void orderByAscending(){
        Collections.sort(this.numbers);
    }
}
