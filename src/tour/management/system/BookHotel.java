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

public class BookHotel extends JFrame {
	private JPanel contentPane;
	JTextField t1,t2,t3,l2;
	Choice c1,c2,c3;

	public BookHotel(String username) {
		setBounds(450, 200, 1100, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450,100,700,300);
		add(la1);
		
		JLabel lblName = new JLabel("BOOK HOTEL");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 300, 53);
		contentPane.add(lblName);
                
		JLabel la2 = new JLabel("Username :");
		la2.setBounds(35, 70, 200, 14);
		contentPane.add(la2);
                
		JLabel l1 = new JLabel(username);
		l1.setBounds(271, 70, 200, 14);
		contentPane.add(l1);

		JLabel labook = new JLabel("Booking Id");
		labook.setBounds(35, 110, 200, 20);
		contentPane.add(labook);

		Random ram = new Random();
		JLabel labook1 = new JLabel(""+Math.abs(ram.nextInt() % 100000));
		labook1.setForeground(Color.RED);
		labook1.setBounds(271, 110, 200, 14);
		contentPane.add(labook1);
                
		JLabel lblId = new JLabel("Select Hotel :");
		lblId.setBounds(35, 150, 200, 14);
		contentPane.add(lblId);
                
		c1 = new Choice();
		Conn c = new Conn();
		try{
			ResultSet rs = c.s.executeQuery("select * from hotel");
			while(rs.next()){
				c1.add(rs.getString("name"));
			}
			rs.close();
		}catch(SQLException e){}
		c1.setBounds(271, 150, 150, 30);
		add(c1);
                
		JLabel la3 = new JLabel("Total Persons");
		la3.setBounds(35, 190, 200, 14);
		contentPane.add(la3);
                
		t1 = new JTextField();
		t1.setText("0");
		t1.setBounds(271, 190, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
		JLabel la4 = new JLabel("Number of Days");
		la4.setBounds(35, 230, 200, 14);
		contentPane.add(la4);
		
		t2 = new JTextField();
		t2.setText("1");
		t2.setBounds(271, 230, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);

		JLabel la7 = new JLabel("Date");
		la7.setBounds(35, 270, 200, 14);
		contentPane.add(la7);

		t3 = new JTextField();
		t3.setText(String.valueOf(java.time.LocalDate.now()));
		t3.setBounds(271, 270, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JLabel la5 = new JLabel("AC / Non-AC");
		la5.setBounds(35, 310, 200, 14);
		contentPane.add(la5);

		c2 = new Choice();
		c2.add("AC");
		c2.add("Non-AC");
		c2.setBounds(271, 310, 150, 30);
		add(c2);


		JLabel la6 = new JLabel("Food Included :");
		la6.setBounds(35, 350, 200, 14);
		contentPane.add(la6);

		c3 = new Choice();
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(271, 350, 150, 30);
		add(c3);

		JLabel lbl1 = new JLabel("Customer ID :");
		lbl1.setBounds(35, 390, 200, 14);
		contentPane.add(lbl1);

		l2 = new JTextField();
		l2.setBounds(271, 390, 150, 20);
		contentPane.add(l2);

		JLabel lblDeposite = new JLabel("Total Price :");
		lblDeposite.setBounds(35, 430, 200, 14);
		contentPane.add(lblDeposite);
		
		JLabel l5 = new JLabel();
		l5.setBounds(271, 430, 200, 14);
		l5.setForeground(Color.RED);
		contentPane.add(l5);
                
		JButton b1 = new JButton("Check Price");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try{
//					String s1 = c1.getSelectedItem();
					String q1 = "select * from hotel where name = '"+c1.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(q1);
					if(rs.next()){
						int cost = Integer.parseInt(rs.getString("costperperson"));
						int food = Integer.parseInt(rs.getString("foodincluded"));
						int ac = Integer.parseInt(rs.getString("acroom"));
                                    
						int persons = Integer.parseInt(t1.getText());
						int days = Integer.parseInt(t2.getText());
                                    
						String acprice = c2.getSelectedItem();
						String foodprice = c3.getSelectedItem();
                                    
						if(persons * days > 0) {
							int total = 0;
							total += acprice.equals("AC") ? ac : 1;
							total += foodprice.equals("Yes") ? food : 1;
							total += cost;
							total = total * persons * days;
							l5.setText("Rs "+total);
						}
					}
				}catch(Exception ee){
	    			System.out.println(ee.getMessage());
	    		}
			}
		});
		b1.setBounds(50, 500, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		contentPane.add(b1);
		

		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c = new Conn();
				try{
					if(t1.getText().isEmpty() || c1.getSelectedItem().isEmpty() || c2.getSelectedItem().isEmpty()|| c3.getSelectedItem().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()|| la6.getText().isEmpty() || l2.getText().isEmpty() || labook1.getText().isEmpty()|| l5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill all the Fields");
					}
					else {
					int customerid= Integer.parseInt(l2.getText());
					String booking_id = labook1.getText();
					String hotel = c1.getSelectedItem();
					String person = t1.getText();
					String days = t2.getText();
					String date = t3.getText();
					String ac = c2.getSelectedItem();
					String food = c3.getSelectedItem();
					String price = l5.getText();

					String query = "insert into bookHotel (userName,booking_id,name,person,No_Of_Days,date,ac,food,customer_id,price) values('" + username + "', '" + booking_id + "', '" + hotel + "', '" + person + "', '" + days + "', '" + date + "', '" + ac + "', '" + food + "', '" + customerid + "', '" + price + "')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
					setVisible(false);
					}
				}catch(Exception ee){
	    			System.out.println(ee.getMessage());
				}
			}
		});
		btnNewButton.setBounds(200, 500, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(350, 500, 120, 30);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
		getContentPane().setBackground(Color.WHITE);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookHotel frame = new BookHotel("");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}