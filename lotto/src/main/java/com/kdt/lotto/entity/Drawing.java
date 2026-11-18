package com.kdt.lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

    private Lotto lotto;
    private WinningLotto winningNumber;

    public List<Integer> ticket(List<Integer> numbers){
        this.lotto = new Lotto(numbers);
        return lotto.getNumbers();
    }

    public void winning(List<Integer> numbers, int bonus){
        this.winningNumber = new WinningLotto(numbers, bonus);
    }

    public String rank(List<Integer> numbers){
        return judge(numbers).name();
    }

    public long getPrize(List<Integer> numbers){
        return judge(numbers).getPrize();
    }

    public List<List<Integer>> buyAuto(int money){
        List<List<Integer>> tickets = new ArrayList<>();
        int count = Lotto.getNumOfBeingAbleToBuy(money);
        for(int i=0; i<count; i++){
            Lotto newLotto = new Lotto(Lotto.autoMakeNumber());
            tickets.add(newLotto.getNumbers());
        }
        return tickets;
    }

    public double profitRate(List<List<Integer>> tickets){
        long totalPrize = 0;
        long purchasePrice = (long) tickets.size() * Lotto.getPrise();
        for(List<Integer> ticket : tickets){
            totalPrize += judge(ticket).getPrize();
        }
        return  Math.round(totalPrize * 1000.0 / purchasePrice) / 10.0;
    }

    //Grade를 돌려줌.
    //등수 이름, 상품을 알 수 있음
    private Grade judge(List<Integer> numbers){
        Lotto ticket = new Lotto(numbers);
        return winningNumber.match(ticket);
    }

}
