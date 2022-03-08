package com.company;

public class SingleThread implements Runnable {

    @Override
    public void run() {
            try {
                while(!Thread.interrupted()) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}


