package org.easyws.work;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.easyws.stardand.Clientable;
import org.easyws.util.ConstantData;
import org.easyws.work.callee.EasyServiceWorkService;

public abstract class BaseSenderWork extends BeanSenderWork{
	
	protected Clientable client;
	
	protected org.easyws.work.callee.EasyServiceWork work;
	
	private EasyServiceWorkService easr = new EasyServiceWorkService();
	
	
	protected BaseSenderWork(Clientable client) {
		this.client = client;
	}
	

	{
		work = (org.easyws.work.callee.EasyServiceWork)easr.getEasyServiceWorkPort();	
		// 设置WebService超时
		Map<String, Object> ctxt = ((BindingProvider) work).getRequestContext();
		// 来自com.sun.xml.internal.ws.developer.JAXWSProperties中的字符串常量
		ctxt.put(ConstantData.TIMEOUT_CONNECT, easr.getConnectTime());
		ctxt.put(ConstantData.TIMEOUT_REQUEST, easr.getRequestTime());
	}
	
	
	
	@Override
	protected String doSendJob(String request){		
		return work.receive(request);
	}
	
	


	
	

}
