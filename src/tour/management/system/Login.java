package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, forgetPasswd;
    JTextField tfUserName;
    JPasswordField tfPasswd;

    public Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white); // get Content pane yae humre pure panel ko lega or uska color change krr dega

        JPanel p1 = new JPanel();
        //p1.setBackground(Color.white); //we can use it with normal Color.colour name
        p1.setBackground(new Color(131, 193, 233)); //But if we want it on RGB format then we have to call the constructor of color class then put the rgb values
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null); // jab tak me ise null nhi krunga to tab tak vo set bounds function ko nhi use karega
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
//        add(image);  //It will add the image into the frame not in pamel
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblUserName = new JLabel("Username");
        lblUserName.setBounds(60, 20, 100, 25);
        lblUserName.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(60, 60, 300, 30);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUserName);

        JLabel lblPasswd = new JLabel("Password");
        lblPasswd.setBounds(60, 110, 100, 25);
        lblPasswd.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblPasswd);

        tfPasswd = new JPasswordField();
        tfPasswd.setBounds(60, 150, 300, 30);
        tfPasswd.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPasswd);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
//        login.setBackground(new Color(133,193,233));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("SAN SERIF", Font.BOLD, 15));
//        login.setBorder(new LineBorder(Color.red));  //IT is to give the border color

        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.setFont(new Font("SAN SERIF", Font.BOLD, 15));

        signup.addActionListener(this);
        p2.add(signup);

        forgetPasswd = new JButton("Forget Password ?");
        forgetPasswd.setBounds(130, 250, 180, 30);
        forgetPasswd.setForeground(Color.red);
        forgetPasswd.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        forgetPasswd.setBorder(BorderFactory.createEmptyBorder());
        forgetPasswd.setFocusable(true);
        forgetPasswd.setContentAreaFilled(false);

        forgetPasswd.addActionListener(this);
        p2.add(forgetPasswd);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                PasswdEncryptionAndDecryption p = new PasswdEncryptionAndDecryption();
                String userName = tfUserName.getText();
                String encrPasswd=p.encode(tfPasswd.getText());
                String query = "Select * from account where userName = '" + userName + "' AND passwd = '" + encrPasswd + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(userName);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect UserName or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == forgetPasswd) {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        Login l = new Login();
        l.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}