package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public void addStudent(Student student){
        repository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        repository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        repository.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String student){
        return repository.getStudentByName(student);
    }
    public Teacher getTeacherByName(String teacher){
        return repository.getTeacherByName(teacher);
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        return repository.getStudentsByTeacherName(teacherName);
    }
    public List<String> getAllStudents(){
        return repository.getAllStudents();
    }
    public void deleteTeacherByName(String teacherName){
        repository.deleteTeacherByName(teacherName);
    }
    public void deleteAllTeachers(){
        repository.deleteAllTeachers();
    }
}
