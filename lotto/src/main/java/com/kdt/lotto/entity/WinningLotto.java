package com.kdt.lotto.entity;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int BONUSLENGTH= 1;

    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.lotto = new Lotto(numbers);
        validBonus(bonus);
        this.bonus = bonus;
    }

    public Grade match(Lotto ticket){
        int count = 0;
        for(int num : ticket.getNumbers()){
            if(this.lotto.getNumbers().contains(num))
                count++;
        }
        boolean bonusMatch = ticket.getNumbers().contains(this.bonus);
        return Grade.of(count, bonusMatch);
    }

    private void validBonus(int bonus){
        List<Integer> checkBonus = List.of(bonus);
        isNotOutOfRange(checkBonus);
        isNotOutOfLength(checkBonus, BONUSLENGTH);
        doNotHaveSameNumbersWithBonus(checkBonus, this.lotto.getNumbers());
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

    private void doNotHaveSameNumbersWithBonus(List<Integer> bonus, List<Integer> numbers){
        if(numbers.contains(bonus.get(0)))
            throw new IllegalArgumentException();
    }

}
