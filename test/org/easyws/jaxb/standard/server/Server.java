package org.easyws.jaxb.standard.server;

import org.easyws.jaxb.standard.entity.Student;
import org.easyws.jaxb.standard.entity.Teacher;
import org.easyws.stardand.Serverable;


/**
 * 规范要一致 约定优先于配置
 * @author Ice_KyLin
 *
 */
public interface Server extends Serverable{
	
	
	
	public String getStudentName(String id);
	
	
	public Teacher getTeacher(Student student);

}
