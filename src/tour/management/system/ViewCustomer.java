package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back, search;
    JTextField tfId;
    JLabel labelId,labelName,labelNumber,labelGender,labelCountry,labelPhone,labelEmail,labelAddress;
    String userName;
    ViewCustomer(String userName){
        this.userName=userName;
        setBounds(450,200,870,625);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblCustomerId = new JLabel("Customer Id");
        lblCustomerId.setBounds(30, 50, 100, 25);
        add(lblCustomerId);

        tfId = new JTextField();
        tfId.setBounds(150, 50, 150, 25);
        add(tfId);

        search = new JButton("Search");
        search.setBounds(330, 50, 100, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);

        search.addActionListener(this);
        add(search);

        JLabel lblId= new JLabel("Id");
        lblId.setBounds(30,100,150,25);
        add(lblId);

        labelId= new JLabel();
        labelId.setBounds(220,100,150,25);
        add(labelId);

        JLabel lblNumber= new JLabel("Number");
        lblNumber.setBounds(30,150,150,25);
        add(lblNumber);

        labelNumber= new JLabel();
        labelNumber.setBounds(220,150,150,25);
        add(labelNumber);

        JLabel lblName= new JLabel("Name");
        lblName.setBounds(30,200,150,25);
        add(lblName);

        labelName= new JLabel();
        labelName.setBounds(220,200,150,25);
        add(labelName);

        JLabel lblGender= new JLabel("Gender");
        lblGender.setBounds(30,250,150,25);
        add(lblGender);

        labelGender= new JLabel();
        labelGender.setBounds(220,250,150,25);
        add(labelGender);

        JLabel lblCountry= new JLabel("Country");
        lblCountry.setBounds(500,50,150,25);
        add(lblCountry);

        labelCountry= new JLabel();
        labelCountry.setBounds(690,50,150,25);
        add(labelCountry);

        JLabel lblPhone= new JLabel("Phone");
        lblPhone.setBounds(500,100,150,25);
        add(lblPhone);

        labelPhone= new JLabel();
        labelPhone.setBounds(690,100,150,25);
        add(labelPhone);

        JLabel lblEmail= new JLabel("Email");
        lblEmail.setBounds(500,150,150,25);
        add(lblEmail);

        labelEmail= new JLabel();
        labelEmail.setBounds(690,150,150,25);
        add(labelEmail);

        JLabel lblAddress= new JLabel("Address");
        lblAddress.setBounds(500,200,150,25);
        add(lblAddress);

        labelAddress= new JLabel();
        labelAddress.setBounds(690,200,150,25);
        add(labelAddress);

        back = new JButton("Back");
        back .setBounds(350,350,100,25 );
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back .addActionListener(this);
        add(back);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(600,400,600,200);
        add(image2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            setVisible(false);
        }
        if(ae.getSource()==search){
            try{
                Conn c = new Conn();
                int customer_id = Integer.parseInt(tfId.getText());
                String query="select * from customer where customer_Id = '"+customer_id+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    labelId.setText(rs.getString("identity_Name"));
                    labelNumber.setText(rs.getString("identity_Number"));
                    labelName.setText(rs.getString("name"));
                    labelGender.setText(rs.getString("gender"));
                    labelCountry.setText(rs.getString("country"));
                    labelPhone.setText(rs.getString("phone"));
                    labelEmail.setText(rs.getString("email"));
                    labelAddress.setText(rs.getString("address"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ViewCustomer view = new ViewCustomer("");
        view.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
