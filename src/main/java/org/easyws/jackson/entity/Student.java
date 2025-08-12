package org.easyws.jackson.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 学生实体类 - 使用Jackson XML注解
 * 
 * @author easy-ws
 */
@JacksonXmlRootElement(localName = "student")
public class Student {
    
    @JacksonXmlProperty(localName = "id")
    private String id;
    
    @JacksonXmlProperty(localName = "name")
    private String name;
    
    @JacksonXmlProperty(localName = "sex")
    private String sex;

    /**
     * 默认构造函数
     */
    public Student() {
    }

    /**
     * 带参数的构造函数
     */
    public Student(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    /**
     * 获取学生ID
     * @return 学生ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置学生ID
     * @param id 学生ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取学生姓名
     * @return 学生姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学生姓名
     * @param name 学生姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学生性别
     * @return 学生性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置学生性别
     * @param sex 学生性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}