package org.easyws.work;

import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;
import org.easyws.util.XmlConvertUtil;

public abstract class BeanReceiveWork{
	
	
	/**
	 * ·þ„Õ†¢„Ó·½·¨
	 * @param message
	 * @return
	 */
	protected String doReceive(String message) {
		
		Request request = XmlConvertUtil.xml2requestBean(message, "UTF-8");
		
		Response response = this.doReceiveJob(request);
		
		String responseXml = XmlConvertUtil.responseBean2xml(response, "UTF-8");
		
		return responseXml;
		
		
	}
	
	
	protected abstract Response doReceiveJob(Request request);
	
	



}
