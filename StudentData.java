import java.lang.reflect.Array;
import java.util.*;


public class StudentData {
    static ArrayList<Student> students;
    static ArrayList<ArrayList<Course>> courses;
    StudentData() {
        students = new ArrayList<Student>();
        courses = new ArrayList<ArrayList<Course>>();
    }

    void addstudent(Student s) {
        students.add(s);
    }

    void remove_student(int i) {
        students.remove(i);
    }

    Student getStudent(int i) {
        return students.get(i);
    }

    // adds course under the category array
    void addCourse(Course c, ArrayList<Course> course) {
        for (int i = 0; i < course.size(); i++) {
            if (course.get(i).getcourseid() >= c.getcourseid()) {
                course.add(i, c);
            }
        }
        course.add(c);
    }

    // add Courses
    void addCourseCateg(Course c) {
        String categ = c.getcateg();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).get(0).getcateg().equals(categ)) {
                addCourse(c, courses.get(i));
                return;
            }
        }
        ArrayList<Course> temp = new ArrayList<Course>();
        temp.add(c);
        courses.add(temp);
    }


    // return a full list of courses under the coursecateg
    // if this function returns null, there is no such category
    ArrayList<Course> findCourse(String coursecateg) {
        int size = courses.size();
        if (size == 0) {
            if (courses.get(0).get(0).getcateg().equals(coursecateg)) {
            return courses.get(0);
            }
        } else{
            for (int i = 0; i < size; i++) {
                if (courses.get(i).get(0).getcateg().equals(coursecateg)) {
                    return courses.get(i);
                }
            }
        }
        return null;
    }

    // find a specific course by using binary search
    Course findCourse(int id, int l, int h, ArrayList<Course> categ) {

        int mid = (l+h)/2;
        if (l > h) {
            return null;
        }
        if (id == categ.get(mid).getcourseid()) {
            return categ.get(mid);
        } else if (id < mid) {
            return findCourse(id, l, mid - 1, categ);
        }
        return findCourse(id, mid + 1, h, categ);
    }

    // if this function return null, then no student in the database
    Student find_student(String id, char[] pwd) {
        for (int j = 0; j < students.size(); j++) {
            if ((students.get(j).getid().equals(id))||(students.get(j).getpassword().equals(new String(pwd)))) {
                return students.get(j);
            }
        }
        return null;
    }

    // if this function returns -1, then there is no such student
    int find_student_id(String id) {
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getid().equals(id)) {
                return j;
            }
        }
        return -1;
    }

    void remove_categ(ArrayList<Course> categ) {
        for (int i=0; i < courses.size(); i++) {
            if (courses.get(i) == categ) {
                courses.remove(i);
            }
        }
    }
    
}
