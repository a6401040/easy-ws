package org.easyws.jackson.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 教师实体类 - 使用Jackson XML注解
 * 
 * @author easy-ws
 */
@JacksonXmlRootElement(localName = "teacher")
public class Teacher {
    
    @JacksonXmlProperty(localName = "name")
    private String name;
    
    @JacksonXmlProperty(localName = "lesson")
    private String lesson;

    /**
     * 默认构造函数
     */
    public Teacher() {
    }

    /**
     * 带参数的构造函数
     */
    public Teacher(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    /**
     * 获取教师姓名
     * @return 教师姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置教师姓名
     * @param name 教师姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取授课科目
     * @return 授课科目
     */
    public String getLesson() {
        return lesson;
    }

    /**
     * 设置授课科目
     * @param lesson 授课科目
     */
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", lesson='" + lesson + '\'' +
                '}';
    }
}