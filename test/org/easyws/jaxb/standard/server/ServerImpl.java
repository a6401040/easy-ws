package org.easyws.jaxb.standard.server;

import org.easyws.jaxb.standard.entity.Student;
import org.easyws.jaxb.standard.entity.Teacher;

public class ServerImpl implements Server{

	@Override
	public String getStudentName(String id) {

		return "student!";
	}

	@Override
	public Teacher getTeacher(Student student) {
		Teacher teacher = new Teacher();
		teacher.setLesson("lesson1");
		teacher.setName("wang");
		return teacher;
	}

}
