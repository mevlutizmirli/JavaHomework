package main;

import util.Grade;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    //Constructors defined
    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode,courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
       setCourseDepartment(courseDepartment);
       setCourseCode(courseCode);
       setCourseCredit(courseCredit);
       setGradeTaken(gradeTaken);
    }

    //Get and Set methods are defined.

    public String getCourseDepartment() {
        return courseDepartment;
    }


    public void setCourseDepartment(String courseDepartment){
        courseDepartment = courseDepartment.toUpperCase();
        if (courseDepartment.equals("CENG") || courseDepartment.equals("COMP") || courseDepartment.equals("ECE") ||
                courseDepartment.equals("ME") || courseDepartment.equals("MATH")){
            this.courseDepartment = courseDepartment;
        }else {

            this.courseDepartment = "CENG";
        }
    }


    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >=100 && courseCode <= 599){
            this.courseCode = courseCode;
            return;
        }
        this.courseCode = 100;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
       if (courseCredit == 3){
           this.courseCredit = courseCredit;
           return;
       }
       this.courseCredit = 4;
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(Grade gradeTaken) {
        this.gradeTaken = gradeTaken;
    }

    public void setGradeTaken(double val) {
        if (val >= 0 && val <= 4){
            int gradeRounded = (int) Math.round(val);
            for (Grade grade : Grade.values()){
                if (grade.getNumericValue() == gradeRounded){
                    this.gradeTaken = grade;
                    return;
                }
            }
        }
        this.gradeTaken = Grade.F;
    }

    // toString method
    @Override
    public String toString() {
        return "Department: " + this.courseDepartment
                + " CourseCode: " + this.courseCode
                + " Credit: " + this.courseCredit
                + " Grade: " + this.gradeTaken.getStringValue() + "\n";
    }
}
