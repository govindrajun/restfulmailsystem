package com.restfulmailsystem.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import com.testresources.TestServerResource;

public class MailServerApplication extends Application {

	public MailServerApplication() {
		setName("RESTful Mail Server application");
		setDescription("Example application for 'Restlet in Action' book");
		setOwner("Restlet SAS");
		setAuthor("The Restlet Team");
	}

	public static void main(String[] args) throws Exception {
		Server mailServer = new Server(Protocol.HTTP, 8111);
		mailServer.setNext(new MailServerApplication());
		mailServer.start();
	}

	/*
	 * @Override public Restlet createInboundRoot() { return new Restlet() {
	 * 
	 * @Override public void handle(Request request, Response response) { String
	 * entity = "Method : " + request.getMethod() + "\nResource URI : " +
	 * request.getResourceRef() + "\nIP address : " +
	 * request.getClientInfo().getAddress() + "\nAgent name : " +
	 * request.getClientInfo().getAgentName() + "\nAgent version: " +
	 * request.getClientInfo().getAgentVersion(); response.setEntity(entity,
	 * MediaType.TEXT_PLAIN); } }; }
	 */

	/*
	 * @Override public Restlet createInboundRoot(){ Blocker blocker = new
	 * Blocker (getContext()); //blocker.getBlockedAddresses().add("127.0.0.1");
	 * blocker.setNext(new Tracer(getContext())); return blocker; }
	 */

	/*
	 * //2.6
	 * 
	 * @Override public Restlet createInboundRoot(){ Tracer tracer = new Tracer
	 * (getContext()); Blocker blocker = new Blocker (getContext());
	 * blocker.getBlockedAddresses().add("127.0.0.1"); blocker.setNext(tracer);
	 * Router router = new Router(getContext());
	 * router.attach("http://localhost:8111/", tracer);
	 * router.attach("http://localhost:8111/accounts/", tracer);
	 * router.attach("http://localhost:8111/accounts/{accountId}", blocker);
	 * return router; }
	 */

	@Override
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/", RootServerResource.class);
		router.attach("/accounts/", AccountsServerResource.class);
		router.attach("/accounts/{accountId}", AccountServerResource.class);
		return router;
	}
}
