import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class makeaccount extends JFrame implements ActionListener {
    StudentData students;
    JButton create;
    JButton goback;
    JTextField id;
    JPasswordField pwdfield;
    JLabel message;

    makeaccount(StudentData s) {
        this.students = s;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel makepanel = new JPanel();
        makepanel.setLayout(null);
        this.add(makepanel);

        // add instructions
        message = new JLabel("Insert new id and password");
        message.setBounds(150, 110, 80, 25);
        makepanel.add(message);

        // add user label
        JLabel label = new JLabel("User");
        label.setBounds(150, 150, 80, 25);
        makepanel.add(label);

        //add user input
        id = new JTextField(20);
        id.setBounds(240,150, 165, 25);
        makepanel.add(id);

        //add pwd label
        JLabel pwd = new JLabel("Password");
        pwd.setBounds(150, 180, 80, 25);
        makepanel.add(pwd);

        // add password field
        pwdfield = new JPasswordField();
        pwdfield.setBounds(240, 180, 165, 25);
        makepanel.add(pwdfield);

        // adding create button
        create = new JButton("create!");
        create.setBounds(150, 210, 80, 25);
        create.addActionListener(this);
        makepanel.add(create);

         // adding goback button
         goback = new JButton("Back");
         goback.setBounds(325, 210, 80, 25);
         goback.addActionListener(this);
         makepanel.add(goback);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create) {
            
        }


    }
}
