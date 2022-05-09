import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckCourse extends JFrame implements ActionListener {
    StudentData students;
    manager m;
    Student stu;
    JButton back;

    CheckCourse(StudentData s, manager mng, Student stu) {
        this.students = s;
        this.m = mng;
        this.stu = stu;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 800);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);

        JLabel appliedlist = new JLabel("Applied Lists");
        appliedlist.setBounds(100, 50, 80, 25);
        mainpanel.add(appliedlist);

        int cn = stu.coursenum();
        if (cn >= 1) {
            JLabel first = new JLabel(stu.retc(0).getCourseName());
            first.setBounds(100, 100, 100, 25);
            mainpanel.add(first);
        }
        if (cn >= 2) {
            JLabel second = new JLabel(stu.retc(1).getCourseName());
            second.setBounds(100, 150, 100, 25);
            mainpanel.add(second);
        }
        if (cn >= 3)  {
            JLabel third = new JLabel(stu.retc(2).getCourseName());
            third.setBounds(100, 200, 100, 25);
            mainpanel.add(third);
        }
        if (cn >= 4) {
            JLabel fourth = new JLabel(stu.retc(3).getCourseName());
            fourth.setBounds(100, 250, 100, 25);
            mainpanel.add(fourth);
        } 
        if (cn >= 5) {
            JLabel fifth = new JLabel(stu.retc(4).getCourseName());
            fifth.setBounds(100, 300, 100, 25);
            mainpanel.add(fifth);
        }

        JLabel confirmedlist = new JLabel("Confirmed List");
        confirmedlist.setBounds(100, 350, 100, 25);
        mainpanel.add(confirmedlist);
        
        cn = stu.appliedcn();

        if (cn >= 1) {
            JLabel first = new JLabel(stu.retcc(0).getCourseName());
            first.setBounds(100, 400, 100, 25);
            mainpanel.add(first);
        }
        if (cn >= 2) {
            JLabel second = new JLabel(stu.retcc(1).getCourseName());
            second.setBounds(100, 450, 100, 25);
            mainpanel.add(second);
        }
        if (cn >= 3)  {
            JLabel third = new JLabel(stu.retcc(2).getCourseName());
            third.setBounds(100, 500, 100, 25);
            mainpanel.add(third);
        }
        if (cn >= 4) {
            JLabel fourth = new JLabel(stu.retcc(3).getCourseName());
            fourth.setBounds(100, 550, 100, 25);
            mainpanel.add(fourth);
        } 
        if (cn >= 5) {
            JLabel fifth = new JLabel(stu.retcc(4).getCourseName());
            fifth.setBounds(100, 600, 100, 25);
            mainpanel.add(fifth);
        }

        back = new JButton("back");
        back.setBounds(100, 650, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
            new StudentMain(students, m, stu);
        }
    }
}
