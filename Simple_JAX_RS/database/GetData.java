package com.rajat.tcs.messenger.database;

import java.util.ArrayList;
import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rajat.tcs.messenger.model.Message;

public class GetData {
	public static List<Message> getDatafromDB()
	{
	List<Message> data=new ArrayList<Message>();	
	
	Session session =new Configuration().configure().buildSessionFactory().openSession();
	Transaction tx=session.beginTransaction();
	Query query=session.createQuery("from Message");
	data=query.list();
//	System.out.print(data);
	
	return data;
	}
	public static List<Message> getDatafromDBusingPagination(int start,int size)
	{
		List<Message> data=new ArrayList<Message>();
		Session session =new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Message");
		query.setFirstResult(start);
		query.setMaxResults(size);
		data=query.list();
		
		return data;
	}

}
