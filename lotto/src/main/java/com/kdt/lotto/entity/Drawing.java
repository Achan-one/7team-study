package com.kdt.lotto.entity;

import java.util.List;

public class Drawing {

    public List<Integer> ticket(List<Integer> numbers){
        Lotto lotto = new Lotto(numbers);
        return lotto.getNumber();
    }

}
