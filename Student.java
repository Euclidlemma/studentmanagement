import java.util.ArrayList;


class Student {
    private String name;
    private String sex; 
    private String age;
    private String email;
    private String address;
    private String phonenumber;
    private String id;
    private String password;
    private ArrayList<Course> appliedcourses;
    private ArrayList<Course> confirmedcourses;
    private boolean confirmed = false;

    // constructor of student class
    Student(String name, String sex, String age, String email, String address, String phonenumber, String id, String password) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.id = id;
        this.password = password;
        appliedcourses = new ArrayList<Course>();
        confirmedcourses = new ArrayList<Course>();
    }
    
    public String getname() {
        return this.name;
    }
    public String getsex() {
        return this.sex;
    }
    public String getage() {
        return this.age;
    }
    public String getemail() {
        return this.email;
    }
    public String getaddress() {
        return this.address;
    }
    public String getphonenumber() {
        return this.phonenumber;
    }
    public String getid() {
        return this.id;
    }
    public String getpassword() {
        return this.password;
    }

    public void addcourse(Course course) {
        this.appliedcourses.add(course);
    }

    public void addconfirmed(Course course) {
        this.confirmedcourses.add(course);
    }

    public Course retcourse(int index) {
        if (index >= this.appliedcourses.size()) {
            return null;
        }
        return this.appliedcourses.get(index);
    }

    public boolean managed() {
        return this.confirmed;
    }

    public void confirm() {
        confirmed = true;
    }

    public int coursenum() {
        return this.appliedcourses.size();
    }

    public int appliedcn() {
        return this.confirmedcourses.size();
    }

    public Course retc(int i) {
        if (i >= this.appliedcourses.size()) {
            return null;
        }
        return this.appliedcourses.get(i);
    }

    public Course retcc(int i) {
        return this.confirmedcourses.get(i);
    }

    public void courseconfirmed(int index) {
        this.confirmedcourses.add(appliedcourses.get(index));
        this.appliedcourses.remove(index);
    }

    public void changepass(char[] password) {
        this.password = new String(password);
    }
    
    public void modname(String name) {
        this.name = name;
    }

    public void modsex(String sex) {
        this.sex = sex;
    }

    public void modage(String age) {
        this.age = age;
    }

    public void modemail(String mail) {
        this.email = mail;
    }

    public void modaddress(String address) {
        this.address = address;
    }

    public void modphonenumber(String pn) {
        this.phonenumber = pn;
    }
}