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

public class BookPackage extends JFrame {
	JPanel contentPane;
	JTextField t1,t2,t3,t4;
	Choice c1,c2,c3;

	public BookPackage(String username) {
		setBounds(450, 200, 1100, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel la1 = new JLabel(i2);
		la1.setBounds(450,50,700,300);
		add(la1);
		
		JLabel lblName = new JLabel("BOOK PACKAGE");
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
                
		JLabel lblId = new JLabel("Select Package :");
		lblId.setBounds(35, 150, 200, 14);
		contentPane.add(lblId);
                
		c1 = new Choice();
		c1.add("CharDham Package");
		c1.add("Honeymoon Package");
		c1.add("Family Package");
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

		JLabel la4 = new JLabel("No of Days");
		la4.setBounds(35, 230, 200, 14);
		contentPane.add(la4);

		t3 = new JTextField();
		t3.setText("6");
		t3.setBounds(271, 230, 150, 20);
		contentPane.add(t3);
		t3.setColumns(10);

		JLabel la5 = new JLabel("Date");
		la5.setBounds(35, 270, 200, 14);
		contentPane.add(la5);

		t4 = new JTextField();
		t4.setText(String.valueOf(java.time.LocalDate.now()));
		t4.setBounds(271, 270, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                
		JLabel lbl1 = new JLabel("Customer ID :");
		lbl1.setBounds(35, 310, 200, 14);
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
				String p = c1.getSelectedItem();
				int cost = 0;
				if(p.equals("CharDham Package")) {
					cost += 1200 * Integer.parseInt(t3.getText())* Integer.parseInt(t1.getText());
				}if(p.equals("Honeymoon Package")){
					cost += 2500 * Integer.parseInt(t3.getText())* Integer.parseInt(t1.getText());
				}else if(p.equals("Family Package")){
					cost += 3200 * Integer.parseInt(t3.getText())* Integer.parseInt(t1.getText());
				}
                            
				cost *= Integer.parseInt(t1.getText());
				l5.setText("Rs "+cost);
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
					if(t1.getText().isEmpty() || t4.getText().isEmpty() || t3.getText().isEmpty()|| l2.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Please fill all the Fields");
					}
					else {
					String pack = c1.getSelectedItem();
					int booking_id = Integer.parseInt(labook1.getText());
					int person = Integer.parseInt(t1.getText());
					int days = Integer.parseInt(t3.getText());
					String date = t4.getText();
					int customer_id = Integer.parseInt(l2.getText());
					String price = l5.getText();
					String q1 = "insert into bookPackage (userName,booking_id,package,persons,No_Of_Days,date,customer_id,price) values('" + username + "', '" + booking_id + "', '" + pack + "', '" + person + "', '" + days + "', '" + date + "', '" + customer_id + "', '" + price + "')";
					c.s.executeUpdate(q1);
					JOptionPane.showMessageDialog(null, "Package Booked Successfully");
					setVisible(false);
					}
				}catch(Exception ee){
	    			ee.printStackTrace();
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
					BookPackage frame = new BookPackage("");
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}