package com.rajat.tcs.messenger.database;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rajat.tcs.messenger.model.Message;

public class StoreData {
	public static long register(Message m)
	{
		long i=0;
		//here i will use the Hibernate framework for storing Data
		System.out.println("Storing Data using Hibernate framework");
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t=session.beginTransaction();
		System.out.println("Begin transaction");
		t.begin();
		
		i=(Long) session.save(m);
		System.out.println("should save now and value of i is "+i);
		t.commit();
		session.close();
		System.out.print("close the session");
		return i;
		
		
		
	}

}
