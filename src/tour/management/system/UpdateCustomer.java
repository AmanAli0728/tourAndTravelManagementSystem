package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelUserName, labelName;
    JComboBox comboId;
    JTextField tfNumber, tfCountry, tfAddress, tfEmail, tfPhoneNo,customerId, tfId, tfGender;
    JButton search,update, back;
    String userName;
    public UpdateCustomer(String userName) {
        this.userName=userName;
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Update Customer Details");
        heading.setBounds(50, 0, 300, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblUserName = new JLabel("UserName");
        lblUserName.setBounds(30, 50, 150, 25);
        add(lblUserName);

        labelUserName = new JLabel();
        labelUserName.setText(userName);
        labelUserName.setBounds(220, 50, 150, 25);
        add(labelUserName);

        JLabel UserId = new JLabel("Customer ID: ");
        UserId.setBounds(30, 90, 100, 25);
        add(UserId);

        customerId = new JTextField();
        customerId.setBounds(220, 90, 150, 25);
        add(customerId);

        search = new JButton("Search");
        search.setBounds(400, 90, 100, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);

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

        labelName = new JLabel();
        labelName.setBounds(220, 210, 150, 25);
        add(labelName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 250, 150, 25);
        add(lblGender);

        tfGender = new JTextField();
        tfGender.setBounds(220, 250, 150, 25);
        add(tfGender);


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
        lblPhoneNo.setBounds(30, 430, 150, 25);
        add(lblPhoneNo);

        tfPhoneNo = new JTextField();
        tfPhoneNo.setBounds(220, 430, 150, 25);
        add(tfPhoneNo);

        update = new JButton("Update");
        update.setBounds(70, 470, 100, 25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);

        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(240, 470, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(440, 80, 350, 350);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            try {
                String userName = labelUserName.getText();
                String id = (String) comboId.getSelectedItem();
                String number = tfNumber.getText();
                String name = labelName.getText();
                String gender = tfGender.getText();
                String country = tfCountry.getText();
                String address = tfAddress.getText();
                String phone = tfPhoneNo.getText();
                String email = tfEmail.getText();

                if(labelUserName.getText().isEmpty() || ((String) comboId.getSelectedItem()).isEmpty()|| tfNumber.getText().isEmpty() || labelName.getText().isEmpty() || gender.isEmpty()|| country.isEmpty() || address.isEmpty() || phone.isEmpty()|| email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the Fields");
                }
                else {
                    Conn c = new Conn();
                    String query = "Update customer set userName ='" + userName + "', identity_Name ='" + id + "',identity_Number ='" + number + "',name ='" + name + "',gender ='" + gender + "',country ='" + country + "',address ='" + address + "',phone ='" + phone + "',email ='" + email + "'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        } else if (ae.getSource() == search) {
            try {
                String query = "Select * from customer where customer_Id = '" + customerId.getText() + "' and username = '" + userName + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs.next()) {
                    labelUserName.setText(rs.getString("userName"));
                    comboId.setSelectedItem(rs.getString("identity_Name"));
                    tfNumber.setText(rs.getString("identity_Number"));
                    labelName.setText(rs.getString("name"));
                    tfGender.setText(rs.getString("gender"));
                    tfCountry.setText(rs.getString("country"));
                    tfAddress.setText(rs.getString("address"));
                    tfEmail.setText(rs.getString("email"));
                    tfPhoneNo.setText(rs.getString("phone"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        UpdateCustomer up = new UpdateCustomer("");
        up.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


