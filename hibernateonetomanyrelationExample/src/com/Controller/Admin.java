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

			System.out.println("1. add customer");
			System.out.println("2. add products");
			System.out.println("3. showCustomer ");
			System.out.println("4. showspecific customer");
			System.out.println("5. show products");
			System.out.println("6.show specific product");
			System.out.println("7. update customer using customerID");
			System.out.println("8. update product using customerID");
			System.out.println("9. delete customer");
			System.out.println("10. delete product using customer ID");
			System.out.println("11. deletSpecificCustomer ");
			System.out.println("12. deleteSpecificProductUsingCustomerID");
			System.out.println("13.exit");
			System.out.println("Enter the choice:-");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				s.addCustomer();
				break;
			case 2:
				s.addProducts();
				break;
			case 3:
				s.showCustomer();
				break;
			case 4:
				s.showSpecificCustomer();
				break;
			case 5:
				s.showproducts();
				break;
			case 6:
				s.showSpecificProductUsingCustomerID();

				break;
			case 7:
				s.updateCustomer();

				break;
			case 8:
				s.updateProductUsingCustomerID();
				break;
			case 9:
				s.deleteCustomer();
				break;
			case 10:
				s.deleteProductsUsingCustomerID();
				break;
			case 11:
				s.deletSpecificCustomer();
				break;
			case 12:
				s.deleteSpecificProductUsingCustomerID();
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
}
