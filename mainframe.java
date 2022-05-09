import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class mainframe extends JFrame implements ActionListener{
    JButton buttonstudent;
    JButton buttonop;
    JPanel titlecontain;
    JLabel title;
    JPanel buttoncontain;
    JPanel blank;
    StudentData sm;
    manager m;
    mainframe(StudentData s, manager mng) {
        this.sm = s;
        this.m = mng;
        titlecontain = new JPanel();
        buttoncontain = new JPanel();
        blank = new JPanel();

        // title panel initalize
        titlecontain.setLayout(new GridBagLayout());

        //button panel initialize
        buttoncontain.setLayout(new GridLayout(1,2,100, 0));

        // initialize title of the program
        title = new JLabel();
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setText("Student Manage Program");
        title.setFont(new Font("Dialog", Font.BOLD, 20));

        // initialize buttons
        buttonstudent = new JButton();
        buttonop = new JButton();
        buttonstudent.setText("Student");
        buttonstudent.setHorizontalTextPosition(JButton.CENTER);
        buttonop.setText("Manager");
        buttonop.setHorizontalTextPosition(JButton.CENTER);
        buttonstudent.addActionListener(this);
        buttonop.addActionListener(this);


        //size of the panels
        titlecontain.setPreferredSize(new Dimension(100, 400));
        buttoncontain.setPreferredSize(new Dimension(100, 100));
        blank.setPreferredSize(new Dimension(100, 100));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600, 600);
        this.setVisible(true);
        
        this.add(titlecontain, BorderLayout.NORTH);
        titlecontain.add(title);
        this.add(buttoncontain, BorderLayout.CENTER);
        this.add(blank, BorderLayout.SOUTH);
        buttoncontain.add(buttonstudent);
        buttoncontain.add(buttonop);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonstudent) {
            this.dispose();
            new NewPage(this.sm, m);
        } else if (e.getSource() == buttonop) {
            this.dispose();
            new ManagerLogin(this.sm, m);
        }
    }

    
}
