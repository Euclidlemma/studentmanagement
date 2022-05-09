import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.util.*;

public class ChangePwd extends JFrame implements ActionListener{
    StudentData students;
    manager m;
    Student stu;
    JButton back;
    JButton change;
    JPasswordField pwdfield;
    JPasswordField conpwdfield;

    ChangePwd(StudentData s, manager mng, Student stu) {
        this.students = s;
        this.m = mng;
        this.stu = stu;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);
        this.setVisible(true);

        JLabel pwd = new JLabel("New Password: ");
        pwd.setBounds(150, 150, 80, 25);
        mainpanel.add(pwd);

        pwdfield = new JPasswordField();
        pwdfield.setBounds(240,150, 165, 25);
        mainpanel.add(pwdfield);

        JLabel conpwd = new JLabel("Confirm:");
        conpwd.setBounds(150, 180, 80, 25);
        mainpanel.add(conpwd);

        conpwdfield = new JPasswordField();
        conpwdfield.setBounds(240, 180, 165, 25);
        mainpanel.add(conpwdfield);

        back = new JButton("back");
        back.setBounds(150, 245, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        change = new JButton("Change");
        change.setBounds(150, 210, 80, 25);
        change.addActionListener(this);
        mainpanel.add(change);
    }

    public void actionPerformed(ActionEvent e) {
        char[] pwdinput = pwdfield.getPassword();
        char[] cnpwdinput = conpwdfield.getPassword();
        if (e.getSource() == back) {
            this.dispose();
            new StudentMain(students, m, stu);
        } else if (e.getSource() == change) {
            if (Arrays.equals(pwdinput, cnpwdinput)) {
                int result = JOptionPane.showConfirmDialog(this, 
                    "Are you sure you will change password?", "Confirm", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    stu.changepass(pwdinput);
                    JOptionPane.showMessageDialog(this, "Password succesfully changed", 
                "Confirm", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    
}
