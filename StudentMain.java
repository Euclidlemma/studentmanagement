import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;



public class StudentMain extends JFrame implements ActionListener{
    StudentData students;
    manager m;
    Student stu;
    JButton Changepassword;
    JButton profile;
    JButton back;
    JButton addcourse;
    JButton checkcourse;

    StudentMain(StudentData s, manager mng, Student stu) {
        this.students = s;
        this.m = mng;
        this.stu = stu;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel mainpanel = new JPanel();
        this.add(mainpanel);
        this.setVisible(true);
        mainpanel.setLayout(new GridLayout(2, 3, 10, 10));

        Changepassword = new JButton("Change Password");
        Changepassword.addActionListener(this);
        mainpanel.add(Changepassword);

        profile = new JButton("Check profile");
        profile.addActionListener(this);
        mainpanel.add(profile);

        addcourse = new JButton("Add Course");
        addcourse.addActionListener(this);
        mainpanel.add(addcourse);

        checkcourse = new JButton("Check applied courses");
        checkcourse.addActionListener(this);
        mainpanel.add(checkcourse);

        back = new JButton("back");
        back.addActionListener(this);
        mainpanel.add(back);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Changepassword) {
            this.dispose();
            new ChangePwd(students, m, stu);
        } else if (e.getSource() == profile) {
            this.dispose();
            new studentinfo(0, students, m, stu);
        } else if (e.getSource() == back) {
            this.dispose();
            new NewPage(students, m);
        } else if (e.getSource() == addcourse) {
            this.dispose();
            new FindCourse(students, m, stu);
        } else if (e.getSource() == checkcourse) {
            this.dispose();
            new CheckCourse(students, m, stu);
        } else if (e.getSource() == back) {
            this.dispose();
            new NewPage(students, m);
        }
    }
}
