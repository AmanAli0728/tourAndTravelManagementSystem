package tour.management.system;

import java.awt.*;
import javax.swing.*;

public class CheckPackage extends JFrame {
    String username;
    CheckPackage(String username){
        this.username = username;
        setBounds(450,200,950,450);
        String [] package1={"CHAR DHAM PACKAGE","10 Days 11 Night Tour","Free Transportation", "Airport and Railway Station Pickup","Free Sightseeing", "Free Helicopter Ride","Other Local Temples Trips","Visit Devprayag", "package1.jpg"};
        String [] package2 ={"HONEYMOON PACKAGE","5 Days and 6 Nights", "Daily Breakfast & Dinner","Special Romantic Candle-Light Dinner","Romantic Dinners At The Beach", "Airport Pick Up & Drop","Entry To Light And Sound Show","Free Bike/Scooty on rent","package2.jpg"};
        String [] package3 = {"FAMILY PACKAGE","6 Days and 5 Nights", "Daily Breakfast & Dinner","Railway Station Pick Up & Drop","Free Sightseeing","Free Transport","Early Check-In Or Late Check-Out","Hiking","package3.jpg"};
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPanal(package1);
        JPanel p2 = createPanal(package2);
        JPanel p3 = createPanal(package3);


        tab.addTab("Package 1",null,p1);
        tab.addTab("Package 2",null,p2);
        tab.addTab("Package 3",null,p3);
        add(tab);

        setVisible(true);
    }
    public JPanel createPanal(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.WHITE);


        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(Color.WHITE);


        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(540,13,400,30);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(611,105,300,30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(611,135,300,30);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(611,165,300,30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(611,195,300,30);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(611,225,300,30);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(611,255,300,30);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(611,285,300,30);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l8);

//        book1 = new JButton("Book Now");
//        book1.setBounds(557,360,250,30);
//        book1.setForeground(Color.WHITE);
//        book1.setBackground(Color.BLACK);
////        book1.setMargin(new Insets(0,0,0,170));
//        book1.setFont(new Font("Tahoma",Font.BOLD,20));
//        book1.addActionListener(this);
//        p1.add(book1);


//        JLabel l10 = new JLabel(pack[8]);
//        l10.setBounds(500,315,300,30);
//        l10.setForeground(Color.BLACK);
//        l10.setFont(new Font("Tahoma",Font.PLAIN,15));
//        p1.add(l10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[8]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(21,60,500,300);
        p1.add(l11);

        JLabel l12 = new JLabel("Package Include: ");
        l12.setBounds(576,64,300,30);
        l12.setForeground(Color.BLACK);
        l12.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l12);

        return p1;


    }


    public static void main(String[] args) {
        CheckPackage pack = new CheckPackage("");
        pack.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }



}
