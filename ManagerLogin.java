import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ManagerLogin extends JFrame implements ActionListener{
    StudentData students;
    JButton login;
    JTextField id;
    JPasswordField pwdfield;
    JLabel message;
    JButton goback;
    manager m;
    ManagerLogin (StudentData s, manager mng) {
        this.students = s;
        this.m = mng;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel idpanel = new JPanel();
        idpanel.setLayout(null);
        this.add(idpanel);

        // user id
        JLabel label = new JLabel("User");
        label.setBounds(150, 150, 80, 25);
        idpanel.add(label);


        // new text field
        id = new JTextField(20);
        id.setBounds(240,150, 165, 25);
        idpanel.add(id);

        JLabel pwd = new JLabel("Password");
        pwd.setBounds(150, 180, 80, 25);
        idpanel.add(pwd);

        // add password field
        pwdfield = new JPasswordField();
        pwdfield.setBounds(240, 180, 165, 25);
        idpanel.add(pwdfield);

        // adding login button
        login = new JButton("Login");
        login.setBounds(150, 210, 80, 25);
        login.addActionListener(this);
        idpanel.add(login);

        //let know fail of login
        message = new JLabel("");
        message.setBounds(150, 270, 300, 25);
        idpanel.add(message);

        // adding goback button
        goback = new JButton("back");
        goback.setBounds(150, 245, 80, 25);
        goback.addActionListener(this);
        idpanel.add(goback);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String idinput = id.getText();
            char[] pwdinput = pwdfield.getPassword();
            if ((idinput.equals("waterloomanager")) && ((new String(pwdinput)).equals("wm123"))) {
                this.dispose();
                new Managemain(students, m);
            } else {
                message.setText("Wrong id or password. Try again");
            }
        } else if (e.getSource() == goback) {
            this.dispose();
            new mainframe(students, m);
        }
    }
    
}
