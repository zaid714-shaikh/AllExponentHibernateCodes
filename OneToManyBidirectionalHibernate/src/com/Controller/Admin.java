package com.Controller;

import java.util.Scanner;

import com.Service.ServiceIMPL;
import com.Service.service;

public class Admin {
	public static void main(String[] args) {
		boolean flag = true;

		Scanner sc = new Scanner(System.in);

		service s = new ServiceIMPL();

		while (flag) {
			System.out.println("");

			System.out.println("1. Add UserData and Login Data.");
			System.out.println("2. display All data by UserData.");
			System.out.println("3. display single Data using UserData.");
			System.out.println("4. update Userdata using Userid");
			System.out.println("5. update logindata using userid");
			System.out.println("6. delete userdata");
			System.out.println("7. display all data by LoginData");
			System.out.println("8. display single data using Loginid");
			System.out.println("9. update Userdata using LoginID");
			System.out.println("10. DeleteLoginData");
			System.out.println("11. delete logindata using userid");
			System.out.println("12. delete userdata using loginid");
			System.out.println("13.exit");

			int ch = getValidChoice();

			switch (ch) {
			case 1:
				s.addUserWithLoginDetails();
				break;
			case 2:
				s.displayUser();
				break;
			case 3:
				s.displayLogin();
				break;
			case 4:
				s.displaySingleUserUsingUserID();
				break;
			case 5:
				s.displaySingleloginDetailUsingUserID();
				break;
			case 6:
				s.updateUserusingUserID();
				break;
			case 7:
				s.updateLoginDtailUsingUserID();
				break;
			case 8:
				s.deleteLoginDtailUsingUserID();
				break;
			case 9:
				s.displaySingleUserUsingLoginID();
				break;
			case 10:
				s.displaySingleloginDetailUsingLoginID();
				break;
			case 11:
				s.updateUserusingLoginID();
				break;
			case 12:
				s.deleteLoginDtailUsingLoginID();
				break;
			case 13:
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
