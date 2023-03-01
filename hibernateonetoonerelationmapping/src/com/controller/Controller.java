package com.controller;

import java.util.Scanner;

import com.Service.ServiceIMPL;
import com.Service.service;

public class Controller {

	public static void main(String[] args) {

		boolean flag = true;

		service s = new ServiceIMPL();

		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("1.addperson");
			System.out.println("2.displayperson");
			System.out.println("3.displayspecificperson");
			System.out.println("4.updateperson");
			System.out.println("5.deleteper2son");
			System.out.println("6.updartpersonadhar");
			System.out.println("7.deletepersonadhar");
			System.out.println("8.exit");
			System.out.println();
			System.out.println("Enter the choice:-");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.addperson();
				break;

			case 2:
				s.displayperson();
				break;
			case 3:
				s.displayspecificperson();
				break;
			case 4:
				s.updateperson();
				break;
			case 5:
				s.deleteperson();
				break;
			case 6:
				s.updartpersonadhar();
				break;
			case 7:
				s.deletepersonadhar();
				break;
			case 8:
				flag = false;
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}
		}

	}
}
