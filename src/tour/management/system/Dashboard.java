package tour.management.system;

//import com.mysql.cj.conf.AbstractPropertyDefinition;

import tour.management.system.Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener{
    JButton addPersonalDetails,updatePersonalDetails,viewDetails,deletePersonalDetails,checkPackage,bookPackage,viewPackage,viewHotels,bookHotel,viewBookedHotel,destinations,vehicle,payment,calculator,logOut;
    String userName;
    Dashboard(){}
    Dashboard(String userName) {
        this.userName=userName;
//        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Instead of using set bounds i can use this method to the entire  screen
        setLayout(null);

        JPanel p1= new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2= i1.getImage().getScaledInstance(70,60,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon= new JLabel(i3);
        icon.setBounds(5,5,70,60);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(90,15,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2= new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addPersonalDetails= new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));

        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails= new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,48,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,35));

        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewDetails= new JButton("View Details");
        viewDetails.setBounds(0,96,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.white);
        viewDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewDetails.setMargin(new Insets(0,0,0,135));

        viewDetails.addActionListener(this);
        p2.add(viewDetails);

        deletePersonalDetails= new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,144,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));

        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackage= new JButton("Check Packages");
        checkPackage.setBounds(0,192,300,50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.white);
        checkPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackage.setMargin(new Insets(0,0,0,100));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage= new JButton("Book Package");
        bookPackage.setBounds(0,240,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage= new JButton("View Package");
        viewPackage.setBounds(0,288,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels= new JButton("View Hotels");
        viewHotels.setBounds(0,336,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel= new JButton("Book Hotel");
        bookHotel.setBounds(0,384,300,50);
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotel.setMargin(new Insets(0,0,0,145));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel= new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,432,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,75));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destinations= new JButton("Destinations");
        destinations.setBounds(0,480,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,135));
        destinations.addActionListener(this);
        p2.add(destinations);

        calculator= new JButton("Calculator");
        calculator.setBounds(0,528,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,155));
        calculator.addActionListener(this);
        p2.add(calculator);

        vehicle= new JButton("Book Vehicles");
        vehicle.setBounds(0,576,300,50);
        vehicle.setBackground(new Color(0,0,102));
        vehicle.setForeground(Color.white);
        vehicle.setFont(new Font("Tahoma",Font.PLAIN,20));
        vehicle.setMargin(new Insets(0,0,0,120));
        vehicle.addActionListener(this);
        p2.add(vehicle);

        payment= new JButton("Payment");
        payment.setBounds(0,624,300,50);
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tahoma",Font.PLAIN,20));
        payment.setMargin(new Insets(0,0,0,165));
        payment.addActionListener(this);
        p2.add(payment);

        logOut= new JButton("Log Out");
        logOut.setBounds(0,672,300,50);
        logOut.setBackground(new Color(0,0,102));
        logOut.setForeground(Color.white);
        logOut.setFont(new Font("Tahoma",Font.PLAIN,20));
        logOut.setMargin(new Insets(0,0,0,170));
        logOut.addActionListener(this);
        p2.add(logOut);

        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(0,0,102));
        p3.setBounds(300,65,1600,1000);
        add(p3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/dashboard.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1300,820,Image.SCALE_DEFAULT);
        ImageIcon i6= new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1300,820);
        p3.add(image);

        JLabel text =new JLabel("Travel and Tourism Management Portal");
        text.setBounds(100,30,1200,70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,55));
        image.add(text);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addPersonalDetails){
            new AddCustomer(userName);
        }
        else if(ae.getSource()== viewDetails){
            new ViewCustomer(userName);
        }
        else if(ae.getSource()==updatePersonalDetails){
            new UpdateCustomer(userName);
        }
        else if(ae.getSource()==deletePersonalDetails){
            new DeleteDetails(userName);
        }
        else if(ae.getSource()==checkPackage){
            new CheckPackage(userName);
        }
        else if(ae.getSource()==bookPackage){
            BookPackage frame = new BookPackage(userName);
            frame.setVisible(true);
        }
        else if(ae.getSource()==viewPackage){
            ViewPackage frame = new ViewPackage(userName);
            frame.setVisible(true);
        }
        else if(ae.getSource()==viewHotels){
            new CheckHotels();
        }
        else if(ae.getSource()==bookHotel){
            BookHotel frame = new BookHotel(userName);
            frame.setVisible(true);
        }
        else if(ae.getSource()==viewBookedHotel){
            ViewBookedHotel frame = new ViewBookedHotel(userName);
            frame.setVisible(true);
        }
        else if(ae.getSource()==destinations){
            new Destination();
        }
        else if(ae.getSource()==vehicle){
            new Homepage(userName);
        }
        else if(ae.getSource()==payment){
           new Payment();
        }
        else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){ }
        }
        else if(ae.getSource()==logOut){
            setVisible(false);
            new Login();

        }
    }

    public static void main(String[] args) {
       Dashboard ds = new Dashboard("");
       ds.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}