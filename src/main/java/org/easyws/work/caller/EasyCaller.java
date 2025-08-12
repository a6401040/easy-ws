package org.easyws.work.caller;


import org.easyws.endpoint.EasyWS;
import org.easyws.stardand.Serverable;



/**
 * xml启动类 构造方法注入
 * @author Administrator
 *
 */
public class EasyCaller extends EasyWS{
	
	public EasyCaller(Serverable server) {
		super(server);
	}
	

	public EasyCaller(Serverable server, String ip, String port, String serviceName) {
		super(server, ip, port, serviceName);
	}

	
	public void initEasyWs(){
		super.init();
	}

}
