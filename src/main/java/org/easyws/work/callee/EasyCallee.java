package org.easyws.work.callee;


import org.easyws.stardand.Clientable;
import org.easyws.stardand.DefaultClientImpl;
import org.easyws.util.ConstantData;

public class EasyCallee {
	
	
	// 以下参数需要注入
	private Clientable client = new DefaultClientImpl();

	private String ip = ConstantData.EASY_DATA_DEFAULT_IP;

	private String port = ConstantData.EASY_DATA_DEFAULT_PORT;

	private String serviceName = ConstantData.EASY_DATA_DEFAULT_SERVICE;
	
	private int connectTimeout;
	
	private int readTimeout;
	
	


	public String getAddress(){

		String address = ConstantData.EASY_DATA_HTTP+ip+ConstantData.EASY_DATA_COLON+port+ConstantData.EASY_DATA_SEPARATOR+serviceName+"?wsdl";

		return address;
	}
	
	
	public Clientable getClientable(){
		return client;
	}
	
	
	public int getReadTimeOut(){

		return readTimeout * ConstantData.TIME_SECOND;
	}
	
	
	public int getConnectTimeOut(){
		return connectTimeout * ConstantData.TIME_SECOND;
	}
	
	
	
	
	
	

}
