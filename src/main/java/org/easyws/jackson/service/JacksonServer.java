package org.easyws.jackson.service;

import org.easyws.jackson.entity.Student;
import org.easyws.jackson.entity.Teacher;

/**
 * Jackson XML服务端接口
 * 定义基于Jackson的服务方法
 * 
 * @author easy-ws
 */
public interface JacksonServer {
    
    /**
     * 根据学生ID获取学生姓名
     * 
     * @param id 学生ID
     * @return 学生姓名
     */
    String getStudentName(String id);
    
    /**
     * 根据学生信息获取教师信息
     * 
     * @param student 学生对象
     * @return 教师对象
     */
    Teacher getTeacher(Student student);
}