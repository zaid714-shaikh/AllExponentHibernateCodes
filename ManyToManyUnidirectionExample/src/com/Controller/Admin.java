package com.Controller;

import java.util.Scanner;

import com.Service.Service;
import com.Service.ServiceIMPL;

public class Admin {
	public static void main(String[] args) {
		boolean flag = true;

		Scanner sc = new Scanner(System.in);

		Service s = new ServiceIMPL();

		while (flag) {
			System.out.println("");

			System.out.println("1. Add student.");
			System.out.println("2.addTeacher");
			System.out.println("3. addSpecificTeacherToStudent");
			System.out.println("4. displayStudent");
			System.out.println("5. displayTeachersUsingStudentID");
			System.out.println("6. updateStudent");
			System.out.println("7.updateTeacherUsingStudentID");
			System.out.println("8.deleteTeacherUsingStudent");
			int ch = getValidChoice();

			switch (ch) {
			case 1:
				s.addStudent();
				break;
			case 2:
				s.addTeacher();
				break;
			case 3:
				s.addSpecificTeacherToStudent();
				break;
			case 4:
				s.displayStudent();
				break;
			case 5:
				s.displayTeachersUsingStudentID();
				break;
			case 6:
				s.updateStudent();
				break;
			case 7:
				s.updateTeacherUsingStudentID();
				break;
			case 8:s.deleteTeacherUsingStudent();
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Invalid Input!!!");
				break;
			}
		}

	}

	private static int getValidChoice() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Choice:- ");
		int ch;
		try {
			ch = sc.nextInt();
		} catch (Exception e) {
			System.out.println(e);
			return getValidChoice();
		}
		return ch;

	}
}
