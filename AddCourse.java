import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class AddCourse extends JFrame implements ActionListener{
    StudentData students;
    manager man;
    JButton back;
    JButton add;
    JTextField category;
    JTextField id;
    JTextField professor;
    JTextField dates;
    AddCourse(StudentData s, manager m) {
        this.students = s;
        this.man = m;
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

        JLabel inst = new JLabel("Instructor: ");
        inst.setBounds(120, 200, 110, 25);
        mainpanel.add(inst);

        professor = new JTextField(30);
        professor.setBounds(240, 200, 80, 25);
        mainpanel.add(professor);

        JLabel date = new JLabel("Date: ");
        date.setBounds(150, 275, 150, 25);
        mainpanel.add(date);

        dates = new JTextField(30);
        dates.setBounds(240, 275, 165, 25);
        mainpanel.add(dates);
        
        add = new JButton("add");
        add.setBounds(150, 350, 80, 25);
        add.addActionListener(this);
        mainpanel.add(add);

        back = new JButton("back");
        back.setBounds(450, 350, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);
    }



    public void actionPerformed(ActionEvent e) {
        String ca = category.getText();
        String idnum = id.getText();
        int realid = 0;
        String prof = professor.getText();
        String da = dates.getText();
        if (e.getSource() == add) {
            try{
                realid = Integer.parseInt(idnum);
                students.addCourseCateg(new Course(ca, realid, prof, da));
                JOptionPane.showMessageDialog(this, "Course succesfully added", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                new AddCourse(students, man);
            }
            catch(NumberFormatException n) {
                JOptionPane.showMessageDialog(this, "Expect number as id", 
                "info", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == back) {
            this.dispose();
            new Managemain(students, man);
        }
    }

}
