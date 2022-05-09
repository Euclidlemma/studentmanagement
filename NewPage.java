import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class NewPage extends JFrame implements ActionListener{

    StudentData students;
    manager m;
    JButton login;
    JTextField id;
    JPasswordField pwdfield;
    JLabel message;
    JButton goback;
    NewPage(StudentData s, manager mng) {
        this.students = s;
        this.m = mng;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel idpanel = new JPanel();
        idpanel.setLayout(null);
        this.add(idpanel);
        this.setVisible(true);

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

        // adding goback button
        goback = new JButton("back");
        goback.setBounds(150, 245, 80, 25);
        goback.addActionListener(this);
        idpanel.add(goback);

        //let know fail of login
        message = new JLabel("");
        message.setBounds(150, 270, 300, 25);
        idpanel.add(message);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String idinput = id.getText();
            char[] pwdinput = pwdfield.getPassword();
            Student result = students.find_student(idinput, pwdinput);
            if (result != null) {
                this.dispose();
                new StudentMain(students, m, result);
            } else {
                message.setText("Wrong id or password. Try again");
            }
        } else if (e.getSource() == goback) {
            this.dispose();
            new mainframe(students, m);
        }
    }
    
}
