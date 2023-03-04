package com.javatpoint.hibernateannotationtest;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class StoreData {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
//
////		Employee e1 = new Employee();
////		e1.setId(102);
////		e1.setFirstName("rahul");
////		e1.setLastName("Chawla");
////
////		session.save(e1);
//		Query q = session.createQuery("from Employee");
//		q.setFirstResult(1);
//		q.setMaxResults(5);
//		List<Employee> ls = q.list();
//		for (Employee emp : ls) {
//			System.out.println(emp.getId() + " " + emp.getFirstName());
//		}
////		
//		// Query for updates
////		Query query = session.createQuery("update Employee set firstName=:firstname where id=:id");
////		query.setParameter("firstname", "Shreya");
////		query.setParameter("id", 105);
////		query.executeUpdate();
//		Query query = session.createQuery("select count(id) from Employee");
//		Long max = (Long) query.list().get(0);
//		System.out.println(max);
//		// criteria
//		Criteria cr = session.createCriteria(Employee.class);
//		cr.add(Restrictions.like("firstName", "Shreya"));
//		List<Employee> emp = cr.list();
//		System.out.println(emp);
//
//		Criteria c = session.createCriteria(Employee.class);
//		c.setFirstResult(1);
//		c.setMaxResults(4);
//		List list = c.list();
//		System.out.println(list);
//
//		Criteria cr1 = session.createCriteria(Employee.class);
//		cr1.addOrder(Order.desc("id"));
//		List<Employee> ls1 = cr1.list();
//
//		for (Employee em : ls1) {
//			System.out.println(em.getFirstName() + " " + em.getId());
//		}
//		
//		
//		//named query
//		Query qry = session.getNamedQuery("Fetchbasedonid");
//		qry.setParameter("id", 101);
//		List<Employee>lsemp = qry.list();
//		for (Employee em : lsemp) {
//			System.out.println(em.getFirstName() + " " + em.getId());
//		}
//		
//		//named query based on firstname
//		Query qry2 = session.getNamedQuery("Fetchbasedonname");
//		qry2.setParameter("firstName", "Ratan");
//		List<Employee>lsemp1 = qry2.list();
//		for (Employee em : lsemp1) {
//			System.out.println(em.getFirstName() + " " + em.getId());
//		}

		Employee empinfo = session.get(Employee.class, 102);
		System.out.println(empinfo);

		Employee empinfo1 = session.get(Employee.class, 102);
		System.out.println(empinfo1);

//		Employee empinfos = session.load(Employee.class, 108);
//		System.out.println(empinfos);
		// remove
		Employee empinfo2 = new Employee();
		empinfo2.setId(106);
		empinfo2.setFirstName("Sanjay");
		//session.remove(empinfo2);
		t.commit();
		session.save(empinfo2);
		Employee empinfos = session.get(Employee.class, 106);
		System.out.println(empinfos);
		System.out.println("successfully saved");
		factory.close();
		session.close();
		
		
	}
}
