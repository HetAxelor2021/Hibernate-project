package com.HibernateProjNow.app;

import java.util.*;

import javax.persistence.Basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class app {
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		
		user.setUserName("hardik");
//		user.setAddress("first user's address");
//		user.setJoinedDate(new Date());
//		user.setDescription("Description of the user goes here");
		
//		UserDetails user2 = new UserDetails();
//		user2.setUserName("Hetul");
////		user2.setAddress("second user's address");
//		user2.setJoinedDate(new Date());
//		user2.setDescription("Description of the second user goes here");
//		
		
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("City name");
		addr.setState("first state");
		addr.setPincode("10002");
		
		
//		user.setHomeAddress(addr);
//		user2.setAddress(addr);
		
		Address addr2 = new Address();
		addr2.setStreet("seconde Street name");
		addr2.setCity("second City name");
		addr2.setState("second state");
		addr2.setPincode("200002");
//		user.setOfficeAddress(addr);
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
//		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User name retrieved is "+user.getUserName());
//		System.out.println("User name retrieved is "+user.getDescription());
	}
}
