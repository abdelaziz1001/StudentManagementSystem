
package studentmanagementsystem;

import java.util.Scanner;


public class Student {
    
    /* Variables About Stutent */
    private String firstName;
    private String lastName;
    private String courses =  " ";
    private int tuitionBalance = 0;
    private int gradeYear;
    private String studentID;
    private static int IDs = 1000;
    
    
    /* About Courses */
    String [] listOfCourses = new String[]{"Math 101", "English", "Programming", "Databases"};
    private int costOfCourse = 600;
    
    
    //-- Scanner --\\
    Scanner input = new Scanner(System.in);
    
    /* Constructor: prompt user to enter student's name and year */
    public Student(){
        System.out.print("Enter Student First Name: ");
        this.firstName = input.nextLine();
        
        System.out.print("Enter Student Last Name: ");
        this.lastName = input.nextLine();
        
        System.out.println("Student Levels: ");
        System.out.println("[1] Fresh Man\n[2] Sophomore\n[3] Junior\n[4] Senior");
        System.out.print("Enter Student Level: ");
        this.gradeYear = input.nextInt();
        
        setStudentID();
        
    }
    
    /* Generate an ID */
    private void setStudentID(){
        studentID = gradeYear + "" + (++IDs);
        
    }
    
    /* Enroll in Courses */
    public void enroll(){
        // loop and print the name of each course
        // user enter  Y or N 
        //      ([Y] = enrolls in course)
        //      ([N] = not add)
        //      ([F] = i do not enroll more)
        
        enrolling:{
            for(int i = 0; i < (int)(listOfCourses.length); i++){
                System.out.println("Enter [Y] If yout want to enroll in " + listOfCourses[i] + " Course, Or [N] to skip, Or [F] to stop Enrolling");
                System.out.print("Your choice: ");
                char choice = input.next().charAt(0);
                switch (choice) {
                    case 'Y':
                        courses += "\n " + listOfCourses[i];
                        tuitionBalance += costOfCourse;
                        break;
                    case 'N':
                        continue;
                    case 'F':
                        break enrolling;
                    default:
                        System.out.println("Enter Y or N or F");
                        i--;
                        break;
                }
            }
        }
        
        //System.out.println("ENROLLED IN:" + courses);
        //System.out.println("Tuition Balance: " + tuitionBalance +"$");
    }
    
    /* View Balance */
    public void viewBalance(){
        System.out.println("Your Balance is " + tuitionBalance + "$");
    } 
    
    /* Pay tuition */
    public void payTuition(){
        viewBalance(); 
        
        System.out.print("Enter Your Payment: ");
        int payment = input.nextInt();
        
        if(payment <= tuitionBalance){
            tuitionBalance -= payment;
            System.out.println("Thank You to Paying " + payment + "$");
        }
        else{
            System.out.println("Thank You to Paying " + tuitionBalance + "$");
            System.out.println("Aftar Pay tuition You Have " + (payment-tuitionBalance) + "$");
            tuitionBalance = 0;
        }
        
        viewBalance();
    }
    
    /* Show status */
    public String showInfo(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses: " + courses +
                "\nBalance: " + tuitionBalance;
    }
    
     
}
