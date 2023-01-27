package tour.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vehicals extends JFrame implements ActionListener,MouseListener {
    private JPanel contentPane;
    JButton Book, Book1,Book2;
    String Username;
    Vehicals( String username){
        username = Username;
        setBounds(700, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblName = new JLabel("Our Vehicals");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblName.setBounds(321, 11, 350, 53);
        contentPane.add(lblName);
        contentPane.addMouseListener(this);
        setVisible(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/car.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(18, 96, 250, 250);
        add(image);

        JLabel lblName1 = new JLabel("Car");
        lblName1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName1.setBounds(125, 369, 100, 20);
        contentPane.add(lblName1);

        Book = new JButton("Book Now");
        Book.setBounds(100, 408, 100, 25);
        Book.setBackground(Color.black);
        Book.setForeground(Color.white);
        Book.addActionListener(this);
        add(Book);

        ImageIcon img2 = new ImageIcon(ClassLoader.getSystemResource("icons/mini-bus.jpg"));
        Image img3 = img2.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon img4 = new ImageIcon(img3);
        JLabel image1 = new JLabel(img4);
        image1.setBounds(290, 96, 250, 250);
        add(image1);

        JLabel lblName2 = new JLabel("Mini Bus");
        lblName2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName2.setBounds(388, 369, 100, 20);
        contentPane.add(lblName2);

        Book1 = new JButton("Book Now");
        Book1.setBounds(380, 408, 100, 25);
        Book1.setBackground(Color.black);
        Book1.setForeground(Color.white);
        Book1.addActionListener(this);
        add(Book1);

        ImageIcon img5 = new ImageIcon(ClassLoader.getSystemResource("icons/bus.jpg"));
        Image img6 = img5.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon img7 = new ImageIcon(img6);
        JLabel image3 = new JLabel(img7);
        image3.setBounds(563, 96, 250, 250);
        add(image3);

        JLabel lblName3 = new JLabel("Bus");
        lblName3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName3.setBounds(683, 369, 100, 20);
        contentPane.add(lblName3);

        Book2 = new JButton("Book Now");
        Book2.setBounds(662, 408, 100, 25);
        Book2.setBackground(Color.black);
        Book2.setForeground(Color.white);
        Book2.addActionListener(this);
        add(Book2);


    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("position of X is : "+e.getX()+"  and position of Y is : "+e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed; # of clicks: " + e.getClickCount());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Book) {
            setVisible(false);
            BookVehical b1 = new BookVehical(Username);
            b1.setVisible(true);
        } else if (ae.getSource() == Book1) {
            setVisible(false);
            BookVehical b2 =new BookVehical(Username);
            b2.setVisible(true);
        } else if (ae.getSource() == Book2) {
            setVisible(false);
            BookVehical b2 = new BookVehical(Username);
            b2.setVisible(true);
        }

    }

    public static void main(String[] args) {
       Vehicals vehicals = new Vehicals("");
       vehicals.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
