package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class CancelBooking extends JFrame implements ActionListener {
    JTextField tfId, tfPick, tfDrop, tfDate;
    JButton search, delete;

    CancelBooking(){
        setBounds(700, 250, 850, 380);
//        getContentPane().setBackground(new Color(131, 193, 233));
        setLayout(null);


        //2.Adding image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel-booking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560, 50, 250, 250);
        add(image);

        //3.Creating panel for the labels,text-field and buttons
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lblId = new JLabel("Booking Id: ");
        lblId.setBounds(40, 20, 100, 25);
        lblId.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblId);

        tfId = new JTextField();
        tfId.setBounds(200, 20, 150, 25);
        tfId.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfId);

        search = new JButton("Search");
        search.setBounds(380, 20, 100, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);

        search.addActionListener(this);
        p1.add(search);

        JLabel lblpick = new JLabel("Customer Id: ");
        lblpick.setBounds(40, 60, 150, 25);
        lblpick.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblpick);

        tfPick = new JTextField();
        tfPick.setBounds(200, 60, 150, 25);
        tfPick.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPick);

        JLabel lblDrop = new JLabel("No Of Days:  ");
        lblDrop.setBounds(40, 100, 150, 25);
        lblDrop.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblDrop);

        tfDrop = new JTextField();
        tfDrop.setBounds(200, 100, 150, 25);
        tfDrop.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfDrop);

        JLabel lblDate = new JLabel(" Date");
        lblDate.setBounds(40, 140, 150, 25);
        lblDate.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblDate);

        tfDate = new JTextField();
        tfDate.setBounds(200, 140, 150, 25);
        tfDate.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfDate);

        delete = new JButton("Delete");
        delete.setBounds(150, 230, 100, 25);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);

        delete.addActionListener(this);
        p1.add(delete);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                String query = "Select * from bookCab where bookingId = '" + tfId.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs.next()) {
                    tfPick.setText(rs.getString("customer_id"));
                    tfDrop.setText(rs.getString("no_of_days"));
                    tfDate.setText(rs.getString("date"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == delete) {
            try{
                Conn c = new Conn();
                int id = Integer.parseInt(tfId.getText());
                String query1="delete from bookCab where bookingId = '"+id+"'";
                c.s.execute(query1);
                JOptionPane.showMessageDialog(null,"Cab Cancelled Successfully");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CancelBooking can = new CancelBooking();
        can.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
