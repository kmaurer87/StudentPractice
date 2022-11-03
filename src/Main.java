import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Student studentA = Student.of("John", 3.75, "History", "Biology");
        Student studentB = Student.of("Kelly", 2.45, "Programming");
        Student studentC = Student.of("Carol", 3.99, "German", "P.E", "Japanese");
        Student studentD = Student.of("Elizabeth", 3.4,"Home Ec", "Journalism", "Sociology", "Health");
        System.out.println(studentA.getGpa());
        System.out.println(studentA.getName());
        System.out.println(studentA.getCourses());
        System.out.println(studentB.getGpa());
        System.out.println(studentB.getName());
        System.out.println(studentB.getCourses());
        System.out.println(studentC.getGpa());
        System.out.println(studentC.getName());
        System.out.println(studentC.getCourses());
        System.out.println(studentD.getGpa());
        System.out.println(studentD.getName());
        System.out.println(studentD.getCourses());

        List<Student> students = new ArrayList<>();
        students.add(studentA);
        students.add(studentB);
        students.add(studentC);
        students.add(studentD);


        School.main(students);
    }

}