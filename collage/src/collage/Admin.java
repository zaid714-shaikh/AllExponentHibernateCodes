package collage;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Admin {

	public static void main(String[] args) {

		SessionFactory sf = hibernateUtil.getSessionconnection();

		Session s = sf.openSession();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many Collages you want to add:-");
		int cn = sc.nextInt();
		for (int i = 0; i < cn; i++) {
			collageDetails cd = new collageDetails();

			System.out.print("Enter the collage id:-");
			cd.setCid(sc.nextInt());
			System.out.print("Enter the collage name:-");
			cd.setCname(sc.next());
			System.out.print("Enter the University name:-");
			cd.setUnviersity(sc.next());
			System.out.print("Enter the collage location :-");
			cd.setCollageLocation(sc.next());

			s.save(cd);
		}

		s.beginTransaction().commit();
		System.out.println("Data Added Succesfully!!!!");
	}
}
