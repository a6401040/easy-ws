package org.easyws.test;

import org.easyws.endpoint.EasyWS;
import org.easyws.jaxb.standard.server.Server;
import org.easyws.jaxb.standard.server.ServerImpl;

public class TestService {
	
	
	
	public static void main(String[] args) {
		
/*		Server server = new ServerImpl();
		
		EasyWS ws = new EasyWS(server);
		
		
		ws.init();*/
		Server s = new ServerImpl();
		System.out.println("==>> "  + s.getClass().toString());
		
	}

}
