import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JOptionPane;


public class Managemain extends JFrame implements ActionListener{
    StudentData students;
    manager m;
    JButton fs;
    JButton as;
    JButton confirmcourse;
    JButton back;
    JButton addcourse;
    JButton findcourse;

    Managemain(StudentData s, manager mng) {
        this.students = s;
        this.m = mng;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel mainpanel = new JPanel();
        this.add(mainpanel);
        mainpanel.setLayout(new GridLayout(2, 3, 10, 10));


        fs = new JButton("Find Student");
        fs.addActionListener(this);
        mainpanel.add(fs);

        as = new JButton("Add Student");
        as.addActionListener(this);
        mainpanel.add(as);

        confirmcourse = new JButton("Course Confirmation");
        confirmcourse.addActionListener(this);
        mainpanel.add(confirmcourse);

        addcourse = new JButton("Add Course");
        addcourse.addActionListener(this);
        mainpanel.add(addcourse);

        findcourse = new JButton("Find Course");
        findcourse.addActionListener(this);
        mainpanel.add(findcourse);

        back = new JButton("Back");
        back.addActionListener(this);
        mainpanel.add(back);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fs) {
            this.dispose();
            new findstudent(students, m);
        } else if (e.getSource() == as) {
            this.dispose();
            new addstudent(students, m);
        } else if (e.getSource() == back) {
            this.dispose();
            new ManagerLogin(students, m);
        } else if (e.getSource() == confirmcourse) {
            Student temp = m.initialize();
            if (temp == null) {
                JOptionPane.showMessageDialog(this, "There are no students in confirm queue", 
                "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.dispose();
                new CourseConfirm(students, m, temp);
            }
        } else if (e.getSource() == addcourse) {
            this.dispose();
            new AddCourse(students, m);
        } else if (e.getSource() == findcourse) {
            this.dispose();
            new FindCourse(students, m, null);
        }
    }
}
