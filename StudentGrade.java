import java.util.Scanner;

public class StudentGrade
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
		System.out.println("Enter the number of subjects:");
        int numSubjects = kb.nextInt();

        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the marks obtained in subject " + (i + 1) + ":");
            marks[i] = kb.nextInt();
        }

        calculateResults(marks);
    }

    public static void calculateResults(int[] marks) {
	   // Calculate Total Marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        // Calculate Average Percentage
        double averageP = (double) totalMarks / marks.length;
		

        // Grade Calculation
        char grade;
        if (averageP >= 90) {
            grade = 'A';
        } else if (averageP >= 80) {
            grade = 'B';
        } else if (averageP >= 70) {
            grade = 'C';
        } else if (averageP >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averageP + "%");
        System.out.println("Grade: " + grade);
    }
}