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
				s.addUserDataWithLoginData();
				break;
			case 2:
				s.displayAllDataUsingUserData();
				break;
			case 3:
				s.displaySingleDataUsingUserId();
				break;
			case 4:
				s.updateUserDataOnly();
				break;
			case 5:
				s.updateLoginDataUsingUserId();
				break;
			case 6:
				s.deleteUserData();
				break;
			case 7:
				s.displayAllDataUsingLoginData();
				break;
			case 8:
				s.displaySingleDataUsingLoginId();
				break;
			case 9:
				s.updateUserDataUsingLoginId();
				break;
			case 10:
				s.deleteLoginData();
				break;
			case 11:
				s.DeleteLoginDataUsingUserId();
				break;
			case 12:
				s.DeleteUserDataUsingLoginId();
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
