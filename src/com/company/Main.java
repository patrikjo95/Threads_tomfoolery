package com.company;

public class Main {

    public static void main(String[] args) {

        /*new Thread(new SingleThread()).start();

        Runnable runnable = new SingleThread("Bill är sämst");
        Thread th = new Thread(runnable);
        th.start();


        new Thread((()->{
            for(int i = 0; i < 10; i++){
                System.out.println("Bill är lagom");
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        })).start();

        try {
            th.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(0);*/

        UI ui = new UI();


    }
}
