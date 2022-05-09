import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;



public class CourseConfirm extends JFrame implements ActionListener {
    StudentData students;
    manager m;
    JButton back;
    JButton next;
    JButton confirm1;
    JButton confirm2;
    JButton confirm3;
    JButton confirm4;
    JButton confirm5;
    JButton quit;
    Student stu;
    int cn;

    CourseConfirm(StudentData s, manager mng, Student current) {
        this.students = s;
        this.m = mng;
        this.stu = current;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 700);
        JPanel mainpanel = new JPanel();
        this.add(mainpanel);
        mainpanel.setLayout(null);

        JLabel nameform = new JLabel("Name:");
        nameform.setBounds(150, 50, 80, 25);
        mainpanel.add(nameform);

        JLabel name = new JLabel(current.getname());
        name.setBounds(240, 50, 300, 25);
        mainpanel.add(name);

        JLabel idform = new JLabel("ID: ");
        idform.setBounds(150, 125, 80, 25);
        mainpanel.add(idform);

        JLabel id = new JLabel(current.getid());
        id.setBounds(240, 125, 165, 25);
        mainpanel.add(id);

        back = new JButton("back");
        back.setBounds(100, 500, 100, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        next = new JButton("Next");
        next.setBounds(500, 500, 100, 25);
        next.addActionListener(this);
        mainpanel.add(next);

        quit = new JButton("quit");
        quit.setBounds(300, 600, 100, 25);
        quit.addActionListener(this);
        mainpanel.add(quit);

        

        // print courses
        JLabel course = new JLabel("Courses: ");
        course.setBounds(150, 200, 80, 25);
        mainpanel.add(course);

        cn = current.coursenum();
        if (cn >= 1) {
            JLabel first = new JLabel(current.retc(0).getCourseName());
            first.setBounds(275, 230, 100, 25);
            mainpanel.add(first);

            confirm1 = new JButton("confirm");
            confirm1.setBounds(400, 230,80, 25);
            confirm1.addActionListener(this);
            mainpanel.add(confirm1);
        }
        if (cn >= 2) {
            JLabel second = new JLabel(current.retc(1).getCourseName());
            second.setBounds(275, 260, 100, 25);
            mainpanel.add(second);

            confirm2 = new JButton("confirm");
            confirm2.setBounds(400, 260,80, 25);
            confirm2.addActionListener(this);
            mainpanel.add(confirm2);
        }
        if (cn >= 3)  {
            JLabel third = new JLabel(current.retc(2).getCourseName());
            third.setBounds(275, 290, 100, 25);
            mainpanel.add(third);

            confirm3 = new JButton("confirm");
            confirm3.setBounds(400, 290,80, 25);
            confirm3.addActionListener(this);
            mainpanel.add(confirm3);
        }
        if (cn >= 4) {
            JLabel fourth = new JLabel(current.retc(3).getCourseName());
            fourth.setBounds(275, 320, 100, 25);
            mainpanel.add(fourth);

            confirm4 = new JButton("confirm");
            confirm4.setBounds(400, 320,80, 25);
            confirm4.addActionListener(this);
            mainpanel.add(confirm4);
        } 
        if (cn >= 5) {
            JLabel fifth = new JLabel(current.retc(4).getCourseName());
            fifth.setBounds(275, 350, 100, 25);
            mainpanel.add(fifth);

            confirm5 = new JButton("confirm");
            confirm5.setBounds(400, 350,80, 25);
            confirm5.addActionListener(this);
            mainpanel.add(confirm5);
        }





        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            Student tempb = m.back();
            if (tempb == null) {
                JOptionPane.showMessageDialog(this, "You are in the first place of the queue", 
                "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.dispose();
                new CourseConfirm(students, m, tempb);
            }
        } else if (e.getSource() == next) {
            Student tempn = m.next();
            if (tempn == null) {
                JOptionPane.showMessageDialog(this, "You are in the last place of the queue", 
                "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.dispose();
                new CourseConfirm(students, m, tempn);
            }
        } else if (e.getSource() == quit) {
            this.dispose();
            new Managemain(students, m);
        } else if (e.getSource() == confirm1) {
            confirm_course(0);
        }else if (e.getSource() == confirm2) {
            confirm_course(1);
        } else if (e.getSource() == confirm3) {
            confirm_course(2);
        } else if (e.getSource() == confirm4) {
            confirm_course(3);
        } else if (e.getSource() == confirm5) {
            confirm_course(4);
        }
    }

    void student_confirm() {
        if (!m.confirmcourse(stu)) {
            JOptionPane.showMessageDialog(this, "There are no leftover students in queue. Return to main menu", 
        "info", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        new Managemain(students, m);
        } else {
            this.dispose();
            new CourseConfirm(students, m, m.current());
        }
    }

    void confirm_course(int index) {
        stu.courseconfirmed(index);
            JOptionPane.showMessageDialog(this, "Student course confirmed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
            if (stu.coursenum() == 0) {
                JOptionPane.showMessageDialog(this, "All Courses under this student are confirmed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                student_confirm();
            } else {
                this.dispose();
                new CourseConfirm(students, m, stu);
            }
        }
    }
