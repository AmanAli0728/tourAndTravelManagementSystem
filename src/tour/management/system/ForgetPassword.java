package tour.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfUserName, tfName, tfSecurity, tfAnswer, tfPasswd;
    JButton search, retrieve, back;

    public ForgetPassword() {
        //1.Creating the frame for forget password
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(new Color(131, 193, 233));
        setLayout(null);

        //2.Adding image to the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/forget.jpg"));
        Image i2 = i1.getImage().getScaledInstance(260, 260, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560, 50, 250, 250);
        add(image);

        //3.Creating panel for the labels,text-field and buttons
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lblUserName = new JLabel("Username");
        lblUserName.setBounds(40, 20, 100, 25);
        lblUserName.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblUserName);

        tfUserName = new JTextField();
        tfUserName.setBounds(200, 20, 150, 25);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUserName);

        search = new JButton("Search");
        search.setBounds(380, 20, 100, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);

        search.addActionListener(this);
        p1.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblname);

        tfName = new JTextField();
        tfName.setBounds(200, 60, 150, 25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setBounds(40, 100, 150, 25);
        lblSecurity.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblSecurity);

        tfSecurity = new JTextField();
        tfSecurity.setBounds(200, 100, 150, 25);
        tfSecurity.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfSecurity);

        JLabel lblAnswer = new JLabel(" Answer");
        lblAnswer.setBounds(40, 140, 150, 25);
        lblAnswer.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(200, 140, 150, 25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.setBackground(Color.black);
        retrieve.setForeground(Color.white);

        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblPasswd = new JLabel(" Password");
        lblPasswd.setBounds(40, 180, 150, 25);
        lblPasswd.setFont(new Font("SEN SERIF", Font.PLAIN, 14));
        p1.add(lblPasswd);

        tfPasswd = new JTextField();
        tfPasswd.setBounds(200, 180, 150, 25);
        tfPasswd.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPasswd);

        back = new JButton("Back");
        back.setBounds(150, 230, 100, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);

        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                String query = "Select * from account where username = '" + tfUserName.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfSecurity.setText(rs.getString("security"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == retrieve) {
            try {
                PasswdEncryptionAndDecryption p = new PasswdEncryptionAndDecryption();
                String query = "Select * from account where answer = '" + tfAnswer.getText() + "' AND userName= '" + tfUserName.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query); //ye hume kux output dega or vo output hum ResultSet rs object mae store karayenge or ResultSet humra java.sql.* package mae hota hae
                while (rs.next()) {
                    String decrPasswd=rs.getString("passwd");
                    tfPasswd.setText(p.decode(decrPasswd));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        ForgetPassword fp = new ForgetPassword();
        fp.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}