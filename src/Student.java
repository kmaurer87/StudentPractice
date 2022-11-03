import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private double gpa;
    private List<String> courses;

    Student(String newStudent, double studentGpa, List<String> studentCourses){
        if(iaValid(newStudent, studentGpa)) {
            name = newStudent;
            gpa = studentGpa;
            courses = studentCourses;
        }else{
            throw new IllegalArgumentException("Invalid Name or GPA");
        }
    }
    public static Student of(String name, double gpa, String ...courses){
//        if(gpa > 3.5){
//            return new VIPStudent(name, gpa);
//        }else{
            return new Student(name, gpa, List.of(courses));
//        }
    }

    public String getName(Student this){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getGpa(Student this){
        return this.gpa;
    }
    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public List<String> getCourses(Student this){
        return this.courses;
    }
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public static boolean iaValid(String name, double gpa){
        return name != null && name.length() > 0 &&
                gpa > 0.0 && gpa < 4.1;
    }
}

