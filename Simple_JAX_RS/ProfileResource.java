package com.rajat.tcs.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rajat.tcs.messenger.model.Profile;
import com.rajat.tcs.messenger.service.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	
	
	private ProfileService ps=new ProfileService();
	
	@GET
	public List<Profile> getProfiles()
	{
		return ps.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile p)
	{
		return ps.addProfile(p);
	}
	
	@Path("{profileName}")
	@GET
	public Profile getProfile(@PathParam("profileName") String ProfileName){
		return ps.getProfile(ProfileName);
	}
	
	@PUT
	@Path("{ProfileName}")
	public Profile updateProfile(@PathParam("ProfileName") String  ProfileName,Profile p)
	{
		p.setProfileName(ProfileName);
		return ps.updateProfiles(p);
		
	}
	
	@DELETE
	@Path("{ProfileName}")
	public void deleteProfile(@PathParam("ProfileName") String profileName)
	{
		ps.removeProfile(profileName);
	}

}
