package helloworld;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloServerResource extends ServerResource {

	//Creating a server-side resource
	@Get
    public String represent()
    {
        return "Hello World!";
    }
}
