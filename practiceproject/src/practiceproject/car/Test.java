package practiceproject.car;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = cf.buildSessionFactory();

		Session s = sf.openSession();

		Car c = new Car();

		c.setCid(1);
		c.setCname("TATA");

		s.save(c);
		s.beginTransaction().commit();

		System.out.println("Executed successfull!!!");

	}
}
