package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<String,Student> studentMap = new HashMap<>();
    Map<String,Teacher> teacherMap = new HashMap<>();
    Map<String, List<String>> stuTeaMap = new HashMap<>();

    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        if(teacherMap.containsKey(teacher) && studentMap.containsKey(student)){
            if(stuTeaMap.containsKey(teacher)){
                stuTeaMap.get(teacher).add(student);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(student);
                stuTeaMap.put(teacher,list);
            }
        }
    }
    public Student getStudentByName(String student){
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }
        return null;
    }
    public Teacher getTeacherByName(String teacher){
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> students = new ArrayList<>();
        if(stuTeaMap.containsKey(teacherName)){
            students = stuTeaMap.get(teacherName);
        }
        return students;
    }
    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(String s:studentMap.keySet()){
            students.add(s);
        }
        return students;
    }
    public void deleteTeacherByName(String teacherName){
        if(teacherMap.containsKey(teacherName)) {
            if (stuTeaMap.containsKey(teacherName)) {
                List<String> students = stuTeaMap.get(teacherName);
                for (String s : students) {
                    studentMap.remove(s);
                }
                stuTeaMap.remove(teacherName);
            }
            teacherMap.remove(teacherName);
        }
    }
    public void deleteAllTeachers(){
        ArrayList<String> list = new ArrayList<>();
        for(String s :stuTeaMap.keySet()){
            for(String m : stuTeaMap.get(s)){
                list.add(m);
            }
        }
        for(String i : list) studentMap.remove(i);
    }
 }
