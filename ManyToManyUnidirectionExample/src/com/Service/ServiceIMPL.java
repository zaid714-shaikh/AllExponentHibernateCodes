package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.POJO.student;
import com.POJO.teacher;
import com.Util.HibernateUtil;

public class ServiceIMPL implements Service {

	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudent() {

		Session s = sf.openSession();

		student st = new student();
		System.out.println("Enter the Student Name :- ");
		st.setSname(sc.next());

		s.save(st);
		s.beginTransaction().commit();
		System.out.println("Studnet Inserted!!");
	}

	@Override
	public void addTeacher() {
		Session s = sf.openSession();
		System.out.println("Enter the Student ID For attching the Teacher:- ");
		int id = sc.nextInt();
		student st = s.get(student.class, id);
		if (st != null) {
			System.out.println("Enter how many teachers you want:-");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {

				teacher t = new teacher();
				System.out.println("Enter the techer name:-");
				t.setTeacherName(sc.next());

				st.getTeacherlist().add(t);

				s.save(st);
				s.beginTransaction().commit();
				System.out.println("Teacher added!!");
			}
		} else {
			System.out.println("Student not preesent");
		}

	}

	@Override
	public void addSpecificTeacherToStudent() {
		Session s = sf.openSession();
		System.out.println("Enter the Student ID For attching the Teacher:- ");
		int id = sc.nextInt();

		student stu = s.get(student.class, id);

		if (stu != null) {

			List<teacher> tlist = stu.getTeacherlist();
			System.out.println("Enter the teacherID to attach: -");
			int tid = sc.nextInt();
			boolean flag = false;
			teacher t = null;
			for (teacher tl : tlist) {
				if (tid == tl.getTeacherID()) {
					t = tl;
					flag = true;
					break;
				}
			}

			if (flag) {
				stu.getTeacherlist().add(t);
				s.save(stu);
				s.beginTransaction().commit();
				System.out.println("teacher Added to student successfully!!");
			}

		} else {
			System.out.println("Student not Exist!!");

		}

	}

	@Override
	public void displayStudent() {
		Session s = sf.openSession();
		Query<student> query = s.createQuery("from student");
		List<student> slist = query.getResultList();

		for (student st : slist) {
			System.out.println(st.getSid());
			System.out.println(st.getSname());
			for (teacher tlist : st.getTeacherlist()) {
				System.out.println(tlist.getTeacherID());
				System.out.println(tlist.getTeacherName());
			}
		}

	}

	@Override
	public void displayTeachersUsingStudentID() {

		Session s = sf.openSession();
		System.out.println("Enter the Student ID For attching the Teacher:- ");
		int id = sc.nextInt();

		student stu = s.get(student.class, id);

		if (stu != null) {

			List<teacher> tlist = stu.getTeacherlist();
			{
				System.out.println(tlist);
			}

		} else {
			System.out.println("Student ID Not Exist");
		}

	}

	@Override
	public void updateStudent() {
		Session s = sf.openSession();
		System.out.println("Enter the Student ID:- ");
		int id = sc.nextInt();

		student stu = s.get(student.class, id);

		if (stu != null) {

			System.out.println("Enter the Studnet name:-");
			stu.setSname(sc.next());

			s.update(stu);
			s.beginTransaction().commit();
			System.out.println("Student Updated Successfully!");

		} else {
			System.out.println("Student ID Not Exist");
		}
	}

	@Override
	public void updateTeacherUsingStudentID() {
		Session s = sf.openSession();
		System.out.println("Enter the Student ID :- ");
		int id = sc.nextInt();

		student stu = s.get(student.class, id);

		if (stu != null) {
			List<teacher> tlist = stu.getTeacherlist();
			System.out.println("Enter the teacherID to update: -");
			int tid = sc.nextInt();
			boolean flag = false;
			teacher t = null;
			for (teacher tl : tlist) {
				if (tid == tl.getTeacherID()) {
					t = tl;
					flag = true;
					break;
				}
			}

			if (flag) {

				System.out.println("Enter the teacher Name:-");
				t.setTeacherName(sc.next());
				s.update(stu);
				s.beginTransaction().commit();
				System.out.println("teacher updated successfully!!");
			}

		} else {
			System.out.println("Student ID Not Exist");
		}

	}

	@Override
	public void deleteTeacherUsingStudent() {
		Session s = sf.openSession();
		System.out.println("Enter the Student ID :- ");
		int id = sc.nextInt();

		student stu = s.get(student.class, id);

		if (stu != null) {
			List<teacher> tlist = stu.getTeacherlist();
			System.out.println("Enter the teacherID to update: -");
			int tid = sc.nextInt();
			boolean flag = false;
			teacher t = null;
			for (teacher tl : tlist) {
				if (tid == tl.getTeacherID()) {
					t = tl;
					flag = true;
					break;
				}
			}

			if (flag) {

				stu.getTeacherlist().remove(t);
				s.update(stu);
				s.delete(t);
				s.beginTransaction().commit();
				System.out.println("teacher updated successfully!!");
			}

		} else {
			System.out.println("Student ID Not Exist");
		}

	}

}
