import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class addstudent extends JFrame implements ActionListener{
    StudentData students;
    manager m;
    JButton back;
    JButton add;
    JTextField name;
    JTextField sex;
    JTextField age;
    JTextField email;
    JTextField address;
    JTextField phonenumber;
    JTextField id;
    JTextField pwd;

    addstudent(StudentData s, manager mng) {
        this.students = s;
        this.m = mng;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);

        JLabel nameform = new JLabel("Name:");
        nameform.setBounds(150, 50, 80, 25);
        mainpanel.add(nameform);

        name = new JTextField(30);
        name.setBounds(240, 50, 300, 25);
        mainpanel.add(name);

        JLabel sexform = new JLabel("Sex: ");
        sexform.setBounds(150, 125, 80, 25);
        mainpanel.add(sexform);

        sex = new JTextField(30);
        sex.setBounds(240, 125, 80, 25);
        mainpanel.add(sex);

        JLabel ageform = new JLabel("Age: ");
        ageform.setBounds(150, 200, 80, 25);
        mainpanel.add(ageform);

        age = new JTextField(30);
        age.setBounds(240, 200, 80, 25);
        mainpanel.add(age);

        JLabel emailform = new JLabel("Email: ");
        emailform.setBounds(150, 275, 80, 25);
        mainpanel.add(emailform);

        email = new JTextField(30);
        email.setBounds(240, 275, 165, 25);
        mainpanel.add(email);

        JLabel addressform = new JLabel ("address: ");
        addressform.setBounds(150, 350, 80, 25);
        mainpanel.add(addressform);

        address = new JTextField(30);
        address.setBounds(240, 350, 300, 25);
        mainpanel.add(address);

        JLabel pnumberform = new JLabel("phone: ");
        pnumberform.setBounds(150, 425, 80, 25);
        mainpanel.add(pnumberform);

        phonenumber = new JTextField(30);
        phonenumber.setBounds(240, 425, 165, 25);
        mainpanel.add(phonenumber);

        JLabel idform = new JLabel("ID: ");
        idform.setBounds(150, 500, 80, 25);
        mainpanel.add(idform);

        id = new JTextField(30);
        id.setBounds(240, 500, 165, 25);
        mainpanel.add(id);

        JLabel pwdform = new JLabel("Password: ");
        pwdform.setBounds(150, 575, 80, 25);
        mainpanel.add(pwdform);

        pwd = new JTextField(30);
        pwd.setBounds(240, 575, 165, 25);
        mainpanel.add(pwd);

        back = new JButton("back");
        back.setBounds(520, 575, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        add = new JButton("add");
        add.setBounds(520, 500, 80, 25);
        add.addActionListener(this);
        mainpanel.add(add);

        this.setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {
        String sname = name.getText();
        String ssex = sex.getText();
        String sage = age.getText();
        String semail = email.getText();
        String saddress = address.getText();
        String sphonenumber = phonenumber.getText();
        String sid = id.getText();
        String spwd = pwd.getText();
        if (e.getSource() == add) {
            if (!sname.isEmpty() && !ssex.isEmpty() && !sage.isEmpty() && !semail.isEmpty()
            && !saddress.isEmpty() && !sphonenumber.isEmpty() && !sid.isEmpty() && !spwd.isEmpty()) {
                students.addstudent(new Student(sname, ssex, sage, semail, saddress, sphonenumber, sid, spwd));
                JOptionPane.showMessageDialog(this, "Student succesfully added", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new Managemain(students, m);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in the empty parts", 
                "Empty field", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == back) {
            if (!sname.isEmpty() && !ssex.isEmpty() && !sage.isEmpty() && !semail.isEmpty()
            && !saddress.isEmpty() && !sphonenumber.isEmpty() && !sid.isEmpty() && !spwd.isEmpty()) {
                int result = JOptionPane.showConfirmDialog(this, 
                    "Your changes will not be saved. Are you sure you want to quit?", "Confirm", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    this.dispose();
                    new Managemain(students, m);
                }
            } else {
                this.dispose();
                new Managemain(students, m);
            } 
        }
    }
}
