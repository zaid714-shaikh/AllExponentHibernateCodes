package com.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.POJO.file;
import com.Util.HibernateUtil;

public class controller {
	public static void main(String[] args) throws IOException {

		SessionFactory sf = HibernateUtil.getConnection();

		Session s = sf.openSession();

		Path path = Paths.get("F:\\zaid_AWS_cloud_engineer_resume.docx");

		byte[] bytedata = Files.readAllBytes(path);

		Date date = new Date(System.currentTimeMillis());

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String currentdate = simpleDateFormat.format(date);

		file f = new file();
		f.setFname(path.toAbsolutePath().toString());
		f.setFdata(bytedata);
		f.setFdate(currentdate);

		s.save(f);
		s.beginTransaction().commit();

	}
}