package com.rajat.tcs.messenger.database;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rajat.tcs.messenger.model.Answer;
import com.rajat.tcs.messenger.model.Question;


//With this example you will come to know that hibernate framework is simple awesome
public class fetchDatafromCollectionListOnetoManyMapping {
	public static void main(String args[])
	{
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Question");
		List<Question> l=query.list();
		Iterator<Question> itr=l.iterator();
		while(itr.hasNext())
		{
			Question q=itr.next();
			System.out.println(q.getQname());
			List<Answer> list=q.getAnswers();
			Iterator<Answer> itr2=list.iterator();
			while(itr2.hasNext())
			{
				Answer ans=itr2.next();
				
				System.out.println(ans.getAnswername());
			}
		}
		
		
	}

}
