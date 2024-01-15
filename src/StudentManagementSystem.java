import java.util.ArrayList;

class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String group;
    private ArrayList<Course> courses;

    public Student(String firstName, String lastName, String studentId, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.group = group;
        this.courses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(firstName + " " + lastName + " enrolled in course: " + course.getCourseName());
    }

    public void withdrawFromCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeStudent(this);
            System.out.println(firstName + " " + lastName + " withdrew from course: " + course.getCourseName());
        } else {
            System.out.println(firstName + " " + lastName + " is not enrolled in course: " + course.getCourseName());
        }
    }
}

class Course {
    private String courseName;
    private ArrayList<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayStudents() {
        System.out.println("Students enrolled in course " + courseName + ":");
        for (Student student : students) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " (ID: " + student.getStudentId() + ")");
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Programming");
        Course mathCourse = new Course("Mathematics");

        Student student1 = new Student("John", "Doe", "12345", "CS101");
        Student student2 = new Student("Jane", "Smith", "67890", "CS102");

        student1.enrollInCourse(javaCourse);
        student2.enrollInCourse(mathCourse);

        javaCourse.displayStudents();
        mathCourse.displayStudents();

        student1.withdrawFromCourse(javaCourse);

        javaCourse.displayStudents();
    }
}

