
package studentmanagementsystem;

import java.util.Scanner;


public class StudentManagementSystem {

   
    public static void main(String[] args) {
        
        // Scanner 
        Scanner input = new Scanner(System.in);
       
        // Ask how many users we want to add
        System.out.print("Enter Number of New Student To Enroll: ");
        int numOfStudents = input.nextInt();
        Student[] students = new Student[numOfStudents];
        
        // Create N numbers of new students
        for(int i = 0; i < numOfStudents; i++){
            System.out.println("-----------------------------------------");
            System.out.println("Student Number: " + (i+1));
            students[i] = new Student();
            students[i].enroll();
            students[i].payTuition();
        }
        
        // Show info about All New Students
        for(int i = 0; i < numOfStudents; i++){
            System.out.println("-----------------------------------------");
            System.out.println(students[i].showInfo());
            System.out.println("-----------------------------------------");
        }
        

    }
    
}
