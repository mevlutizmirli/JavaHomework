import main.CourseGrade;
import main.Transcript;
import util.Grade;

public class Main {
    public static void main(String[] args) {

        CourseGrade courseGrade1 = new CourseGrade("ME", 120, 5, Grade.A);
        CourseGrade courseGrade2 = new CourseGrade("MATH", 105,5, Grade.F);
        CourseGrade courseGrade3 = new CourseGrade("CENG",107,5,Grade.D);


        Transcript transcript = new Transcript(1031010609);
        transcript.addCourseTaken(courseGrade1);
        transcript.addCourseTaken(courseGrade2);
        transcript.addCourseTaken(courseGrade3);



        System.out.println(transcript);













    }
}