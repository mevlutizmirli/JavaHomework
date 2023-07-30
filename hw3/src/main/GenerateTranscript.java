package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GenerateTranscript {
    private Transcript transcript;


    public void  takeInputFromUser() {
        Scanner input = new Scanner(System.in);
        int studentID;
        System.out.print("Please enter the student ID: ");
        studentID = input.nextInt();
        transcript = new Transcript(studentID);
        input.nextLine();

        while (true) {
            System.out.print("Enter Department: ");
            String department = input.nextLine();
            System.out.print("Enter Course Code: ");
            int courseCode = input.nextInt();
            System.out.print("Enter Credit: ");
            int credit = input.nextInt();
            System.out.print("Enter Grade: ");
            double grade = input.nextDouble();
            input.nextLine();
            transcript.addCourseTaken(new CourseGrade(department, courseCode, credit, grade));
            System.out.println("If you want to end course input, please press K ");
            if (input.nextLine().equalsIgnoreCase("K")) {
                System.out.println(transcript);
                break;
            }


        }


        }

    public void takeInputFromFile() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String filename = input.nextLine();

        File file = new File(filename + ".txt");
        Scanner scanner = new Scanner(file);

        int data = scanner.nextInt();
        scanner.nextLine();
        Transcript transcript = new Transcript(data);
        while (scanner.hasNextLine()){
            String data1 = scanner.nextLine();
            String[] lineInput = data1.split(" ");
            if (lineInput.length == 4){
                String department = lineInput[0];
                int course = Integer.valueOf(lineInput[1]);
                int credit = Integer.valueOf(lineInput[2]);
                double grade = Double.valueOf(lineInput[3]);

                transcript.addCourseTaken(new CourseGrade(department,course,credit,grade));


            }else {
                System.out.println("You entered wrong data");
            }

        }
        System.out.println(transcript);





    }


}
