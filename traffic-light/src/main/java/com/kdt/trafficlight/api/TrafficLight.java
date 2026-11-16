package com.kdt.trafficlight.api;

public class TrafficLight {

    ///상태
    Signal signal = Signal.RED;;
    int time = Signal.RED.getSecond();
    String butten;

    ///행동
    //출력, 변동, 저장, 검증
    public String signal(){
        return this.signal.name();
    }

    public void moveNext(){
        Signal nextSignal = this.signal.getNextSignal();
        saveSinal(nextSignal);
        saveTime();
    }

    public void saveSinal(Signal nextSignal){
        vaild();
        this.signal = nextSignal;
    }

    public void saveTime(){
        vaild();
        this.time = this.signal.getSecond();
    }

    public void vaild(){
    }



//    public void restart(){
//        this.signal = Signal.RED;
//        this.time = Signal.RED.getSecond();
//    }

    ///룰
//    private void timeIsUp(int passTime){
//        int time = this.time-passTime;
//        if(time<=0)
//    }

}
