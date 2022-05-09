import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursesScreen extends JFrame implements ActionListener{
    StudentData students;
    Student s;
    manager man;
    JButton back;
    JButton next;
    JButton before;
    JButton add1;
    JButton add2;
    JButton add3;
    JButton add4;
    JButton add5;
    JButton add6;
    JButton add7;
    JButton rem1;
    JButton rem2;
    JButton rem3;
    JButton rem4;
    JButton rem5;
    JButton rem6;
    JButton rem7;
    Course cs;
    ArrayList<Course> l;
    static int page;
    static int totalpage;

    CoursesScreen(StudentData s, manager m, ArrayList<Course> lc, Course c, Student stu) {
        this.s = stu;
        this.students = s;
        this.man = m;
        this.l = lc;
        this.cs = c;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 900);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        this.add(mainpanel);
        this.setVisible(true);

        int maximum = lc.size();

        JLabel categ = new JLabel("Category:");
        categ.setBounds(150, 50, 80, 25);
        mainpanel.add(categ);

        JLabel idform = new JLabel("ID: ");
        idform.setBounds(240, 50, 80, 25);
        mainpanel.add(idform);

        JLabel inst = new JLabel("Instructor: ");
        inst.setBounds(330, 50, 110, 25);
        mainpanel.add(inst);

        JLabel date = new JLabel("Date: ");
        date.setBounds(450, 50, 150, 25);
        mainpanel.add(date);


        JLabel c1categ = new JLabel("");
        c1categ.setBounds(150, 120, 80, 25);
        mainpanel.add(c1categ);
        JLabel c1id = new JLabel("");
        c1id.setBounds(240, 120, 80, 25);
        mainpanel.add(c1id);
        JLabel c1instruc = new JLabel("");
        c1instruc.setBounds(330, 120, 110, 25);
        mainpanel.add(c1instruc);
        JLabel c1date = new JLabel("");
        c1date.setBounds(450, 120, 150, 25);
        mainpanel.add(c1date);

        JLabel c2categ = new JLabel("");
        c2categ.setBounds(150, 190, 80, 25);
        mainpanel.add(c2categ);
        JLabel c2id = new JLabel("");
        c2id.setBounds(240, 190, 80, 25);
        mainpanel.add(c2id);
        JLabel c2instruc = new JLabel("");
        c2instruc.setBounds(330, 190, 110, 25);
        mainpanel.add(c2instruc);
        JLabel c2date = new JLabel("");
        c2date.setBounds(450, 190, 150, 25);
        mainpanel.add(c2date);


        JLabel c3categ = new JLabel("");
        c3categ.setBounds(150, 260, 80, 25);
        mainpanel.add(c3categ);
        JLabel c3id = new JLabel("");
        c3id.setBounds(240, 260, 80, 25);
        mainpanel.add(c3id);
        JLabel c3instruc = new JLabel("");
        c3instruc.setBounds(330, 260, 110, 25);
        mainpanel.add(c3instruc);
        JLabel c3date = new JLabel("");
        c3date.setBounds(450, 260, 150, 25);
        mainpanel.add(c3date);

        JLabel c4categ = new JLabel("");
        c4categ.setBounds(150, 330, 80, 25);
        mainpanel.add(c4categ);
        JLabel c4id = new JLabel("");
        c4id.setBounds(240, 330, 80, 25);
        mainpanel.add(c4id);
        JLabel c4instruc = new JLabel("");
        c4instruc.setBounds(330, 330, 110, 25);
        mainpanel.add(c4instruc);
        JLabel c4date = new JLabel("");
        c4date.setBounds(450, 330, 150, 25);
        mainpanel.add(c4date);


        JLabel c5categ = new JLabel("");
        c5categ.setBounds(150, 400, 80, 25);
        mainpanel.add(c5categ);
        JLabel c5id = new JLabel("");
        c5id.setBounds(240, 400, 80, 25);
        mainpanel.add(c5id);
        JLabel c5instruc = new JLabel("");
        c5instruc.setBounds(330, 400, 110, 25);
        mainpanel.add(c5instruc);
        JLabel c5date = new JLabel("");
        c5date.setBounds(450, 400, 150, 25);
        mainpanel.add(c5date);

        JLabel c6categ = new JLabel("");
        c6categ.setBounds(150, 470, 80, 25);
        mainpanel.add(c6categ);
        JLabel c6id = new JLabel("");
        c6id.setBounds(240, 470, 80, 25);
        mainpanel.add(c6id);
        JLabel c6instruc = new JLabel("");
        c6instruc.setBounds(330, 470, 110, 25);
        mainpanel.add(c6instruc);
        JLabel c6date = new JLabel("");
        c6date.setBounds(450, 470, 150, 25);
        mainpanel.add(c6date);

        JLabel c7categ = new JLabel("");
        c7categ.setBounds(150, 540, 80, 25);
        mainpanel.add(c7categ);
        JLabel c7id = new JLabel("");
        c7id.setBounds(240, 540, 80, 25);
        mainpanel.add(c7id);
        JLabel c7instruc = new JLabel("");
        c7instruc.setBounds(330, 540, 110, 25);
        mainpanel.add(c7instruc);
        JLabel c7date = new JLabel("");
        c7date.setBounds(450, 540, 150, 25);
        mainpanel.add(c7date);


        if (c != null) {
            // this is the case where a specific course is searched
            c1categ.setText(c.getcateg());
            c1id.setText(Integer.toString(c.getcourseid()));
            c1instruc.setText(c.getprof());
            c1date.setText(c.getdates());
            if (stu != null) {
                add1 = new JButton("add");
                add1.setBounds(700, 120,80, 25);
                add1.addActionListener(this);
                mainpanel.add(add1);
            } else {
                rem1 = new JButton("remove");
                rem1.setBounds(800, 120,80, 25);
                rem1.addActionListener(this);
                mainpanel.add(rem1);
            }
            JLabel current = new JLabel("-" + Integer.toString(page + 1) + "-");
            current.setBounds(430, 570, 40, 30);
            mainpanel.add(current);
            
            
        } else {
            if (totalpage == 0) {
                totalpage = (maximum+7-1)/7; // getting the ceiling of the division

            }
            int cc = page * 7;

            for (int counter = 0; counter < 7; counter++) {
                Course temp;
                switch(counter) {
                    case 0:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c1categ.setText(temp.getcateg());
                        c1id.setText(Integer.toString(temp.getcourseid()));
                        c1instruc.setText(temp.getprof());
                        c1date.setText(temp.getdates());
                        if (stu != null) {
                            add1 = new JButton("add");
                            add1.setBounds(700, 120,80, 25);
                            add1.addActionListener(this);
                            mainpanel.add(add1);
                        } else {
                            rem1 = new JButton("remove");
                            rem1.setBounds(800, 120,80, 25);
                            rem1.addActionListener(this);
                            mainpanel.add(rem1);
                        }

                        break;
                    case 1:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c2categ.setText(temp.getcateg());
                        c2id.setText(Integer.toString(temp.getcourseid()));
                        c2instruc.setText(temp.getprof());
                        c2date.setText(temp.getdates());
                        //adding buttons
                        if (stu != null) {
                            add2 = new JButton("add");
                            add2.setBounds(700, 190,80, 25);
                            add2.addActionListener(this);
                            mainpanel.add(add2);
                        } else {
                            rem2 = new JButton("remove");
                            rem2.setBounds(800, 190,80, 25);
                            rem2.addActionListener(this);
                            mainpanel.add(rem2);
                        }
                        break;
                    case 2:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c3categ.setText(temp.getcateg());
                        c3id.setText(Integer.toString(temp.getcourseid()));
                        c3instruc.setText(temp.getprof());
                        c3date.setText(temp.getdates());
                        if (stu != null) {
                            add3 = new JButton("add");
                            add3.setBounds(700, 260,80, 25);
                            add3.addActionListener(this);
                            mainpanel.add(add3);
                        } else {
                            rem3 = new JButton("remove");
                            rem3.setBounds(800, 260,80, 25);
                            rem3.addActionListener(this);
                            mainpanel.add(rem3);
                        }
                        break;
                    case 3:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c4categ.setText(temp.getcateg());
                        c4id.setText(Integer.toString(temp.getcourseid()));
                        c4instruc.setText(temp.getprof());
                        c4date.setText(temp.getdates());

                        if (stu != null) {
                            add4 = new JButton("add");
                            add4.setBounds(700, 330,80, 25);
                            add4.addActionListener(this);
                            mainpanel.add(add4);
                        } else {
                            rem4 = new JButton("remove");
                            rem4.setBounds(800, 330,80, 25);
                            rem4.addActionListener(this);
                            mainpanel.add(rem4);
                        }
                        break;
                    case 4:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c5categ.setText(temp.getcateg());
                        c5id.setText(Integer.toString(temp.getcourseid()));
                        c5instruc.setText(temp.getprof());
                        c5date.setText(temp.getdates());

                        if (stu != null) {
                            add5 = new JButton("add");
                            add5.setBounds(700, 400,80, 25);
                            add5.addActionListener(this);
                            mainpanel.add(add5);
                        } else {
                            rem5 = new JButton("remove");
                            rem5.setBounds(800, 400,80, 25);
                            rem5.addActionListener(this);
                            mainpanel.add(rem5);
                        }
                        break;
                    case 5:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c6categ.setText(temp.getcateg());
                        c6id.setText(Integer.toString(temp.getcourseid()));
                        c6instruc.setText(temp.getprof());
                        c6date.setText(temp.getdates());

                        if (stu != null) {
                            add6 = new JButton("add");
                            add6.setBounds(700, 470,80, 25);
                            add6.addActionListener(this);
                            mainpanel.add(add6);
                        } else {
                            rem6 = new JButton("remove");
                            rem6.setBounds(800, 470,80, 25);
                            rem6.addActionListener(this);
                            mainpanel.add(rem6);
                        }
                        break;
                    case 6:
                    if (max(counter, maximum)) {
                        break;
                    }
                        temp = l.get(cc + counter);
                        c7categ.setText(temp.getcateg());
                        c7id.setText(Integer.toString(temp.getcourseid()));
                        c7instruc.setText(temp.getprof());
                        c7date.setText(temp.getdates());

                        if (stu != null) {
                            add7 = new JButton("add");
                            add7.setBounds(700, 540,80, 25);
                            add7.addActionListener(this);
                            mainpanel.add(add7);
                        } else {
                            rem7 = new JButton("remove");
                            rem7.setBounds(800, 540,80, 25);
                            rem7.addActionListener(this);
                            mainpanel.add(rem7);
                        }
                        break;
                }
            }
            before = new JButton("<");
            before.setBounds(195, 570, 40, 30);
            before.addActionListener(this);
            mainpanel.add(before);

            JLabel current = new JLabel("-" + Integer.toString(page + 1) + "-");
            current.setBounds(430, 570, 40, 30);
            mainpanel.add(current);


            next = new JButton(">");
            next.setBounds(665, 570, 40, 30);
            next.addActionListener(this);
            mainpanel.add(next);
        


        }
        back = new JButton("back");
        back.setBounds(0, 0, 80, 25);
        back.addActionListener(this);
        mainpanel.add(back);

    }

    boolean max(int c, int maximum) {
        if (page * 7 + c + 1 > maximum) {
            return true;
        }
        else {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        int result;
        if (e.getSource() == back) {
            page = 0;
            totalpage = 0;
            this.dispose();
            new FindCourse(students, man, s);
        } else if (e.getSource() == next) {
            if (page+1 >= totalpage) {
                JOptionPane.showMessageDialog(this, "You are at the end of the list", 
                            "info", JOptionPane.ERROR_MESSAGE);
            } else {
                page++;
                this.dispose();
                new CoursesScreen(students, man, l, cs, null);
            }
        } else if (e.getSource() == before) {
            if (page <= 0) {
                JOptionPane.showMessageDialog(this, "You are at the beginning of the list", 
                            "info", JOptionPane.ERROR_MESSAGE);
            } else {
                page--;
                this.dispose();
                new CoursesScreen(students, man, l, cs, null);
            }
        } else if (e.getSource() == add1) {
            // when add button appears, it is when student called CoursesScreen constructor
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 0));
                man.addqueue(s);
            } else {
                s.addcourse(cs);
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add2) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 1));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add3) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 2));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add4) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 3));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add5) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 4));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add6) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 5));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == add7) {
            // call student's adding function
            if (cs == null) {
                s.addcourse(l.get(page * 7 + 6));
                man.addqueue(s);
            }
            printaddmessage();
        } else if (e.getSource() == rem1) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 0);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem2) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 1);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem3) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 2);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem4) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 3);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem5) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 4);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem6) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 5);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        } else if (e.getSource() == rem7) {
            result = JOptionPane.showConfirmDialog(this, 
            "Are you sure you will remove this course?", "Confirm", 
            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                l.remove(page*7 + 6);
                if (l.size() == 0) {students.remove_categ(l);}
                JOptionPane.showMessageDialog(this, "Course succesfully removed", 
                "info", JOptionPane.INFORMATION_MESSAGE);
                new CoursesScreen(students, man, l, cs, s);
                this.dispose();
            }
        }
    }
    void printaddmessage() {
        JOptionPane.showMessageDialog(this, "Course added succesfully", 
                            "info", JOptionPane.ERROR_MESSAGE);
    }
}
