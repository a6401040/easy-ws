package org.easyws.work;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import org.easyws.jaxb.dto.MarkInfo;
import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;
import org.easyws.stardand.Serverable;
import org.easyws.util.JSONUtil;
import org.apache.commons.beanutils.MethodUtils;

import com.alibaba.fastjson.JSON;

public class ReceiveWork extends BaseReceiveWork implements Receiver{
	

	public ReceiveWork(Serverable server) {
		super(server);
	}



	private Object invokeService(Class<?> clazz, String serviceName, Vector<Object> vo, MarkInfo markInfo) {
        Object result = new Object();
        try {
            result = MethodUtils.invokeMethod(clazz, serviceName, vo.toArray());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
	
	
	
	/**
	 * 接收方法
	 * @param args
	 * @return
	 */
	public String receive(String args){
		
		return this.doReceive(args);
		
	}








	@Override
	protected Response doRequestJob(Request request) {
		MarkInfo markInfo = new MarkInfo();
		
		//获取类
		Class<?> clazz = server.getClass();
		Vector<Object> vo = null;
		try {
			vo = JSONUtil.json2Bean(request, clazz);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		Object result = new Object();
		if (markInfo.isIsSuccess()) {
			try {
				result = invokeService(clazz, request.getServiceMethodName(), vo, markInfo);
			} catch (Exception e) {
				markInfo.setMessage("Unknown error:" + e.toString());
			}
		}

		// 将服务返回结果转换成JSON串
		String data = JSON.toJSONString(result);

		Response response = JSONUtil.json2Response(markInfo, data, request.getReturnType());

		return response;
	}









}
