package com.rajat.tcs.messenger;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjectDemoResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String MatrixParam,@HeaderParam("authSessionId") String headerID,@CookieParam("name") String cookie)
	{
	//matrix Param (:) is like Query Param (?)
		
		
		return "MatrixParam "+MatrixParam+"Header PARAM"+headerID+"cookie"+cookie;
		
	}
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriinfo,@Context HttpHeaders httpheaders)
	{
		String path;
		path=uriinfo.getAbsolutePath().toString();
		String cookie=httpheaders.getCookies().toString();
		return "Path "+path+"  Cookies"+cookie;
		
	}

}
