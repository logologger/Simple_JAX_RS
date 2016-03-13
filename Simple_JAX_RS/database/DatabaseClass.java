package com.rajat.tcs.messenger.database;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.rajat.tcs.messenger.model.Message;
import com.rajat.tcs.messenger.model.Profile;

public class DatabaseClass {
	//I think here the Hibernate Will play its role
	private static Map<Long,Message> message=new HashMap<>();
	private static Map<String,Profile> profile=new HashMap<>();
	
	public static Map<Long,Message> getAllMessages()
	{
		return message;
	}
	public static Map<String,Profile> getAllProfiles()
	{
		return profile;
	}

}
