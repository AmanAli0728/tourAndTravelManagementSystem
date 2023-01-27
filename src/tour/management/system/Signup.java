package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton create, back; // hume inhe globally define karna padega kyu ki yae constructor kae andr hae or inka scope constructor kae bahar nhi hae
    JTextField  tfUserName, tfName, tfPasswd, tfAnswer;
    Choice security;

    Signup() {
        //we have to create frame so use the set size but in this i will crate frame using setBounds
        //setBounds is the combination of setSze and setLocation
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setLayout(null);
        p1.setBounds(0, 0, 500, 422);
        add(p1);

        JLabel lblUserName = new JLabel("Username");
        lblUserName.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        lblUserName.setBounds(50, 20, 125, 25);
        p1.add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(190, 20, 180, 25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        lblName.setBounds(50, 60, 125, 25);
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(190, 60, 180, 25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblPasswd = new JLabel("Password");
        lblPasswd.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        lblPasswd.setBounds(50, 100, 125, 25);
        p1.add(lblPasswd);

        tfPasswd = new JTextField();
        tfPasswd.setBounds(190, 100, 180, 25);
        tfPasswd.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPasswd);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        lblSecurity.setBounds(50, 140, 125, 25);
        p1.add(lblSecurity);


        security = new Choice();
        security.add("In what city were you born?");
        security.add("What is the name of your favorite pet?");
        security.add("What was your favorite food?");
        security.add("What is your date of birth?");
        security.select("In what city were you born?");
        security.setBounds(190, 140, 180, 25);
        p1.add(security);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        lblAnswer.setBounds(50, 180, 125, 25);
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(190, 180, 180, 25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        create = new JButton("Create");
        create.setBounds(80, 250, 100, 30);
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setFont(new Font("SEN SERIF", Font.PLAIN, 14));

        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(250, 250, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setFont(new Font("SEN SERIF", Font.PLAIN, 14));

        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); //jo jlabel  ka constructor hota hae vo icon kae object ko accept krta hae par image kae object ko nhi karta
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            try {
                PasswdEncryptionAndDecryption p = new PasswdEncryptionAndDecryption();
                String userName = tfUserName.getText();
                String name = tfName.getText();

                String question = security.getSelectedItem();
                String answer = tfAnswer.getText();
                String encrPasswd=p.encode(tfPasswd.getText());

                if(tfUserName.getText().isEmpty() || tfName.getText().isEmpty() || tfAnswer.getText().isEmpty()|| tfPasswd.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the Fields");
                }
                else{
                    String query = "insert into account (userName,name,passwd,security,answer) values('" + userName + "','" + name + "','" + encrPasswd + "','" + question + "','" + answer + "')";
                    Conn c = new Conn();
                    //my sql query hum execute kartae hae with the help of statement
                    c.s.executeUpdate(query); //agr query successful run hoti hae to hume yha par eak pop up dhikhana hae or vo hum Joption pane sae kar sakte hae
                    JOptionPane.showMessageDialog(null, "Account Created Successfully"); //first argument is formatting
                    setVisible(false);
                    new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false); //hume signup frame band kar dena hae or login frame kholna hae
            new Login();
        }
    }

    public static void main(String[] args) {
        Signup su = new Signup();
        su.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}