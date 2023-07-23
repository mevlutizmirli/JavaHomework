package main;

import java.util.ArrayList;

public class Transcript {
    private int studentID;
    private ArrayList<CourseGrade> courseGrades;
    private double GPA;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.GPA = 0;
        this.courseGrades = new ArrayList<>();
    }

    //Method that calculates gpa
    public void addCourseTaken(CourseGrade courseGrade){
        if (courseGrade != null){
            this.courseGrades.add(courseGrade);
            double gradeTotal = 0;
            for (CourseGrade courseGrade1 : this.courseGrades){
                gradeTotal += (double) courseGrade1.getGradeTaken().getNumericValue() / (double) this.courseGrades.size();
            }
            this.GPA = gradeTotal;
        }else {
            System.out.println("ERROR: NULL");
        }
    }

    // toString method

    @Override
    public String toString() {

        String formattedGPA = String.format("%.1f",this.GPA);
        return "Student ID: " + this.studentID + "\n" + this.courseGrades.toString()
                + "GPA: " + formattedGPA;
    }
}
