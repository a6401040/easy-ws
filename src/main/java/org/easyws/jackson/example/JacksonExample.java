package org.easyws.jackson.example;

import org.easyws.jackson.dto.JacksonRequest;
import org.easyws.jackson.dto.JacksonResponse;
import org.easyws.jackson.entity.Student;
import org.easyws.jackson.entity.Teacher;
import org.easyws.jackson.service.JacksonServer;
import org.easyws.jackson.service.JacksonServerImpl;
import org.easyws.jackson.util.JacksonXmlUtil;

/**
 * Jackson XML使用示例
 * 演示如何使用Jackson进行XML序列化和反序列化
 * 
 * @author easy-ws
 */
public class JacksonExample {

    public static void main(String[] args) {
        // 示例1: 学生对象与XML的转换
        demonstrateStudentXmlConversion();
        
        // 示例2: 教师对象与XML的转换
        demonstrateTeacherXmlConversion();
        
        // 示例3: 服务调用示例
        demonstrateServiceCall();
    }
    
    /**
     * 演示学生对象的XML转换
     */
    private static void demonstrateStudentXmlConversion() {
        System.out.println("=== 学生对象XML转换示例 ===");
        
        // 创建学生对象
        Student student = new Student();
        student.setId("S001");
        student.setName("张三");
        student.setSex("男");
        
        // 对象转XML
        String xml = JacksonXmlUtil.studentToXml(student);
        System.out.println("学生对象转XML:");
        System.out.println(xml);
        
        // XML转对象
        Student parsedStudent = JacksonXmlUtil.xmlToStudent(xml);
        System.out.println("XML转回学生对象:");
        System.out.println(parsedStudent);
        System.out.println();
    }
    
    /**
     * 演示教师对象的XML转换
     */
    private static void demonstrateTeacherXmlConversion() {
        System.out.println("=== 教师对象XML转换示例 ===");
        
        // 创建教师对象
        Teacher teacher = new Teacher();
        teacher.setName("李老师");
        teacher.setLesson("数学");
        
        // 对象转XML
        String xml = JacksonXmlUtil.teacherToXml(teacher);
        System.out.println("教师对象转XML:");
        System.out.println(xml);
        
        // XML转对象
        Teacher parsedTeacher = JacksonXmlUtil.xmlToTeacher(xml);
        System.out.println("XML转回教师对象:");
        System.out.println(parsedTeacher);
        System.out.println();
    }
    
    /**
     * 演示服务调用
     */
    private static void demonstrateServiceCall() {
        System.out.println("=== 服务调用示例 ===");
        
        JacksonServer server = new JacksonServerImpl();
        
        // 调用服务方法
        String studentName = server.getStudentName("S001");
        System.out.println("获取学生姓名: " + studentName);
        
        // 创建学生对象并调用服务
        Student student = new Student();
        student.setId("S002");
        student.setName("李四");
        student.setSex("女");
        
        Teacher teacher = server.getTeacher(student);
        System.out.println("根据学生获取教师: " + teacher);
    }
}