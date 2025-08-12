package org.easyws.endpoint;

import javax.xml.ws.Endpoint;

import org.easyws.stardand.DefaultServiceImpl;
import org.easyws.stardand.Serverable;
import org.easyws.util.ConstantData;




/**
 * 代码启动类 endpoint
 * @author Administrator
 *
 */
public class EasyWS{

	
	
	// 以下参数需要注入
	protected Serverable server = new DefaultServiceImpl();

	protected String ip = ConstantData.EASY_DATA_DEFAULT_IP;

	protected String port = ConstantData.EASY_DATA_DEFAULT_PORT;

	protected String serviceName = ConstantData.EASY_DATA_DEFAULT_SERVICE;
	
	
	public EasyWS() {


	}
		
	

	public EasyWS(Serverable server, String ip, String port, String serviceName) {
		this.ip = ip;
		this.port = port;
		this.serviceName = serviceName;
		this.server = server;
	}




	public EasyWS(Serverable server) {
		this.server = server;

	}
	

	
	private String getAddress(){

		String address = ConstantData.EASY_DATA_HTTP+ip+ConstantData.EASY_DATA_COLON+port+ConstantData.EASY_DATA_SEPARATOR+serviceName;

		return address;
	}

	
	/**
	 * 写明是server
	 */
	public void init(){
		org.easyws.work.caller.EasyService easyService = new org.easyws.work.caller.EasyServiceWork(server);
		Endpoint.publish(this.getAddress(), easyService);	
	}
	

}
