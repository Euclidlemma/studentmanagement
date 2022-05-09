import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class studentinfo extends JFrame implements ActionListener{
    Student s;
    StudentData students;
    manager m;
    JButton back;
    JButton remove;
    JButton modify;
    int index;

    // following boolean indicates whether the constructor called by manager or student
    boolean fromstu;
    studentinfo(int stu, StudentData sd, manager man, Student s) {
        this.index = stu;
        if (s == null) {
            fromstu = false;
            this.s = sd.getStudent(stu);
        } else {
            this.s = s;
            fromstu = true;
        }
        this.students = sd;
        this.m = man;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);

        JLabel nameform = new JLabel("Name:");
        nameform.setBounds(150, 50, 80, 25);
        mainpanel.add(nameform);

        JLabel name = new JLabel(this.s.getname());
        name.setBounds(240, 50, 300, 25);
        mainpanel.add(name);

        JLabel sexform = new JLabel("Sex: ");
        sexform.setBounds(150, 125, 80, 25);
        mainpanel.add(sexform);

        JLabel sex = new JLabel(this.s.getsex());
        sex.setBounds(240, 125, 80, 25);
        mainpanel.add(sex);

        JLabel ageform = new JLabel("Age: ");
        ageform.setBounds(150, 200, 80, 25);
        mainpanel.add(ageform);

        JLabel age = new JLabel(this.s.getage());
        age.setBounds(240, 200, 80, 25);
        mainpanel.add(age);

        JLabel emailform = new JLabel("Email: ");
        emailform.setBounds(150, 275, 80, 25);
        mainpanel.add(emailform);

        JLabel email = new JLabel(this.s.getemail());
        email.setBounds(240, 275, 165, 25);
        mainpanel.add(email);

        JLabel addressform = new JLabel ("address: ");
        addressform.setBounds(150, 350, 80, 25);
        mainpanel.add(addressform);

        JLabel address = new JLabel(this.s.getaddress());
        address.setBounds(240, 350, 300, 25);
        mainpanel.add(address);

        JLabel pnumberform = new JLabel("phone number: ");
        pnumberform.setBounds(150, 425, 80, 25);
        mainpanel.add(pnumberform);

        JLabel phonenumber = new JLabel(this.s.getphonenumber());
        phonenumber.setBounds(240, 425, 165, 25);
        mainpanel.add(phonenumber);

        JLabel idform = new JLabel("ID: ");
        idform.setBounds(150, 500, 80, 25);
        mainpanel.add(idform);

        JLabel id = new JLabel(this.s.getid());
        id.setBounds(240, 500, 165, 25);
        mainpanel.add(id);

        back = new JButton("back");
        back.setBounds(150, 550, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        if (s == null) {
            remove = new JButton("Remove Student");
            remove.setBounds(370, 550, 80, 25);
            remove.addActionListener(this);
            mainpanel.add(remove);
        } else {
            modify = new JButton("Modify info");
            modify.setBounds(370, 550, 80, 25);
            modify.addActionListener(this);
            mainpanel.add(modify);
        }
        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            if (!fromstu) {
                this.dispose();
                new findstudent(students, m);
            } else {
                this.dispose();
                new StudentMain(students, m, s);
            }
        } else if (e.getSource() == remove) {
            int result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this student?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                students.remove_student(index);
                JOptionPane.showMessageDialog(this, "Student succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource() == modify) {
            this.dispose();
            new ModStudent(students, m, s);
        }
    }

}
