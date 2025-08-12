package org.easyws.test;

import java.lang.reflect.Method;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.easyws.jaxb.standard.client.Client;
import org.easyws.jaxb.standard.client.ClientImpl;
import org.easyws.util.ConstantData;
import org.easyws.work.Sender;
import org.easyws.work.SenderWork;
import org.easyws.work.callee.EasyServiceWorkService;

public class TestClient {
	
	
	public static void main(String[] args) {
		
		Client client = new ClientImpl();
		
		client.getStudentName("11");

		
		

	}
	
	
	


}
