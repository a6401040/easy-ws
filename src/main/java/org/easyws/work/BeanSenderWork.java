package org.easyws.work;

import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;
import org.easyws.util.XmlConvertUtil;

public abstract class BeanSenderWork{
	
	
	/**
	 * 服务调用方法
	 * @param Request
	 * @return Response
	 */
	protected Response doSend(Request request) {
		
		String requestXml = XmlConvertUtil.requestBean2xml(request, "UTF-8");
		
		String responseXml = this.doSendJob(requestXml);
		
		Response response = XmlConvertUtil.xml2reponseBean(responseXml, "UTF-8");
		
		return response;
		
		
	}
	
	
	protected abstract String doSendJob(String request);
	
	



}
