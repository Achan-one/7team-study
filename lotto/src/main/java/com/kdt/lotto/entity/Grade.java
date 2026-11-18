package com.kdt.lotto.entity;

public enum Grade {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    private final int prize;

    Grade(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Grade of(int count, boolean bonusMatch) {
        return switch (count) {
            case 6 -> FIRST;
            case 5 -> bonusMatch ? SECOND : THIRD;
            case 4 -> FOURTH;
            case 3 -> FIFTH;
            default -> NONE;
        };
    }
}
