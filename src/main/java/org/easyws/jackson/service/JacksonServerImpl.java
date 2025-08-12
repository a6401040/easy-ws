package org.easyws.jackson.service;

import org.easyws.jackson.entity.Student;
import org.easyws.jackson.entity.Teacher;

/**
 * Jackson XML服务端实现类
 * 提供基于Jackson的服务实现
 * 
 * @author easy-ws
 */
public class JacksonServerImpl implements JacksonServer {

    @Override
    public String getStudentName(String id) {
        return "Student Name for ID: " + id;
    }

    @Override
    public Teacher getTeacher(Student student) {
        Teacher teacher = new Teacher();
        teacher.setName("Dr. " + student.getName());
        teacher.setLesson("Advanced " + student.getSex() + " Studies");
        return teacher;
    }
}