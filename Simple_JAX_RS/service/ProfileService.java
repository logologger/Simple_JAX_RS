package com.rajat.tcs.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rajat.tcs.messenger.database.DatabaseClass;
import com.rajat.tcs.messenger.model.Message;
import com.rajat.tcs.messenger.model.Profile;

public class ProfileService {
	
	
	private Map<String, Profile> profiles=DatabaseClass.getAllProfiles();
	public ProfileService()
	{
		profiles.put("Rajat",new Profile(1L,"Rajat","Singh","Bhadauria"));
	}
	public List<Profile> getAllProfiles()
	{
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String ProfileName)
	{
		return profiles.get(ProfileName);
		
	}
	public Profile addProfile(Profile p)
	{
		p.setId(profiles.size()+1);
		 profiles.put(p.getProfileName(),p);
		 return p;
		
	}
	public Profile updateProfiles(Profile p)
	{
		if(p.getProfileName().isEmpty())
		{
			return null;
		}
		 profiles.put(p.getProfileName(), p);
		 return p;
	}
	public void removeProfile(String profileName)
	{
		profiles.remove(profileName);
	}
	

}
