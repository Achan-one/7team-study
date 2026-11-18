package com.kdt.lotto.entity;

import java.util.*;

public class Lotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int NUMBERLENGTH= 6;
    private static final int PRISE = 1000;
    private static final int MAXMONEY = 100_000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validNumber(numbers);
        //그대로 주면 주소가 연결됨. 복사해서 전달
        this.numbers = new ArrayList<>(numbers);
        orderByAscending();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static int getPrise() {
        return PRISE;
    }

    public static int getNumOfBeingAbleToBuy(int money){
        validMoney(money);
        return money/PRISE;
    }

    public static List<Integer> autoMakeNumber(){
        List<Integer> numbers = new ArrayList<>();
        for(int count=START; count<=END; count++) {
            numbers.add(count);
        }
        Collections.shuffle(numbers);
        return new ArrayList<>(numbers.subList(0, NUMBERLENGTH));
    }

    private void validNumber(List<Integer> numbers){
        isNotOutOfLength(numbers, NUMBERLENGTH);
        isNotOutOfRange(numbers);
        doNotHaveSameNumbers(numbers);
    }

    private static void validMoney(int money){
        if(money <= 0 || money % PRISE != 0 || money > MAXMONEY)
            throw new IllegalArgumentException();
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



    private void orderByAscending(){
        Collections.sort(this.numbers);
    }
}
