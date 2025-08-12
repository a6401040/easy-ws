package org.easyws.jackson.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.easyws.jackson.entity.Student;

import java.util.List;

/**
 * Jackson XML请求DTO
 * 使用Jackson注解进行XML序列化/反序列化
 * 
 * @author easy-ws
 */
@JacksonXmlRootElement(localName = "request")
public class JacksonRequest {
    
    @JacksonXmlProperty(localName = "method")
    private String method;
    
    @JacksonXmlProperty(localName = "parameters")
    private Parameters parameters;
    
    /**
     * 内部参数类
     */
    public static class Parameters {
        
        @JacksonXmlProperty(localName = "parameter")
        private List<Parameter> parameter;
        
        public List<Parameter> getParameter() {
            return parameter;
        }
        
        public void setParameter(List<Parameter> parameter) {
            this.parameter = parameter;
        }
    }
    
    /**
     * 参数项类
     */
    public static class Parameter {
        
        @JacksonXmlProperty(localName = "name")
        private String name;
        
        @JacksonXmlProperty(localName = "value")
        private String value;
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public String getValue() {
            return value;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public Parameters getParameters() {
        return parameters;
    }
    
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}