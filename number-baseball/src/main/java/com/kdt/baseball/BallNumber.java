package com.kdt.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallNumber {
    private static final int SIZE = 3;
    private final List<Integer> numbers;

    public BallNumber(List<Integer> numbers) {
        validateNotNull(numbers);
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicate(numbers);

        this.numbers = List.copyOf(numbers);
    }

    public static BallNumber of(String value){
        validateNotNull(value);

        if (!value.matches("^[0-9]+$")){
            throw new IllegalArgumentException("숫자가 아닌 글자가 포함되어서는 안됩니다.");
        }

        List<Integer> list = new ArrayList<>();
        for(char c : value.toCharArray()){
            list.add(c-'0');
        }

        return new BallNumber(list);
    }

    private static void validateSize(List<Integer> numbers){
        if(numbers.size()!= SIZE){
            throw new IllegalArgumentException("숫자의 개수는 " + SIZE + "개입니다.");
        }
    }

    private static void validateRange(List<Integer> numbers){
        for(int number : numbers){
            if(number < 1 || number > 9){
                throw new IllegalArgumentException("숫자는 1-9사이의 정수입니다.");
            }
        }
    }

    private static void validateNoDuplicate(List<Integer> numbers){
        Set<Integer> set = new HashSet<>();

        for(int number : numbers){
            set.add(number);
        }

        if(set.size() < numbers.size()){
            throw new IllegalArgumentException("숫자는 중복되어서는 안됩니다.");
        }
    }

    private static void validateNotNull(Object value){
        if(value==null){
            throw new IllegalArgumentException("숫자는 null일 수 없습니다.");
        }
    }
}