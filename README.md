# 🧑‍🎓 Student Database Management System (Java CLI)

A **console-based student management system** developed using Java. It uses the **DAO (Data Access Object) design pattern** to perform CRUD operations on student records. The application maintains data in-memory using `ArrayList` and provides a menu-driven command-line interface.

---

## 📂 Project Files

| File Name              | Description |
|------------------------|-------------|
| `Mainimpl.java`        | Entry point with CLI-based menu system |
| `Student.java`         | POJO class containing student attributes |
| `StudentDAO.java`      | DAO interface with method declarations |
| `StudentDAOImpl.java`  | Implements the DAO logic using ArrayList |

---

## 🧠 Core Components

### 1. Student.java
- A basic Java class (POJO) that contains:
  - `int id`
  - `String name`
  - `String dept`
  - `String email`
- Includes constructor, getter, setter, and `toString()` method.

### 2. StudentDAO.java
- An interface defining the following methods:
```java
void addStudent(Student s);
void deleteStudent(int id);
void updateStudent(int id, Student s);
List<Student> getAllStudents();
Student getStudentById(int id);
```

### 3. StudentDAOImpl.java
- Implements `StudentDAO` using an `ArrayList<Student>` as an in-memory database.
- Methods:
  - `addStudent()`: Adds a new student.
  - `deleteStudent()`: Deletes a student by ID.
  - `updateStudent()`: Updates a student by ID.
  - `getAllStudents()`: Returns list of all students.
  - `getStudentById()`: Returns a student by ID.

### 4. Mainimpl.java
- Provides a command-line interface using `Scanner`.
- Displays menu:
```
1. Add Student
2. Delete Student
3. Update Student
4. View All Students
5. Get Student by ID
6. Exit
```
- Reads user input and calls appropriate methods.

---

## ✅ Features

- Add new student
- Delete student by ID
- Update existing student details
- View all student records
- Retrieve student by ID
- Menu-based interaction

---

## 🚀 How to Run

1. Compile all Java files:
```bash
javac *.java
```

2. Run the main class:
```bash
java Mainimpl
```

---

## 📌 Sample Execution

```text
--- Student Management System ---
1. Add Student
2. Delete Student
3. Update Student
4. View All Students
5. Get Student by ID
6. Exit
Enter your choice:
```

---

## 🔧 Suggestions for Enhancement

- Use file or database (MySQL) for persistent storage.
- Add input validation (e.g., for email format).
- Implement GUI using JavaFX or Swing.
- Add unit tests for DAO logic.

---

## 👨‍💻 Author

Developed by [Your Name]

---

## 📄 License

Open-source project for learning and academic purposes.
