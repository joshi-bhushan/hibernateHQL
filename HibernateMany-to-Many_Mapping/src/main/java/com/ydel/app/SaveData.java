package com.ydel.app;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ydel.entity.College;
import com.ydel.entity.Student;

public class SaveData {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta= new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory  factory =meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		
		Student stud1 = new Student();
		stud1.setStudent_name("raj");
		stud1.setAdmissionBy((java.sql.Date) new Date());

		Student stud2 = new Student();
		stud2.setStudent_name("bhushan");
		stud2.setAdmissionBy((java.sql.Date) new Date());
		
		College clg=  new College();
		clg.setCollageName("IMR college");
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(stud1);
		list.add(stud2);
		
		Student stud3 = new Student();
		stud3.setStudent_name("sham");
		stud3.setAdmissionBy((java.sql.Date) new Date());
		
		Student stud4 = new Student();
		stud4.setStudent_name("Sachin");
		stud4.setAdmissionBy((java.sql.Date) new Date());
		
		College clg2 = new College();
		clg2.setCollageName("SMPC college");
		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.add(stud3);
		list2.add(stud4);
		
		session.persist(clg);
		session.persist(clg2);
				
		t.commit();
		session.close();
		System.out.println("Stored Data successsfully");
	}

}