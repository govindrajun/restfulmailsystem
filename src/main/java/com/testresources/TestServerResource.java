package com.testresources;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class TestServerResource extends ServerResource {

	public TestServerResource() {
		setNegotiated(false);
		//setExisting(false);
	}

	@Override
	protected void doInit() throws ResourceException {
		System.out.println("The root resource was initialized.");
	}

	@Override
	protected void doCatch(Throwable throwable) {
		System.out.println("An exception was thrown in the root resource.");
	}

	@Override
	protected void doRelease() throws ResourceException {
		System.out.println("The root resource was released.\n");
	}

	@Override
	protected Representation get() throws ResourceException {
		System.out.println("The GET method of root resource was invoked.");
		return new StringRepresentation("This is the root resource");
	}

	@Override
	protected Representation options() throws ResourceException {
		System.out.println("The OPTIONS method of root resource was	invoked.");
		throw new RuntimeException("Not yet implemented");
	}

	public static void main(String[] args) throws Exception {

		Server helloserver = new Server(Protocol.HTTP,8111,TestServerResource.class);
		helloserver.start();
	}
}
