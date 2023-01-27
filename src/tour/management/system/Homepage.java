package tour.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Homepage extends JFrame implements ActionListener {
    String Username;
    JButton Vehicals,bookVehical,viewBookedVehical,cancelBooking;
    Homepage(String username){
        Username = username;
        setBounds(450, 200, 1100, 600);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(250,0,950,600);
        add(p1);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/taxi.jpg"));
        Image i3 = i1.getImage().getScaledInstance(950, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel icon = new JLabel(i2);
        icon.setBounds(0,0,850,600);
        p1.add(icon);

        JPanel p2= new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,0,250,600);
        add(p2);

        Vehicals = new JButton("Vehicals");
        Vehicals.setBounds(0,0,250,50);
        Vehicals.setBackground(new Color(0,0,102));
        Vehicals.setForeground(Color.white);
        Vehicals.setFont(new Font("Tahoma",Font.PLAIN,20));
        Vehicals.setMargin(new Insets(0,0,0,30));

        Vehicals.addActionListener(this);
        p2.add(Vehicals);

        bookVehical = new JButton("Book Vehical");
        bookVehical.setBounds(0,50,250,50);
        bookVehical.setBackground(new Color(0,0,102));
        bookVehical.setForeground(Color.white);
        bookVehical.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookVehical.setMargin(new Insets(0,0,0,30));

        bookVehical.addActionListener(this);
        p2.add(bookVehical);

        viewBookedVehical = new JButton("View Booked Vehical");
        viewBookedVehical.setBounds(0,100,250,50);
        viewBookedVehical.setBackground(new Color(0,0,102));
        viewBookedVehical.setForeground(Color.white);
        viewBookedVehical.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedVehical.setMargin(new Insets(0,0,0,30));

        viewBookedVehical.addActionListener(this);
        p2.add(viewBookedVehical);

        cancelBooking = new JButton("Cancel Booking");
        cancelBooking.setBounds(0,150,250,50);
        cancelBooking.setBackground(new Color(0,0,102));
        cancelBooking.setForeground(Color.white);
        cancelBooking.setFont(new Font("Tahoma",Font.PLAIN,20));
        cancelBooking.setMargin(new Insets(0,0,0,30));

        cancelBooking.addActionListener(this);
        p2.add(cancelBooking);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Vehicals){
            new Vehicals(Username);
        }
        else if(e.getSource() == bookVehical){
            BookVehical frame = new BookVehical(Username);
            frame.setVisible(true);
        }
        else if(e.getSource() == viewBookedVehical){
            ViewBookedVehical frame = new ViewBookedVehical(Username);
            frame.setVisible(true);
        }
        else if(e.getSource() == cancelBooking){
            new CancelBooking();
        }

    }

    public static void main(String[] args) {
       Homepage hp =  new Homepage("");
       hp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}
