public class Course {
    private String coursecateg;
    private int courseid;
    private String prof;
    private String dates;

    Course(String coursecateg, int courseid, String dates, String prof) {
        this.coursecateg = coursecateg;
        this.courseid = courseid;
        this.dates = dates;
        this.prof = prof;
    }

    String getcateg() {
        return this.coursecateg;
    }

    int getcourseid() {
        return this.courseid;
    }

    String getCourseName() {
        return this.coursecateg + this.courseid;
    }

    String getprof() {
        return this.prof;
    }
    
    String getdates() {
        return this.dates;
    }

    public void CourseMod(String coursecateg, int courseid, String dates, String prof) {
        this.coursecateg = coursecateg;
        this.courseid = courseid;
        this.dates = dates;
        this.prof = prof;
    }
}
