import java.util.ArrayList;

public class Course {
    ArrayList<String> courseNames;

    public Course(String nameOfCourse) {

        for (int i = 0; i < 6; i++) {
            courseNames.add(nameOfCourse);
        }
    }

}
