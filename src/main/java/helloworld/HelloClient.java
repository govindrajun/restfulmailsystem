package helloworld;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class HelloClient{

	public static void main(String[] args) throws ResourceException, IOException {

		ClientResource helloClientResource =
				new ClientResource("http://localhost:8111/");
		
		helloClientResource.get().write(System.out);
	}

}
