# Student Database Management System

## 📌 Overview

This is a **Student Database Management System** developed using Python and SQLite. It provides a simple and interactive Graphical User Interface (GUI) built with `Tkinter` that allows users (typically school or college administrators) to manage student information efficiently.

Key functionalities include:
- Adding new student records
- Updating existing records
- Deleting student entries
- Searching student data
- Viewing all stored student records

This system is ideal for educational institutions seeking to manage basic student data locally with a lightweight interface.

---

## 🛠 Features

- 📝 **Add Student**: Enter and store student details like name, roll number, email, gender, contact, date of birth, and address.
- 🔍 **Search Student**: Search for students based on various criteria (e.g., roll number, name).
- 🗃 **Display All**: Retrieve and display all student records.
- ✏️ **Update Record**: Modify existing student information.
- 🗑 **Delete Record**: Remove a student entry from the database.
- ♻️ **Clear Fields**: Reset input fields for new entries.

---

## 📂 Project Structure

Student-Database-Management-System/
├── student.py # Main application script with GUI
├── student.db # SQLite database file (auto-generated after first run)
├── icon.ico # App icon used in the window
└── README.md # Project documentation

> Note: The database (`student.db`) will be generated upon first use if it doesn't exist.

---

## 🔧 Requirements

- Python 3.x
- Tkinter (usually pre-installed with Python)
- SQLite3 (standard Python library)

Install any missing modules using pip:

```bash
pip install tk
