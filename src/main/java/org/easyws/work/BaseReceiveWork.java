package org.easyws.work;

import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;
import org.easyws.stardand.Serverable;

public abstract class BaseReceiveWork extends BeanReceiveWork{
	
	protected Serverable server;
	

	protected BaseReceiveWork(Serverable server) {
		this.server = server;
	}
	
	
	@Override
	protected Response doReceiveJob(Request request){
		Response response = this.doRequestJob(request);
		return response;
	}
	
	
	
	abstract protected Response doRequestJob(Request request);
	
	


}
