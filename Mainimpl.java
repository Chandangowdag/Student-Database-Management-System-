package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Mainimpl extends JFrame {
    private StudentDAO studentDAO;

    public Mainimpl() {
        // Initialize StudentDAOImpl
        studentDAO = new StudentDAOImpl();

        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // Create buttons
        JButton addButton = new JButton("Add Student");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton getByUsnButton = new JButton("Get Student by USN");
        JButton getAllButton = new JButton("Get All Students");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(getByUsnButton);
        panel.add(getAllButton);
        panel.add(exitButton);

        // Add panel to the frame
        add(panel);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        getByUsnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStudentByUsn();
            }
        });

        getAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllStudents();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void addStudent() {
        // Display input dialog boxes to get student information
        String usn = JOptionPane.showInputDialog(this, "Enter USN:");
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        String email = JOptionPane.showInputDialog(this, "Enter Email:");
        String section = JOptionPane.showInputDialog(this, "Enter Section:");
        String sex = JOptionPane.showInputDialog(this, "Enter Sex:");
        String doB = JOptionPane.showInputDialog(this, "Enter Date of Birth:");
        int heightCm = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Height in cm:"));
        int weightKg = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Weight in Kg:"));
        String homeState = JOptionPane.showInputDialog(this, "Enter Home State:");
        String homeTown = JOptionPane.showInputDialog(this, "Enter Home Town:");
        String motherTongue = JOptionPane.showInputDialog(this, "Enter Mother Tongue:");
        String elective = JOptionPane.showInputDialog(this, "Enter Elective:");
        String clubs = JOptionPane.showInputDialog(this, "Enter Clubs:");

        // Create a Student object with the provided information
        Student newStudent = new Student(usn, name, email, section, sex, doB, heightCm, weightKg, homeState, homeTown, motherTongue, elective, clubs);

        // Add the new student to the data store
        studentDAO.addStudent(newStudent);

        // Display a message to confirm the addition
        JOptionPane.showMessageDialog(this, "Student added successfully.");
    }


    private void updateStudent() {
        // Prompt the user to enter the USN of the student to update
        String usn = JOptionPane.showInputDialog(this, "Enter USN of the student to update:");

        // Retrieve the existing student
        Student existingStudent = studentDAO.getStudentByUsn(usn);

        if (existingStudent != null) {
            // Display the existing student's information for reference
            JOptionPane.showMessageDialog(this, "Existing student details:\n" + existingStudent.toString());

            // Get updated information from the user
            String name = JOptionPane.showInputDialog(this, "Enter updated Name:");
            String email = JOptionPane.showInputDialog(this, "Enter updated Email:");
            String section = JOptionPane.showInputDialog(this, "Enter updated Section:");
            String sex = JOptionPane.showInputDialog(this, "Enter updated Sex:");
            String doB = JOptionPane.showInputDialog(this, "Enter updated Date of Birth:");
            int heightCm = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter updated Height in cm:"));
            int weightKg = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter updated Weight in Kg:"));
            String homeState = JOptionPane.showInputDialog(this, "Enter updated Home State:");
            String homeTown = JOptionPane.showInputDialog(this, "Enter updated Home Town:");
            String motherTongue = JOptionPane.showInputDialog(this, "Enter updated Mother Tongue:");
            String elective = JOptionPane.showInputDialog(this, "Enter updated Elective:");
            String clubs = JOptionPane.showInputDialog(this, "Enter updated Clubs:");

            // Create an updated Student object
            Student updatedStudent = new Student(usn, name, email, section, sex, doB, heightCm, weightKg,
                    homeState, homeTown, motherTongue, elective, clubs);

            // Update the student in the data store
            studentDAO.updateStudent(usn, updatedStudent);

            // Display a message to confirm update
            JOptionPane.showMessageDialog(this, "Student updated successfully.");
        } else {
            JOptionPane.showMessageDialog(this, "Student with USN " + usn + " not found.");
        }
    }

    private void deleteStudent() {
        // Prompt the user to enter the USN of the student to delete
        String usn = JOptionPane.showInputDialog(this, "Enter USN of the student to delete:");

        // Delete the student from the data store
        studentDAO.deleteStudent(usn);

        // Display a message to confirm deletion
        JOptionPane.showMessageDialog(this, "Student deleted successfully.");
    }

    private void getStudentByUsn() {
        // Prompt the user to enter the USN of the student to retrieve
        String usn = JOptionPane.showInputDialog(this, "Enter USN of the student to retrieve:");

        // Retrieve the student from the data store
        Student student = studentDAO.getStudentByUsn(usn);

        if (student != null) {
            // Display the student's details
            JOptionPane.showMessageDialog(this, "Student details:\n" + student.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Student with USN " + usn + " not found.");
        }
    }


    private void getAllStudents() {
        // Retrieve all students from the data store
        List<Student> students = studentDAO.getAllStudents();

        // Display all students
        StringBuilder message = new StringBuilder("List of all students:\n");
        for (Student student : students) {
            message.append(student.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, message.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mainimpl().setVisible(true);
            }
        });
    }
}
