import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

    interface CriterionOfStudent{
        boolean test(Student s);
    }

    class LowGpa implements CriterionOfStudent{
        private double threshold;

        public LowGpa(double threshold){
            this.threshold = threshold;
        }
        @Override
        public boolean test(Student s) {
            return s.getGpa() < threshold;
        }
    }

    class UnderAchiever implements CriterionOfStudent{
        @Override
        public boolean test(Student s) {
            return s.getCourses().size() < 3;
        }
    }

public class School {
        public static void showAllStudents(Iterable<Student> ls){
        for(Student s : ls){
            System.out.println(">" + s.getName());
            System.out.println(s.getGpa());
            System.out.println(s.getCourses());
        }
    }
    School(){}

    public static List<Student> getStudentsByCriterion(
            Iterable<Student> is, CriterionOfStudent criterion){
            List<Student> results = new ArrayList<>();
            for(Student s : is){
                if (criterion.test(s)) {
                    results.add(s);
                }
            }
            return results;
        }

    public static void main (List<Student> theseStudents){
       List<Student> roster = new ArrayList<>();

        roster.add(theseStudents.get(0));
        roster.add(theseStudents.get(1));
        roster.add(theseStudents.get(2));
        roster.add(theseStudents.get(3));
        System.out.println("Before sorting");
        showAllStudents(roster);

        System.out.println("Low GPA Students: ----------");
        showAllStudents(
                getStudentsByCriterion(
                        roster, new LowGpa(2.5)
                )
        );

        System.out.println("Underachieving Students: ----------");
        showAllStudents(
                getStudentsByCriterion(
                        roster, new UnderAchiever()
                )
        );
        System.out.println("Not Smart Students: ----------");
        showAllStudents(getStudentsByCriterion(roster, s -> s.getGpa() < 2.5));

        System.out.println("Long Name Students: ----------");
        showAllStudents(getStudentsByCriterion(roster, s -> s.getName().length() > 5));

        System.out.println("Enthusiastic, but Not Smart Students: ----------");
        showAllStudents(getStudentsByCriterion(roster, s -> s.getCourses().size() > 3 &&
                s.getGpa() < 2.5));

        System.out.println("Unenthusiastic, but Smart Students: ----------");
        showAllStudents(getStudentsByCriterion(roster, s -> s.getCourses().size() < 3 &&
                s.getGpa() > 3.5));

        roster.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
        System.out.println("after sorting by name in descending");
        showAllStudents(roster);

        roster.sort(Comparator.comparingDouble(Student::getGpa));
        System.out.println("after sorting gpa");
        showAllStudents(roster);

        roster.sort((s1, s2) -> Integer.compare(s2.getName().length(), s1.getName().length()));
        System.out.print("after sorting length of names");
        showAllStudents(roster);

        roster.sort((s1, s2) -> Integer.compare(s2.getCourses().size(), s1.getCourses().size()));
        System.out.print("after sorting length of names ");
        showAllStudents(roster);
    }

}
