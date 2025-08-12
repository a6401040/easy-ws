package org.easyws.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Vector;

import org.easyws.exception.EasywsException;
import org.easyws.jaxb.dto.MarkInfo;
import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Request.Parameters.Parameter;
import org.easyws.jaxb.dto.Response;
import org.easyws.jaxb.dto.Response.ReturnObj;

import com.alibaba.fastjson.JSON;


public class JSONUtil {
	
	
	

	
	
	
	
	 /**
     * 从传入的Request内获取JSON格式数据，将其转换为对应的Object。
     * @throws ClassNotFoundException throws when the object in the request can not be found
     */
    public static Vector<Object> json2Bean(Request request,
            Class<?> clazz) throws ClassNotFoundException {

        Parameter parameter = null;
        Vector<Object> vo = new Vector<Object>();

        List<Parameter> paralist = request.getParameters().getParameter();
        Class<?>[] paraClasses = new Class[paralist.size()];

        for (int i = 0; i < paralist.size(); i++) {
            String type = paralist.get(i).getType();
            if (type == null || type.trim().equals("")) {
                break;
            }
            paraClasses[i] = Class.forName(type);
        }

        Method method;
        try {
            method = clazz.getMethod(request.getServiceMethodName(), paraClasses);
        } catch (Exception e) {
            throw new EasywsException("Can't find method: " + e.getMessage());
        }

        Type resType = method.getGenericReturnType();
        if (request.getReturnType() == null
                || !request.getReturnType().equals(resType.toString()))
            throw new EasywsException("The return type of the method:"
                    + method.getName() + " is not " + request.getReturnType()
                    + " but " + resType.toString());

        Type[] paraTypes = method.getGenericParameterTypes();

        for (int i = 0; i < paralist.size(); i++) {
            parameter = paralist.get(i);
            if (parameter.getType() == null
                    || parameter.getType().trim().equals("")) {
                return vo;
            }

            Object object = null;
            try {
                object =
                        JSON.parseObject(parameter.getData(), paraTypes[i]);
            } catch (Exception e) {
                e.printStackTrace();
                throw new EasywsException("Parse Parameter data error");
            }
            vo.add(object);
        }
        return vo;
    }
    
    
    
    
    
    
	public static Response json2Response(MarkInfo markInfo, String data, String resultType) {
		Response result = new Response();
		String mark = JSON.toJSONString(markInfo);
		String doubleQuote = "\"";
		String singleQuote = "'";
		mark = mark.replace(doubleQuote, singleQuote);
		String data2 = data.replace(doubleQuote, singleQuote);
		result.setMarkInfo(mark);

		ReturnObj retObj = new ReturnObj();
		retObj.setReturnData(data2);
		retObj.setReturnType(resultType);

		result.setReturnObj(retObj);
		return result;
	}

}
