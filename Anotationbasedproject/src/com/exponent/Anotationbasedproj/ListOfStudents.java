package com.exponent.Anotationbasedproj;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class ListOfStudents {

	public static List<Student> listofstudents() {
		List<Student> ls = new ArrayList<Student>();

		Student s = new Student();
		s.setSid(3);
		s.setSname("navin");

		Student s1 = new Student();
		s1.setSid(3);
		s1.setSname("karan");

		ls.add(s);
		ls.add(s1);

		return ls;

	}
}
