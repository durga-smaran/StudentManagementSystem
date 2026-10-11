package com.smaran.dao;

import com.smaran.Student;
import com.smaran.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO 
{

    public void addStudent(Student student) 
    {

        String sql = "INSERT INTO students (name, age, email, course) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) 
        {

            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getCourse());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public void viewAllStudents() 
    {

        String sql = "SELECT * FROM students";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) 
        {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) 
            {

                System.out.println
                (
                        resultSet.getInt("id") + " | " +
                        resultSet.getString("name") + " | " +
                        resultSet.getInt("age") + " | " +
                        resultSet.getString("email") + " | " +
                        resultSet.getString("course")
                );
            }

        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public void searchStudent(int id) 
    {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) 
        {

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) 
            {

                System.out.println
                (
                        resultSet.getInt("id") + " | " +
                        resultSet.getString("name") + " | " +
                        resultSet.getInt("age") + " | " +
                        resultSet.getString("email") + " | " +
                        resultSet.getString("course")
                );

            } 
            else 
            {
                System.out.println("Student not found!");
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public void updateStudent(int id, String name, int age, String email, String course) 
    {

        String sql = "UPDATE students SET name = ?, age = ?, email = ?, course = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) 
        {

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setString(3, email);
            statement.setString(4, course);
            statement.setInt(5, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) 
            {
                System.out.println("Student updated successfully!");
            } 
            else 
            {
                System.out.println("Student not found!");
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public void deleteStudent(int id) 
    {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) 
        {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) 
            {
                System.out.println("Student deleted successfully!");
            } 
            else 
            {
                System.out.println("Student not found!");
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}