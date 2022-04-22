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
    
    
    public static void addStudent(StudentEntry student){
        connection = DBConnection.getConnection();
        try{
            addStudent = connection.prepareStatement("INSERT INTO APP.STUDENTS"
                    + "(STUDENTID, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
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
}
