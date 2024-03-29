package com.restfulmailsystem.client;

import org.restlet.Client;
import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.resource.ClientResource;

import com.restfulmailsystem.common.AccountResource;
import com.restfulmailsystem.common.AccountsResource;
import com.restfulmailsystem.common.RootResource;

public class MailClient extends ClientResource {

	public static void main(String[] args) throws Exception {
		
/*		RootResource mailRoot = ClientResource.create("http://localhost:8111/",
				RootResource.class);
		String result = mailRoot.represent();
		System.out.println(result);*/
		
		System.out.println("\n1) Set up the service client resource\n");
		Client client = new Client(new Context(), Protocol.HTTP);
		ClientResource service = new ClientResource("http://localhost:8111");
		service.setNext(client);
		
		System.out.println("\n2) Display the root resource\n");
		RootResource mailRoot = service.getChild("/", RootResource.class);
		System.out.println(mailRoot.represent());
		
		System.out.println("\n3) Display the initial list of accounts\n");
		AccountsResource mailAccounts = service.getChild("/accounts/",
		AccountsResource.class);
		String list = mailAccounts.represent();
		System.out.println(list == null ? "<empty>\n" : list);
		System.out.println("4) Adds new accounts\n");
		mailAccounts.add("Homer Simpson");
		mailAccounts.add("Marjorie Simpson");
		mailAccounts.add("Bart Simpson");
		System.out.println("Three accounts added !");
		
		System.out.println("\n5) Display the updated list of accounts\n");
		System.out.println(mailAccounts.represent());
		
		System.out.println("6) Display the second account\n");
		AccountResource mailAccount = service.getChild(
		"/accounts/1", AccountResource.class);
		System.out.println(mailAccount.represent());
		
		System.out.println(
		"\n7) Update the individual account and display it again\n");
		mailAccount.store("Homer Jay Simpson");
		System.out.println(mailAccount.represent());
		
		System.out.println(
		"\n8) Delete the first account and display the list again\n");
		mailAccount = service.getChild("/accounts/0", AccountResource.class);
		mailAccount.remove();
		System.out.println(mailAccounts.represent());
		
	}
}
