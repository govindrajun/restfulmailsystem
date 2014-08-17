package helloworld;

import org.restlet.Server;
import org.restlet.data.Protocol;

public class HelloServer {

	public static void main(String[] args) throws Exception {

		Server helloserver = new Server(Protocol.HTTP,8111,HelloServerResource.class);
		helloserver.start();
	}

}
