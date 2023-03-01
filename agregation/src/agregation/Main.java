package agregation;

public class Main {

	public static void main(String[] args) {

		student s1 = new student();

		s1.setSid(1);
		s1.setSname("shradha");

		school sch = new school();

		sch.setSchoolID(1);
		sch.setSchoolName("INdira");
		sch.setStd(s1);

		
		
		
		System.out.println("=-=========================");
		System.out.println("School ID:-"+sch.getSchoolID());
		System.out.println("School Name:-"+ sch.getSchoolName());
		System.out.println("Student ID:-" + sch.getStd().getSid());
		System.out.println("Student Name:-" + sch.getStd().getSname());
	}
}
