import java.util.ArrayList;

public class manager {
    ArrayList<Student> course_req;
    static int counter;

    manager() {
        course_req = new ArrayList<Student>();
        counter = 0;
    }

    
    // return true if there is leftover student in queue, else return false
    boolean confirmcourse(Student s) {
        s.confirm();
        course_req.remove(counter);
        if (counter >= course_req.size()) {
            counter = course_req.size()-1;
        }
        if (!course_req.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    void requested(Student s) {
        course_req.add(s);
    }



    Student next() {
        if (counter+1 == course_req.size()) {
            return null;
        } 
        counter++;
        return course_req.get(counter);
    }

    Student back() {
        if (counter == 0) {
            return null;
        }
        counter--;
        return course_req.get(counter);
    }

    Student current() {
        return course_req.get(counter);
    }

    Student initialize() {
        if (counter == course_req.size()) {
            return null;
        }
        counter = 0;
        return course_req.get(0);
    }

    void addqueue(Student s) {
        course_req.add(s);
    }
}
