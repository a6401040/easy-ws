package org.easyws.jackson.test;

import org.easyws.jackson.entity.Student;
import org.easyws.jackson.entity.Teacher;
import org.easyws.jackson.util.JacksonXmlUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Jackson XML测试类
 * 验证Jackson XML序列化和反序列化功能
 * 
 * @author easy-ws
 */
public class JacksonXmlTest {

    @Test
    public void testStudentXmlConversion() {
        // 创建测试学生对象
        Student student = new Student();
        student.setId("S001");
        student.setName("测试学生");
        student.setSex("男");
        
        // 对象转XML
        String xml = JacksonXmlUtil.studentToXml(student);
        assertNotNull("XML字符串不应为空", xml);
        assertTrue("XML应包含学生ID", xml.contains("S001"));
        assertTrue("XML应包含学生姓名", xml.contains("测试学生"));
        assertTrue("XML应包含学生性别", xml.contains("男"));
        
        // XML转对象
        Student parsedStudent = JacksonXmlUtil.xmlToStudent(xml);
        assertNotNull("解析后的学生对象不应为空", parsedStudent);
        assertEquals("ID应匹配", "S001", parsedStudent.getId());
        assertEquals("姓名应匹配", "测试学生", parsedStudent.getName());
        assertEquals("性别应匹配", "男", parsedStudent.getSex());
    }
    
    @Test
    public void testTeacherXmlConversion() {
        // 创建测试教师对象
        Teacher teacher = new Teacher();
        teacher.setName("测试教师");
        teacher.setLesson("计算机科学");
        
        // 对象转XML
        String xml = JacksonXmlUtil.teacherToXml(teacher);
        assertNotNull("XML字符串不应为空", xml);
        assertTrue("XML应包含教师姓名", xml.contains("测试教师"));
        assertTrue("XML应包含课程", xml.contains("计算机科学"));
        
        // XML转对象
        Teacher parsedTeacher = JacksonXmlUtil.xmlToTeacher(xml);
        assertNotNull("解析后的教师对象不应为空", parsedTeacher);
        assertEquals("姓名应匹配", "测试教师", parsedTeacher.getName());
        assertEquals("课程应匹配", "计算机科学", parsedTeacher.getLesson());
    }
    
    @Test
    public void testEmptyObject() {
        // 测试空对象
        Student emptyStudent = new Student();
        String xml = JacksonXmlUtil.studentToXml(emptyStudent);
        assertNotNull("空对象XML不应为空", xml);
        
        Student parsed = JacksonXmlUtil.xmlToStudent(xml);
        assertNotNull("解析后的空对象不应为空", parsed);
    }
}