package com.smaran;

import com.smaran.dao.StudentDAO;

import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();

        while (true) 
        {

            System.out.println();
            System.out.println("=================================");
            System.out.println("      STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {

                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();

                    Student student = new Student(
                            name,
                            age,
                            email,
                            course
                    );

                    studentDAO.addStudent(student);

                    break;

                case 2:

                    studentDAO.viewAllStudents();

                    break;

                case 3:

                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();

                    studentDAO.searchStudent(searchId);

                    break;

                case 4:

                    System.out.print("Enter student ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new age: ");
                    int updateAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String updateEmail = scanner.nextLine();

                    System.out.print("Enter new course: ");
                    String updateCourse = scanner.nextLine();

                    studentDAO.updateStudent(
                            updateId,
                            updateName,
                            updateAge,
                            updateEmail,
                            updateCourse
                    );

                    break;

                case 5:

                    System.out.print("Enter student ID: ");
                    int deleteId = scanner.nextInt();

                    studentDAO.deleteStudent(deleteId);

                    break;

                case 6:

                    System.out.println("Exiting Student Management System...");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}