package org.easyws.work;




import java.lang.reflect.Method;

import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;
import org.easyws.stardand.Clientable;
import org.easyws.util.XmlConvertUtil;


public class SenderWork extends BaseSenderWork implements Sender{
	


	protected SenderWork(Clientable client) {
		super(client);
	}



	@Override
	protected Object send(Object... objs) {
		Request request = XmlConvertUtil.Obj2Request(Object... objs);
		Response response = doSend(request);
		Object obj = XmlConvertUtil.Response2Obj(response);
		return obj;
	}




	




}
