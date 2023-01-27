package tour.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread thread;
    JProgressBar bar;
    String userName;

    public Loading(String userName) {
        this.userName=userName;

        setBounds(599, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(160, 110, 300, 30);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(230, 150, 180, 30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel lblUserName = new JLabel("Welcome "+userName);
        lblUserName.setBounds(20, 310, 400, 40);
        lblUserName.setForeground(Color.red);
        lblUserName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblUserName);

        thread =new Thread(this);
        thread.start();
        setVisible(true);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                if (value < max) { // 101 < 100
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(userName);
                }
                Thread.sleep(50);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Loading lo = new Loading("");
        lo.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
