/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bill4
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentQueries {
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement addStudent;
    private static PreparedStatement getAllStudents;
    private static PreparedStatement getStudent;
    private static PreparedStatement dropStudent;
    
    //Adds a student into the database
    public static void addStudent(StudentEntry student){
        connection = DBConnection.getConnection();
        try{
            addStudent = connection.prepareStatement("INSERT INTO APP.STUDENTS"
                    + " (STUDENTID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Grabs all students from the database
    public static ArrayList<StudentEntry> getAllStudents(){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        resultSet = null;
        try{
            getAllStudents = connection.prepareStatement("SELECT * FROM APP.STUDENTS");
            resultSet = getAllStudents.executeQuery();
            while(resultSet.next()){
                students.add(new StudentEntry(resultSet.getString(1), 
                                resultSet.getString(2), 
                                resultSet.getString(3)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    }
    
    public static StudentEntry getStudent(String studentID){
        connection = DBConnection.getConnection();
        resultSet = null;
        try{
            getStudent = connection.prepareStatement("SELECT * FROM APP.STUDENTS"
                    + " WHERE STUDENTID=?");
            getStudent.setString(1, studentID);
            resultSet = getStudent.executeQuery();
            resultSet.next();
            return new StudentEntry(resultSet.getString("STUDENTID"), resultSet.getString("FIRSTNAME"), resultSet.getString("LASTNAME"));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return new StudentEntry("Error", "Error", "Error");
    }
    
    public static void dropStudent(String studentID){
        connection=DBConnection.getConnection();
        try{
            dropStudent = connection.prepareStatement("DELETE FROM APP.STUDENTS"
                    + " WHERE STUDENTID=?");
            dropStudent.setString(1, studentID);
            dropStudent.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
