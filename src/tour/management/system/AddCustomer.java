package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelUserName;
    JComboBox comboId;
    JTextField tfNumber,userid,labelName, tfCountry, tfAddress, tfEmail, tfPhoneNo;
    JRadioButton male, female;
    JButton add, back;

    public AddCustomer(String userName) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblUserName = new JLabel("UserName");
        lblUserName.setBounds(30, 50, 150, 25);
        add(lblUserName);

        labelUserName = new JLabel();
        labelUserName.setBounds(220, 50, 150, 25);
        add(labelUserName);

        JLabel lblUserId = new JLabel("User Id: ");
        lblUserId.setBounds(30, 90, 150, 25);
        add(lblUserId);

        userid = new JTextField();
        userid.setBounds(220, 90, 150, 25);
        add(userid);

        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30, 130, 150, 25);
        add(lblId);

        comboId = new JComboBox(new String[]{"Passport", "Adhar Card", "Ration Card", "Pan Card"});
        comboId.setBounds(220, 130, 150, 25);
        comboId.setBackground(Color.white);
        add(comboId);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 170, 150, 25);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220, 170, 150, 25);
        add(tfNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 210, 150, 25);
        add(lblName);

        labelName = new JTextField();
        labelName.setBounds(220, 210, 150, 25);
        add(labelName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 250, 150, 25);
        add(lblGender);

        male = new JRadioButton("Male");
        male.setBounds(220, 250, 70, 25);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(300, 250, 70, 25);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 290, 150, 25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220, 290, 150, 25);
        add(tfCountry);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 330, 150, 25);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220, 330, 150, 25);
        add(tfAddress);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 370, 150, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);

        JLabel lblPhoneNo = new JLabel("Phone Number");
        lblPhoneNo.setBounds(30, 410, 150, 25);
        add(lblPhoneNo);

        tfPhoneNo = new JTextField();
        tfPhoneNo.setBounds(220, 410, 150, 25);
        add(tfPhoneNo);

        add = new JButton("Add");
        add.setBounds(70, 460, 100, 25);
        add.setBackground(Color.black);
        add.setForeground(Color.white);

        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(240, 460, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from account where userName= '" + userName + "'");
            while (rs.next()) {
                labelUserName.setText(rs.getString("userName"));
//                labelName.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            try {
                if(labelUserName.getText().isEmpty() || userid.getText().isEmpty() || tfNumber.getText().isEmpty() || labelName.getText().isEmpty() || tfCountry.getText().isEmpty() || tfAddress.getText().isEmpty() || tfPhoneNo.getText().isEmpty()|| tfEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the Fields");
                }
                else {
                String userName = labelUserName.getText();
                int userId = (Integer.parseInt(userid.getText()));
                String identity_Name = (String) comboId.getSelectedItem();
                String identity_Number = tfNumber.getText();
                String name = labelName.getText();
                String gender = null;
                if (male.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }
                String country = tfCountry.getText();
                String address = tfAddress.getText();
                String phone = tfPhoneNo.getText();
                String email = tfEmail.getText();

                Conn c = new Conn();
                String query = "insert into customer (UserName,customer_Id, identity_Name, identity_Number, name, gender, country, address, phone, email) values('" + userName + "','" + userId + "','" + identity_Name + "','" + identity_Number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Dashboard("");
        }

    }

    public static void main(String[] args) {
        AddCustomer add = new AddCustomer("");
        add.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
