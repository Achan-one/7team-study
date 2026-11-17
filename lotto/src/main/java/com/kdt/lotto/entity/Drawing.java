package com.kdt.lotto.entity;

import java.util.List;

public class Drawing {

    private Lotto myNumber;
    private Lotto winningNumber;
    private int bonus;

    public List<Integer> ticket(List<Integer> numbers){
        this.myNumber = new Lotto(numbers);
        return myNumber.getNumber();
    }

    public void winning(List<Integer> numbers, int bonus){
        this.winningNumber = new Lotto(numbers, bonus);
        this.bonus = bonus;
    }

}
