package tour.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPackage extends JFrame implements ActionListener {
	private JPanel contentPane;
	Choice c1;
	JTextField bookingId;
	JButton search;
	JLabel lCustomerName,l2,l3,l4,l5,l6,l7,l8,l9;

	public ViewPackage(String username)  {
		setBounds(450, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450,40,350,350);
		add(la1);
		
		JLabel lblName = new JLabel("VIEW BOOKED PACKAGE DETAILS");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(88, 11, 350, 53);
		contentPane.add(lblName);

		JLabel lblbookingId = new JLabel("Booking ID: ");
		lblbookingId.setBounds(35, 70, 100, 25);
		contentPane.add(lblbookingId);

		bookingId = new JTextField();
		bookingId.setBounds(150, 70, 150, 25);
		contentPane.add(bookingId);

		search = new JButton("Search");
		search.setBounds(330, 70, 100, 25);
		search.setBackground(Color.black);
		search.setForeground(Color.white);

		search.addActionListener(this);
		contentPane.add(search);

		JLabel lblCustomerName = new JLabel("Name :");
		lblCustomerName.setBounds(35, 110, 200, 14);
		contentPane.add(lblCustomerName);

		lCustomerName = new JLabel();
		lCustomerName.setBounds(271, 110, 200, 14);
		contentPane.add(lCustomerName);
                
		JLabel lblId = new JLabel("Package :");
		lblId.setBounds(35, 150, 200, 14);
		contentPane.add(lblId);
                
		l2 = new JLabel();
		l2.setBounds(271, 150, 200, 14);
		contentPane.add(l2);
                
		JLabel lblperson = new JLabel("Number of Persons :");
		lblperson.setBounds(35, 190, 200, 14);
		contentPane.add(lblperson);
                
		l3 = new JLabel();
		l3.setBounds(271, 190, 200, 14);
		contentPane.add(l3);

		JLabel lbldays = new JLabel("No of Days :");
		lbldays.setBounds(35, 230, 200, 14);
		contentPane.add(lbldays);

		l8 = new JLabel();
		l8.setBounds(271, 230, 200, 14);
		contentPane.add(l8);

		JLabel lbldate = new JLabel("Date :");
		lbldate.setBounds(35, 270, 200, 14);
		contentPane.add(lbldate);

		l9 = new JLabel();
		l9.setBounds(271, 270, 200, 14);
		contentPane.add(l9);
		
		JLabel lblIdentity_name = new JLabel("ID :");
		lblIdentity_name.setBounds(35, 310, 200, 14);
		contentPane.add(lblIdentity_name);
		
		l4 = new JLabel();
		l4.setBounds(271, 310, 200, 14);
		contentPane.add(l4);

                
		JLabel lblIdentity_number = new JLabel("Number :");
		lblIdentity_number.setBounds(35, 350, 200, 14);
		contentPane.add(lblIdentity_number);
                
		l5 = new JLabel();
		l5.setBounds(271, 350, 200, 14);
		contentPane.add(l5);
                
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(35, 390, 200, 14);
		contentPane.add(lblPhone);
                
		l6 = new JLabel();
		l6.setBounds(271, 390, 350, 14);
		contentPane.add(l6);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(35, 430, 200, 14);
		contentPane.add(lblPrice);
                
		l7 = new JLabel();
		l7.setBounds(271, 430, 200, 14);
		contentPane.add(l7);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(160, 470, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		getContentPane().setBackground(Color.WHITE);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
			try {
				int customer_id = 0;
				String query = "Select * from bookpackage where booking_id ='" + bookingId.getText() + "'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
				while (rs.next()) {
					customer_id = rs.getInt("customer_id");
					l2.setText(rs.getString("package"));
					l3.setText(rs.getString("persons"));
					l8.setText(rs.getString("No_Of_Days"));
					l9.setText(rs.getString("date"));
					l7.setText(rs.getString("price"));
				}
				String query1 = "Select * from customer where customer_Id ='"+customer_id+"'";
				ResultSet rs1 = c.s.executeQuery(query1);
				while(rs1.next()) {
					lCustomerName.setText(rs1.getString("name"));
					l4.setText(rs1.getString("identity_Name"));
					l5.setText(rs1.getString("identity_Number"));
					l6.setText(rs1.getString("phone"));

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
					ViewPackage frame = new ViewPackage("");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}