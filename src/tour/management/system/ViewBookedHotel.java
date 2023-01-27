package tour.management.system;

import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewBookedHotel extends JFrame implements ActionListener{
	private JPanel contentPane;
	JTextField bookingId;
	Choice c1;
	JButton search;
	String Username;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	public ViewBookedHotel(String username)  {
		setBounds(450, 200, 850, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Username = username;
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 350,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450,50,350,350);
		add(la1);
		
		JLabel lblHotelName = new JLabel("VIEW BOOKED HOTEL DETAILS");
		lblHotelName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblHotelName.setBounds(88, 11, 350, 53);
		contentPane.add(lblHotelName);
                
		JLabel lb3 = new JLabel("Username :");
		lb3.setBounds(35, 70, 200, 14);
		contentPane.add(lb3);
                
		l1 = new JLabel(Username);
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);

		JLabel lblbookingId = new JLabel("Booking ID: ");
		lblbookingId.setBounds(35, 110, 100, 25);
		contentPane.add(lblbookingId);

		bookingId = new JTextField();
		bookingId.setBounds(150, 110, 150, 25);
		contentPane.add(bookingId);

		search = new JButton("Search");
		search.setBounds(330, 110, 100, 25);
		search.setBackground(Color.black);
		search.setForeground(Color.white);

		search.addActionListener(this);
		contentPane.add(search);
                
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(35, 150, 200, 14);
		contentPane.add(lblName);
                
		l2 = new JLabel();
		l2.setBounds(271, 150, 200, 14);
		contentPane.add(l2);
                
		JLabel lb2 = new JLabel("Number of Persons :");
		lb2.setBounds(35, 190, 200, 14);
		contentPane.add(lb2);
                
		l3 = new JLabel();
		l3.setBounds(271, 190, 200, 14);
		contentPane.add(l3);
		
		JLabel lblNoOfDays = new JLabel("Number of Days :");
		lblNoOfDays.setBounds(35, 230, 200, 14);
		contentPane.add(lblNoOfDays);
		
		l4 = new JLabel();
		l4.setBounds(271, 230, 200, 14);
		contentPane.add(l4);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(35, 270, 200, 14);
		contentPane.add(lblDate);

		l11 = new JLabel();
		l11.setBounds(271, 270, 200, 14);
		contentPane.add(l11);

                
		JLabel lblAC = new JLabel("AC / Non-AC :");
		lblAC.setBounds(35, 310, 200, 14);
		contentPane.add(lblAC);
                
		l5 = new JLabel();
		l5.setBounds(271, 310, 200, 14);
		contentPane.add(l5);
                
		JLabel lblFood = new JLabel("Food Included (Yes/No) :");
		lblFood.setBounds(35, 350, 200, 14);
		contentPane.add(lblFood);
                
		l6 = new JLabel();
		l6.setBounds(271, 350, 200, 14);
		contentPane.add(l6);
		
		JLabel lblIdentity = new JLabel("ID :");
		lblIdentity.setBounds(35, 390, 200, 14);
		contentPane.add(lblIdentity);
                
		l7 = new JLabel();
		l7.setBounds(271, 390, 200, 14);
		contentPane.add(l7);
           	
		JLabel lblIdentityNumber = new JLabel("Number :");
		lblIdentityNumber.setBounds(35, 430, 200, 14);
		contentPane.add(lblIdentityNumber);
                
		l8 = new JLabel();
		l8.setBounds(271, 430, 200, 14);
		contentPane.add(l8);

		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(35, 470, 200, 14);
		contentPane.add(lblPhone);
		
		l9 = new JLabel();
		l9.setBounds(271, 470, 200, 14);
		contentPane.add(l9);
                
		JLabel la2 = new JLabel("Cost :");
		la2.setBounds(35, 510, 200, 14);
		contentPane.add(la2);
		
		l10 = new JLabel();
		l10.setBounds(271, 510, 200, 14);
		contentPane.add(l10);
                
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		}); 
		btnExit.setBounds(160, 550, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
		getContentPane().setBackground(Color.WHITE);
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
			try {
				int customerid=0;
				String query = "Select * from bookhotel where booking_id = '" + bookingId.getText() + "'";
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
				while (rs.next()) {
					customerid = rs.getInt("customer_id");
					l3.setText(rs.getString("person"));
					l4.setText(rs.getString("No_Of_Days"));
					l5.setText(rs.getString("ac"));
					l6.setText(rs.getString("food"));
					l10.setText(rs.getString("price"));
					l11.setText(rs.getString("date"));
				}
				String query1 = "Select * from customer where customer_id ='"+customerid+"'";
				ResultSet rs1 = c.s.executeQuery(query1);
				while(rs1.next()) {
					l2.setText(rs1.getString("name"));
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
					ViewBookedHotel frame = new ViewBookedHotel("");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}