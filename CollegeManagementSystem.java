package Student;
public class Student {
    private String studentId;
    private String name;
    private String email;
  public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }
  public void displayStudentInfo() {
        System.out.println("--- Student Details ---");
        System.out.println("ID    : " + studentId);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}
class Course {
    private String courseCode;
    private String courseName;
    private int credits;

    public Course(String courseCode, String courseName, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
    }
    public void displayCourseInfo() {
        System.out.println("\n--- Course Details ---");
        System.out.println("Code    : " + courseCode);
        System.out.println("Course  : " + courseName);
        System.out.println("Credits : " + credits);
    }
}
public class CollegeManagementSystem {
    public static void main(String[] args) {
        Student student = new Student("S101", "Alice Smith", "alice@example.com");
        Course course = new Course("CS101", "Introduction to Computer Science", 4);
        student.displayStudentInfo();
        course.displayCourseInfo();
    }
}
