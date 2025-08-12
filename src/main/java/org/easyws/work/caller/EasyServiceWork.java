package org.easyws.work.caller;



import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.easyws.stardand.Serverable;
import org.easyws.work.ReceiveWork;
import org.easyws.work.Receiver;


/**
 * 服务发布方法
 * @author ZhangQiLing
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EasyServiceWork implements EasyService{
	
	private Receiver receiveInvoker;
	
	
	public EasyServiceWork(Serverable server) {
		receiveInvoker = new ReceiveWork(server);
	}





	/**
	 * 发布方法
	 * @param args
	 */
	@WebMethod
	public String receive(String args){
		
		return receiveInvoker.receive(args);
	
	}
	
	
	
	

}
