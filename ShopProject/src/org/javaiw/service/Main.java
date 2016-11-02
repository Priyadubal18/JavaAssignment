package org.javaiw.service;
import javax.xml.ws.Endpoint;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:4322/product/demo", new EShop());

	}

}
