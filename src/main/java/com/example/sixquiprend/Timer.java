package com.example.sixquiprend;

public class Timer {
    public void getTime(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
