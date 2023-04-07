package com.javatpoint.hibernateannotationtest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//package com.hibernate.hibernateAnnotation;
//
///**
// * Hello world!
// *
// */
public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sfg = cfg.buildSessionFactory();
		Session session = sfg.openSession();
		Transaction t = session.beginTransaction();
//		Employee e1 = new Employee();
//		e1.setId(105);
//		e1.setFirstName("sanjiv");
//		e1.setLastName("sethi");
//wfwff
//		session.save(e1);
		Query q = session.createQuery("from Employee");
		q.setFirstResult(1);
		q.setMaxResults(3);
		List<Employee> ls = q.list();
		for (Employee emp : ls) {
			System.out.println(emp.getId() + " " + emp.getFirstName());
		}
		
		t.commit();
	//	System.out.println("successfully saved");
		session.close();
		sfg.close();
		
		System.out.println(sfg);
//		jflkgjdlfjgldjfgljgjgldfjgljglfj
	}

}
