package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String DB_URL = "jdbc:sqlite:Project.sqlite";

    private Connection connection;

    public StudentDAOImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            createTableIfNotExists();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Btech_22 (" +
                "USN TEXT PRIMARY KEY," +
                "Name TEXT NOT NULL," +
                "Email TEXT," +
                "Section TEXT," +
                "Sex TEXT," +
                "DoB TEXT," +
                "Height_cm INTEGER," +
                "Weight_Kg INTEGER," +
                "Home_State TEXT," +
                "Home_Town TEXT," +
                "Mother_Tongue TEXT," +
                "Elective TEXT," +
                "Clubs TEXT" +
                ")";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO Btech_22 (USN, Name, Email, Section, Sex, DoB, Height_cm, " +
                "Weight_Kg, Home_State, Home_Town, Mother_Tongue, Elective, Clubs) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getUsn());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getSection());
            preparedStatement.setString(5, student.getSex());
            preparedStatement.setString(6, student.getDoB());
            preparedStatement.setInt(7, student.getHeightCm());
            preparedStatement.setInt(8, student.getWeightKg());
            preparedStatement.setString(9, student.getHomeState());
            preparedStatement.setString(10, student.getHomeTown());
            preparedStatement.setString(11, student.getMotherTongue());
            preparedStatement.setString(12, student.getElective());
            preparedStatement.setString(13, student.getClubs());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStudent(String usn, Student student) {
        String sql = "UPDATE Btech_22 SET Name=?, Email=?, Section=?, Sex=?, DoB=?, Height_cm=?, " +
                "Weight_Kg=?, Home_State=?, Home_Town=?, Mother_Tongue=?, Elective=?, Clubs=? WHERE USN=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getSection());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setString(5, student.getDoB());
            preparedStatement.setInt(6, student.getHeightCm());
            preparedStatement.setInt(7, student.getWeightKg());
            preparedStatement.setString(8, student.getHomeState());
            preparedStatement.setString(9, student.getHomeTown());
            preparedStatement.setString(10, student.getMotherTongue());
            preparedStatement.setString(11, student.getElective());
            preparedStatement.setString(12, student.getClubs());
            preparedStatement.setString(13, usn);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(String usn) {
        String sql = "DELETE FROM Btech_22 WHERE USN=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usn);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentByUsn(String usn) {
        String sql = "SELECT * FROM Btech_22 WHERE USN=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, usn);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getString("USN"),
                            resultSet.getString("Name"),
                            resultSet.getString("Email"),
                            resultSet.getString("Section"),
                            resultSet.getString("Sex"),
                            resultSet.getString("DoB"),
                            resultSet.getInt("Height_cm"),
                            resultSet.getInt("Weight_Kg"),
                            resultSet.getString("Home_State"),
                            resultSet.getString("Home_Town"),
                            resultSet.getString("Mother_Tongue"),
                            resultSet.getString("Elective"),
                            resultSet.getString("Clubs")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Btech_22";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString("USN"),
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getString("Section"),
                        resultSet.getString("Sex"),
                        resultSet.getString("DoB"),
                        resultSet.getInt("Height_cm"),
                        resultSet.getInt("Weight_Kg"),
                        resultSet.getString("Home_State"),
                        resultSet.getString("Home_Town"),
                        resultSet.getString("Mother_Tongue"),
                        resultSet.getString("Elective"),
                        resultSet.getString("Clubs")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}