package org.easyws.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.easyws.jaxb.dto.Request;
import org.easyws.jaxb.dto.Response;

public class XmlConvertUtil {
	
	
	
	/**
	 * xml转换request
	 * @param requestXml
	 * @return
	 */
    public static Request xml2requestBean(String requestXml, String encoding) {
    	Request request = new Request();	
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(request.getClass());
			Unmarshaller unshaller = context.createUnmarshaller();
//			response = (Response) unshaller.unmarshal(new ByteArrayInputStream(responseXml.getBytes("UTF8")));
			request = (Request) unshaller.unmarshal(new ByteArrayInputStream(requestXml.getBytes(encoding)));
        } catch (Exception e) {
            System.out.println("Exception while converting XMLToBean :" + e);
        }
        return request;
    }
	
	

	/**
	 * request转换xml
	 * @param req
	 * @return
	 */
    public static String requestBean2xml(Request request, String encoding) {
        String xmlFromRequest = "";
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(request.getClass());
            Marshaller m = null;
            m = context.createMarshaller();
            // 设置编码方式为GBK
//            m.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            m.setProperty(Marshaller.JAXB_ENCODING, encoding);
            ByteArrayOutputStream sw = new ByteArrayOutputStream();
            m.marshal(request, sw);
            xmlFromRequest = sw.toString();
            xmlFromRequest = xmlFromRequest.replace("&quot;", "'");
        } catch (JAXBException e) {
            System.out.println("Exception while converting BeanToXML :" + e);
        }
        return xmlFromRequest;
    }
    
    
    
    
    
	/**
	 * xml转换response
	 * @param responseXml
	 * @return
	 */
    public static Response xml2reponseBean(String responseXml, String encoding) {
    	Response response = new Response();	
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(response.getClass());
			Unmarshaller unshaller = context.createUnmarshaller();
//			response = (Response) unshaller.unmarshal(new ByteArrayInputStream(responseXml.getBytes("UTF8")));
			response = (Response) unshaller.unmarshal(new ByteArrayInputStream(responseXml.getBytes(encoding)));
        } catch (Exception e) {
            System.out.println("Exception while converting XMLToBean :" + e);
        }
        return response;
    }
    
    
    
    
    /**
	 * response转换xml
	 * @param rep
	 * @return
	 */
    public static String responseBean2xml(Response response, String encoding) {
        String ResponseXml = "";
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(response.getClass());
            Marshaller m = null;
            m = context.createMarshaller();
            // 设置编码方式为GBK
//            m.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            m.setProperty(Marshaller.JAXB_ENCODING, encoding);
            ByteArrayOutputStream sw = new ByteArrayOutputStream();
            m.marshal(response, sw);
            ResponseXml = sw.toString();
            ResponseXml = ResponseXml.replace("&quot;", "'");
        } catch (JAXBException e) {
            System.out.println("Exception while converting BeanToXML :" + e);
        }
        return ResponseXml;
    }

}
