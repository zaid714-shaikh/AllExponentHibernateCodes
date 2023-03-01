package com.Controller;

import java.util.Scanner;

import com.Service.Service;
import com.ServiceIMPL.ServiceIMPL;

public class controller {

	public static void main(String[] args) {

		Service s = new ServiceIMPL();
		Scanner sc = new Scanner(System.in);

		boolean flag = true;

		while (flag) {
			System.out.println("1.AddCollage");
			System.out.println("2.DisplayCollage");
			System.out.println("3.DisplaySpecificCollage");
			System.out.println("4.updateCollage");
			System.out.println("5.DeleteCollage");
			System.out.println("6.Exit");

			System.out.println();
			System.out.print("Enter the choice :- ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.addCollage();
				break;
			case 2:
				s.displaycollage();
				break;
			case 3:
				s.displaySpecificCollage();
				break;
			case 4:
				s.updateCollage();
				break;
			case 5:
				s.deleteCollage();
				break;
			case 6:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice!!");
				break;
			}

		}

	}

}
