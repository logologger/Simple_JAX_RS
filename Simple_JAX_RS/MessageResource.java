package com.rajat.tcs.messenger;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.rajat.tcs.messenger.model.Message;
import com.rajat.tcs.messenger.service.MessageService;


@Path("message")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

   
	MessageService ms=new MessageService();
    
	@GET
	//public List<Message> getIt(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size) {
    public List<Message> getIt(@BeanParam MessageFilterBeam filterBean){  
	if(filterBean.getYear()/*year*/>0)
        {
        	return ms.getAllMessagesForYear(filterBean.getYear()/*year*/);
        }
        if(filterBean.getStart()/*start*/>0 &&  filterBean.getSize()/*size*/>0)
        {
        	return ms.getAllMessagesPagination(filterBean.getStart(),filterBean.getSize()/*start, size*/);
        }
		
		return ms.getAllMessages();
    }
	
	@Path("{messageId}")
	@GET
	public Message getMessage(@PathParam("messageId") Long id)
	{
		return ms.getMessage(id);
	}
	
	@POST
	public Message addMessage(Message message)
	{
		System.out.println("Came inside addMessage");
		ms.addMessage(message);
		return message;
	}
	
	@Path("{messageId}")
	@PUT
	public Message updateMessage(@PathParam("messageId") long id,Message message)
	{
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@Path("{messageId}")
	@DELETE
	public void deleteMessage(@PathParam("messageId") long id)
	{
		ms.removeMessage(id);
	}
    
    
}
