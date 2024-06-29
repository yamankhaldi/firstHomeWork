import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    static int a = 1;
    public static Scanner scanner; // Note: Do not change this line.
    public static void manageGrades(String[][] matrix, String [] array) {

        boolean nonStop = true;
        while (nonStop) {
            System.out.println("Welcome to the Student Grade Management System!");
            System.out.println("1. Add a new student");
            System.out.println("2. Display all students");
            System.out.println("3. Calculate a student's average grade");
            System.out.println("4. Find the top performing student");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice: ");
            int option = scanner.nextInt();


            if (option == 1)
                addNewStudent(matrix , array);
            else if (option == 2)
                displayAllStudent();
            else if (option == 3)
                calculateAverage();
            else if (option == 4)
                topAverage();
            else if (option == 5) {
                System.out.println("Exiting the program. Goodbye!");
                nonStop = false;
            }
            else
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public  void  addNewStudent(String[][] matrix, String [] array) {
        System.out.println("Enter student name:");
        String nameStudent = scanner.nextLine();
        array[a] = nameStudent;
        System.out.println("Enter grades: ");
        String input = scanner.nextLine().trim();
        String[] grades= input.split("\\s+");
        boolean check = true;
        for (int i = 0 ; i < grades.length ; i++ )
        {
            matrix[a][i] = grades[i];
            if (Double.parseDouble(matrix[a][i]) < 0 || Double.parseDouble(matrix[a][i]) > 100  )
                check = false;
        }
        if (a > 99 ) {
            System.out.println("Student limit reached.");
            return ;
        }

        if (!check)
        {
            System.out.println(" Invalid grades.");
            return;
        }
        System.out.printf ("%s added successfully!", array[a]);
        a++;

    }




    public static void main(String[] args) throws IOException {
        String path = args[0];
        scanner = new Scanner(new File(path));
        int numberOfTests = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new double[100][];
        String [] array = new String [100];

        for (int i = 1; i <= numberOfTests; i++) {
            System.out.println("Test number " + i + " starts.");
            try {
                manageGrades(matrix,array);
            } catch(Exception e){
                System.out.println("Exception " + e);
            }
            System.out.println("Test number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All tests have ended.");
    }
}