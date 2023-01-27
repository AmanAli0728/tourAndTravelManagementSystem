package tour.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookedVehical extends JFrame implements ActionListener  {
    private JPanel contentPane;
    Choice c1;
    JTextField tfId;
    JButton search;
    String Username;
    JLabel l1,l2,l3,l4,l7,l8,l9,l10,l11;
    public ViewBookedVehical(String username)  {
        setBounds(700, 200, 850, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        Username = username;

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/booked-vehicle.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel la1 = new JLabel(i2);
        la1.setBounds(450,50,500,350);
        add(la1);

        JLabel lblName = new JLabel("VIEW BOOKED VEHICLE");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblName.setBounds(88, 11, 350, 53);
        contentPane.add(lblName);

        JLabel lb3 = new JLabel("Name :");
        lb3.setBounds(35, 70, 200, 14);
        contentPane.add(lb3);

        l1 = new JLabel();
        l1.setBounds(271, 70, 200, 14);
        contentPane.add(l1);

        JLabel lblId = new JLabel("Booking Id: ");
        lblId.setBounds(35, 110, 100, 25);
        contentPane.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(150, 110, 150, 25);
        contentPane.add(tfId);

        search = new JButton("Search");
        search.setBounds(330, 110, 100, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);

        search.addActionListener(this);
        contentPane.add(search);

        JLabel lblCab = new JLabel("Cab :");
        lblCab.setBounds(35, 150, 200, 14);
        contentPane.add(lblCab);

        l2 = new JLabel();
        l2.setBounds(271, 150, 200, 14);
        contentPane.add(l2);

        JLabel lb2 = new JLabel("No Of Person:");
        lb2.setBounds(35, 190, 200, 14);
        contentPane.add(lb2);

        l3 = new JLabel();
        l3.setBounds(271, 190, 200, 14);
        contentPane.add(l3);

        JLabel lblName_1 = new JLabel("No of Days:");
        lblName_1.setBounds(35, 230, 200, 14);
        contentPane.add(lblName_1);

        l4 = new JLabel();
        l4.setBounds(271, 230, 200, 14);
        contentPane.add(l4);

        JLabel lblName_2 = new JLabel("Date");
        lblName_2.setBounds(35, 270, 200, 14);
        contentPane.add(lblName_2);

        l11 = new JLabel();
        l11.setBounds(271, 270, 200, 14);
        contentPane.add(l11);

        JLabel lblIdentiry = new JLabel("ID :");
        lblIdentiry.setBounds(35, 310, 200, 14);
        contentPane.add(lblIdentiry);

        l7 = new JLabel();
        l7.setBounds(271, 310, 200, 14);
        contentPane.add(l7);

        JLabel lblCheckInStatus = new JLabel("Number :");
        lblCheckInStatus.setBounds(35, 350, 200, 14);
        contentPane.add(lblCheckInStatus);

        l8 = new JLabel();
        l8.setBounds(271, 350, 200, 14);
        contentPane.add(l8);


        JLabel lblPhone = new JLabel("Phone :");
        lblPhone.setBounds(35, 390, 200, 14);
        contentPane.add(lblPhone);

        l9 = new JLabel();
        l9.setBounds(271, 390, 200, 14);
        contentPane.add(l9);

        JLabel la2 = new JLabel("Cost :");
        la2.setBounds(35, 430, 200, 14);
        contentPane.add(la2);

        l10 = new JLabel();
        l10.setBounds(271, 430, 200, 14);
        contentPane.add(l10);

        Conn c = new Conn();

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        btnExit.setBounds(160, 480, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);
        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                int customer_id=0;
                String query = "Select * from bookCab where bookingId = '" + tfId.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs.next()) {
                    customer_id = rs.getInt("customer_id");
                    l2.setText(rs.getString("cab"));
                    l3.setText(rs.getString("no_of_person"));
                    l4.setText(rs.getString("no_of_days"));
                    l10.setText(rs.getString("price"));
                    l11.setText(rs.getString("date"));
                }
                String query1 = "Select * from customer where customer_Id = '" + customer_id + "'";
                ResultSet rs1 = c.s.executeQuery(query1); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs1.next()) {
                    l1.setText(rs1.getString("name"));
                    l7.setText(rs1.getString("identity_Name"));
                    l8.setText(rs1.getString("identity_Number"));
                    l9.setText(rs1.getString("phone"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBookedVehical frame = new ViewBookedVehical("");
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
