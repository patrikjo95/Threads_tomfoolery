package com.company;


import javax.swing.*;
import java.util.Random;

public class UI {

    JFrame frame;
    Random rand = new Random();
    int intRand;
    Timer timer;
    int time;


    public UI() {
        this.frame = new JFrame();
        JButton randomizeButton = new JButton("Randomize");
        JButton enterButton = new JButton("Enter");
        JTextField field = new JTextField();
        JLabel label = new JLabel("0");

        field.setBounds(100, 100, 200, 50);
        randomizeButton.setBounds(100, 150, 100, 50);
        enterButton.setBounds(200, 150, 100, 50);
        label.setBounds(50, 50, 25, 25);

        frame.add(randomizeButton);
        frame.add(enterButton);
        frame.add(field);
        frame.add(label);


        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        randomizeButton.addActionListener(e -> {
            time = 0;
            new Thread(() -> {
                intRand = rand.nextInt(25);
                System.out.println(intRand);
                randomizeButton.setEnabled(false);
                timer = new Timer(1000, e1 -> {
                    label.setText(String.valueOf(time));
                        time++;
                        if(time > 25){
                            timer.stop();
                            JOptionPane.showMessageDialog(label, "Time is up, the numer was: " + intRand);
                            randomizeButton.setEnabled(true);
                        }

                });
                timer.start();

                try {
                    Thread.sleep(20000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }).start();

        });



        enterButton.addActionListener(e -> {
            String guess = field.getText();
                if (intRand == Integer.valueOf(guess)) {
                    JOptionPane.showMessageDialog(field, "Correct guess, the number was: " + intRand);
                    timer.stop();
                    randomizeButton.setEnabled(true);
                    field.setText("");
                }else if (intRand > Integer.valueOf(guess)) {
                    JOptionPane.showMessageDialog(field, "Too low guess, try again!");
                    field.setText("");
                }else if (intRand < Integer.valueOf(guess)) {
                    JOptionPane.showMessageDialog(field, "Too high guess, try again!");
                    field.setText("");
                }else if (intRand != Integer.valueOf(guess)) {
                    JOptionPane.showMessageDialog(field, "Wrong Guess, the number was: " + intRand);
                    timer.stop();
                    field.setText("");
                }else if(guess.equals("")){
                    JOptionPane.showMessageDialog(field, "You have to input a value, try again");
            }
        });

        }
}
