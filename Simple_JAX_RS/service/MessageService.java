package com.rajat.tcs.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.rajat.tcs.messenger.database.DatabaseClass;
import com.rajat.tcs.messenger.database.GetData;
import com.rajat.tcs.messenger.database.StoreData;
import com.rajat.tcs.messenger.model.Message;

public class MessageService {
	
private Map<Long,Message> mess=DatabaseClass.getAllMessages();
	
	

	public MessageService()
	{
		mess.put(1L,new Message(1L,"Code Hard","Play Hard"));
		mess.put(2L,new Message(2L,"Work Hard","Baby"));
		
	}
	public List<Message> getAllMessages()
	{
//		message m1=new message(1L,"Hello World","Rajat");
//		message m2=new message(1L,"Hello Bro","Rajat Singh");
//		List<message> l=new ArrayList<>();
//		l.add(m1);
//		l.add(m2);
//		return l;
		//Here we will get all Message from Database using Hibernate framework
		return GetData.getDatafromDB();
		//return new ArrayList<Message>(mess.values());
		
	}
	public List<Message> getAllMessagesForYear(int year)
	{
		List<Message> AllMessagesForYear=new ArrayList<Message>();
		Calendar cal=Calendar.getInstance();
		for(Message message:mess.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				AllMessagesForYear.add(message);
			}
			
		}
		return AllMessagesForYear;
	}
	public List<Message> getAllMessagesPagination(int start,int size)
	{
		return GetData.getDatafromDBusingPagination(start, size);
		//ArrayList<Message> list=new ArrayList<Message>();
		//return list.subList(start, start+size);
	}
	public Message getMessage(long id)
	{
		return mess.get(id);//look at the map defined above it will get the value from the map based on the key passed
	}
	public /*Message*/long  addMessage(Message m)
	{
		//Here i think i should i will call the DAO class and DAO class will in turn store it in the DATABASE
		//call the Database Class from here
		System.out.println("Came inside addMessage messageService");
		long i=StoreData.register(m);
		
		
//		m.setId(mess.size()+1);
//		mess.put(m.getId(), m);
		
		return i;
	}
	public Message updateMessage(Message m)
	{
		if(m.getId()<=0)
		{
			return null;
		}
		mess.put(m.getId(),m);
		return m;
	}
	public Message removeMessage(long id)
	{
		return mess.remove(id);
		
		
	}
	


}
