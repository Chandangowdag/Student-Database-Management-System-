package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

interface StudentDAO {
    void addStudent(Student student);
    void updateStudent(String usn, Student student);
    void deleteStudent(String usn);
    Student getStudentByUsn(String usn);
    List<Student> getAllStudents();
}
