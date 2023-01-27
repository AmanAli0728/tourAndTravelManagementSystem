package tour.management.system;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class BookVehical extends JFrame {
    private JPanel contentPane;
    JTextField t1,t2,t3;
    Choice c1,c2,c3;
    BookVehical(String username){
        setBounds(450, 200, 1100, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book-taxi.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,100,700,300);
        add(la1);

        JLabel lblName = new JLabel("BOOK VEHICLE");
        lblName.setFont(new Font("Tohoma", Font.BOLD, 20));
        lblName.setBounds(118, 11, 300, 53);
        contentPane.add(lblName);

        JLabel la2 = new JLabel("Username :");
        la2.setBounds(35, 70, 200, 14);
        contentPane.add(la2);

        JLabel l1 = new JLabel(username);
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Select Cab :");
        lblId.setBounds(35, 110, 200, 14);
        contentPane.add(lblId);

        c1 = new Choice();
        Conn c = new Conn();
        try{
            ResultSet rs = c.s.executeQuery("select * from cab");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
            rs.close();
        }catch(SQLException e){}
        c1.setBounds(271, 110, 150, 30);
        add(c1);

        JLabel la3 = new JLabel("No Of Person");
        la3.setBounds(35, 150, 200, 14);
        contentPane.add(la3);

        t1 = new JTextField();
        t1.setBounds(271, 150, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        JLabel la4 = new JLabel("No Of Days");
        la4.setBounds(35, 190, 200, 14);
        contentPane.add(la4);

        t2 = new JTextField();
        t2.setBounds(271, 190, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        JLabel la7 = new JLabel("Date");
        la7.setBounds(35, 230, 200, 14);
        contentPane.add(la7);

        t3 = new JTextField();
        t3.setText(String.valueOf(java.time.LocalDate.now()));
        t3.setBounds(271, 230, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        JLabel la5 = new JLabel("Booking Id");
        la5.setBounds(35, 270, 200, 20);
        contentPane.add(la5);

        Random ram = new Random();
        JLabel la6 = new JLabel(""+Math.abs(ram.nextInt() % 100000));
        la6.setForeground(Color.RED);
        la6.setBounds(271, 270, 200, 14);
        contentPane.add(la6);

        JLabel lbl1 = new JLabel("Customer ID :");
        lbl1.setBounds(35, 310, 200, 20);
        contentPane.add(lbl1);

        JTextField l2 = new JTextField();
        l2.setBounds(271, 310, 150, 20);
        contentPane.add(l2);

        JLabel lblDeposite = new JLabel("Total Price :");
        lblDeposite.setBounds(35, 350, 200, 14);
        contentPane.add(lblDeposite);

        JLabel l5 = new JLabel();
        l5.setBounds(271, 350, 200, 14);
        l5.setForeground(Color.RED);
        contentPane.add(l5);


        JButton b1 = new JButton("Check Price");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                int price;
                try{
                    String q1 = "select * from cab where name = '"+c1.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(q1);
                    if(rs.next()) {
                        price = rs.getInt("price");
                        int total_price = Integer.parseInt(t2.getText()) * price;
                        l5.setText("Rs: " + total_price);
                    }
                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }
            }
        });
        b1.setBounds(50, 400, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);


        JButton btnNewButton = new JButton("Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Conn c = new Conn();
                try{
                    if(t1.getText().isEmpty() || c1.getSelectedItem().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()|| la6.getText().isEmpty() || l2.getText().isEmpty()|| l5.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill all the Fields");
                    }
                    else {
                    String hotel = c1.getSelectedItem();
                    int no_of_person = Integer.parseInt(t1.getText());
                    int no_of_days = Integer.parseInt(t2.getText());
                    String date = t3.getText();
                    int booking = Integer.parseInt(la6.getText());
                    int customer_id = Integer.parseInt(l2.getText());
                    String price = l5.getText();
                    String query = "insert into bookCab (userName,cab,no_of_person,no_of_days,date,bookingId,customer_id,Price) values('" + username + "', '" + hotel + "', '" + no_of_person + "', '" + no_of_days + "', '" + date + "', '" + booking + "', '" + customer_id + "', '" + price + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Cab Booked Successfully");
                    setVisible(false);
                    }
                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }
            }
        });
        btnNewButton.setBounds(200, 400, 120, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        contentPane.add(btnNewButton);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(350, 400, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookVehical frame = new BookVehical("");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
