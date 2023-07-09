package com.spring.pojo;


import java.util.List;
import java.util.Map;

public class Student {
    private String name;

    private Integer age;

    private String[] hobbies;

    private List<Book> bookList;

    private Map<String,Teacher> teacherMap;



    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }



    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }
}
