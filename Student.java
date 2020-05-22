package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	// Private variables
	private String firstName, lastName, studentID;
	private String courses = "";
	private int gradeYear;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	// Constructor: prompt user to enter student's name and year
	public Student() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter student first name: ");
		this.firstName = scan.nextLine();
		System.out.print("Enter student last name: ");
		this.lastName = scan.nextLine();
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.gradeYear = scan.nextInt();
		
		setStudentId();
	}
	// Generate ID
	private void setStudentId() {
		// Grade level + ID
		id++;
		this.studentID = gradeYear + "" + id;
	}
	// Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner scan = new Scanner(System.in);
			String course = scan.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n\t" + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			} else {
				break;
			}
		} while(1 != 0);
	}
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	// Pay Tuition
	public void payTuition() {
		Scanner scan = new Scanner(System.in);
		viewBalance();
		System.out.print("Enter your payment: $");
		int payment = scan.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payement of $" + payment);
		viewBalance();
	}
	// Show status
	public String showInfo() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade level: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
	
}
