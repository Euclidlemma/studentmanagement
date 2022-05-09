import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class FindCourse extends JFrame implements ActionListener{
    StudentData students;
    manager man;
    JButton back;
    JButton find;
    JTextField category;
    JTextField id;
    Student student;
    // ms indicates whether this function is called by student or manager
    FindCourse(StudentData s, manager m, Student stu) {
        this.students = s;
        this.man = m;
        this.student = stu;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);
        this.setVisible(true);


        JLabel categ = new JLabel("Category:");
        categ.setBounds(150, 50, 80, 25);
        mainpanel.add(categ);

        category = new JTextField(30);
        category.setBounds(240, 50, 300, 25);
        mainpanel.add(category);

        JLabel idform = new JLabel("ID: ");
        idform.setBounds(150, 125, 80, 25);
        mainpanel.add(idform);

        id = new JTextField(30);
        id.setBounds(240, 125, 80, 25);
        mainpanel.add(id);

        find = new JButton("find");
        find.setBounds(150, 350, 80, 25);
        find.addActionListener(this);
        mainpanel.add(find);

        back = new JButton("back");
        back.setBounds(450, 350, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);


    }

    public void actionPerformed(ActionEvent e) {
        String ca = category.getText();
        String idnum = id.getText();
        int realid = 0;
        if (e.getSource() == find) {
            try{
                ArrayList<Course> temp = students.findCourse(ca);
                if (idnum.isEmpty()) {
                    if (temp == null) {
                        JOptionPane.showMessageDialog(this, "Unappropriate coursecategory", 
                            "info", JOptionPane.ERROR_MESSAGE);
                    } else {
                        this.dispose();
                        new CoursesScreen(students, man, temp, null, student);
                    }
                } else{
                    if (temp == null) {
                        JOptionPane.showMessageDialog(this, "Unappropriate coursecategory", 
                            "info", JOptionPane.ERROR_MESSAGE);
                    } else {
                        realid = Integer.parseInt(idnum);
                        Course c = students.findCourse(realid, 0, temp.size()-1, temp);
                        if (c == null) {
                            JOptionPane.showMessageDialog(this, "Course does not exist", 
                            "info", JOptionPane.ERROR_MESSAGE);
                        } else {
                            this.dispose();
                            new CoursesScreen(students, man, temp, c, student);
                        }
                    }

                }
            }
            catch(NumberFormatException n) {
                JOptionPane.showMessageDialog(this, "Expect number as id", 
                "info", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == back) {
            this.dispose();
            if (student == null) {
                new Managemain(students, man);
            } else {
                new StudentMain(students, man, student);
            }
        }
    }
}
