import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class findstudent extends JFrame implements ActionListener{
    StudentData students;
    manager m;
    JButton back; 
    JButton search;
    JTextField id;
    JLabel message;

    findstudent(StudentData s, manager man) {
        this.students = s;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        JPanel mainpanel = new JPanel();
        this.add(mainpanel);

        JLabel label = new JLabel("Studnet id");
        label.setBounds(150, 150, 80, 25);
        mainpanel.add(label);

        id = new JTextField(20);
        id.setBounds(240,150, 165, 25);
        mainpanel.add(id);

        message = new JLabel("");
        message.setBounds(150, 270, 300, 25);
        mainpanel.add(message);

        search = new JButton("Search");
        search.setBounds(150, 210, 80, 25);
        search.addActionListener(this);
        mainpanel.add(search);

        back = new JButton("back");
        back.setBounds(150, 245, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String idinput = id.getText();
            int found = students.find_student_id(idinput);
            if (found != -1) {
                this.dispose();
                new studentinfo(found, students, m, null);
            } else {
                message.setText("There is no student");
            }
        } else if (e.getSource() == back) {
            this.dispose();
            new Managemain(students, m);
        }
    }
}
