package com.restfulmailsystem.server;

import org.restlet.resource.ServerResource;

import com.restfulmailsystem.common.RootResource;

public class RootServerResource extends ServerResource implements RootResource {

	public String represent() {
		return "Welcome to the " + getApplication().getName() + " !";
	}

}
