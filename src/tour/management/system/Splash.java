package tour.management.system;

import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable {
    Thread thread;

    Splash() {
//        jframe is comes form javax.swing package
//        setSize(1200,600);  //It is used to define the frame  size
//        setLocation(200,100); //It has also a problem when we create any frame then it opens from the top but i want it to be centre on screen
// using with dynamically set

        //Now i want to get an image to the frame to set it i have to create a object of the class ImageIcon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/splash.jpg"));
//        ImageIcon i2= new ImageIcon(i1);
        //Now ia have to pick items from source dir so there is a class called ClassLoader to pick up the icon from the classloader there is a function called getSystemResource
        //The image is zommed now to fix it there is a class called image and create its object.
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        //Image class object cannot directly placed into label so we have to create an image icon classs and the put i2 there the n we have to place ImageIcon class object into the label.
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Splash frame = new Splash();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int x = 1;
        for (int i = 1; i < 500; x += 7, i += 6) {
            frame.setLocation(750 - (x + i) / 2, 400 - (i / 2));
            frame.setSize(x + i, i);
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
