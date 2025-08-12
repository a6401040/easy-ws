package org.easyws.jackson.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.easyws.jackson.entity.Student;
import org.easyws.jackson.entity.Teacher;

/**
 * Jackson XML工具类
 * 提供XML与Java对象之间的转换功能
 * 
 * @author easy-ws
 */
public class JacksonXmlUtil {
    
    private static final XmlMapper xmlMapper;
    
    static {
        xmlMapper = new XmlMapper();
        // 配置序列化特性
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        
        // 配置反序列化特性
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        xmlMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }
    
    /**
     * 将对象转换为XML字符串
     * 
     * @param object 要转换的对象
     * @return XML字符串
     */
    public static String toXml(Object object) {
        try {
            return xmlMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to XML", e);
        }
    }
    
    /**
     * 将XML字符串转换为指定类型的对象
     * 
     * @param xml XML字符串
     * @param clazz 目标类型
     * @return 转换后的对象
     */
    public static <T> T fromXml(String xml, Class<T> clazz) {
        try {
            return xmlMapper.readValue(xml, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert XML to object", e);
        }
    }
    
    /**
     * 将Student对象转换为XML
     * 
     * @param student 学生对象
     * @return XML字符串
     */
    public static String studentToXml(Student student) {
        return toXml(student);
    }
    
    /**
     * 将XML转换为Student对象
     * 
     * @param xml XML字符串
     * @return 学生对象
     */
    public static Student xmlToStudent(String xml) {
        return fromXml(xml, Student.class);
    }
    
    /**
     * 将Teacher对象转换为XML
     * 
     * @param teacher 教师对象
     * @return XML字符串
     */
    public static String teacherToXml(Teacher teacher) {
        return toXml(teacher);
    }
    
    /**
     * 将XML转换为Teacher对象
     * 
     * @param xml XML字符串
     * @return 教师对象
     */
    public static Teacher xmlToTeacher(String xml) {
        return fromXml(xml, Teacher.class);
    }
}