package org.easyws.jackson.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.easyws.jackson.entity.Teacher;

/**
 * Jackson XML响应DTO
 * 使用Jackson注解进行XML序列化/反序列化
 * 
 * @author easy-ws
 */
@JacksonXmlRootElement(localName = "response")
public class JacksonResponse {
    
    @JacksonXmlProperty(localName = "returnObj")
    private ReturnObj returnObj;
    
    /**
     * 返回对象类
     */
    public static class ReturnObj {
        
        @JacksonXmlProperty(localName = "value")
        private String value;
        
        @JacksonXmlProperty(localName = "teacher")
        private Teacher teacher;
        
        public String getValue() {
            return value;
        }
        
        public void setValue(String value) {
            this.value = value;
        }
        
        public Teacher getTeacher() {
            return teacher;
        }
        
        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }
    }
    
    public ReturnObj getReturnObj() {
        return returnObj;
    }
    
    public void setReturnObj(ReturnObj returnObj) {
        this.returnObj = returnObj;
    }
}