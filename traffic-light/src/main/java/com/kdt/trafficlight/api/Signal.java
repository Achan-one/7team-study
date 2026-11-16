package com.kdt.trafficlight.api;

public enum Signal {
    RED(30) {
        public Signal getNextSignal() {
            return GREEN;
        }
    },
    GREEN(25) {
        public Signal getNextSignal() {
            return YELLOW;
        }
    },
    YELLOW(5) {
        public Signal getNextSignal() {
            return RED;
        }
    },
    FLASHING_YELLOW(0) {
        public Signal getNextSignal() {
            return this;
        }
    };

    private final int second;

    Signal(int second) {
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public abstract Signal getNextSignal();
}
