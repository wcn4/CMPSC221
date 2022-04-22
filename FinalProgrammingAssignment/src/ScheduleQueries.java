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
import java.sql.Timestamp;
import java.sql.ResultSetMetaData;

public class ScheduleQueries {
    private static Connection connection;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduledStudentCount;
    
    public static void addScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try{
            addScheduleEntry = connection.prepareStatement("INSERT INTO APP.SCHEDULE"
                    + " (SEMESTER, STUDENTID, COURSECODE, STATUS, TIMESTAMP) VALUES (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        resultSet = null;
        try{
            getScheduleByStudent = connection.prepareStatement("SELECT * FROM APP.SCHEDULE"
                    + "WHERE SEMESTER=? AND STUDENTID=?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            resultSet = getScheduleByStudent.executeQuery();
            while(resultSet.next()){
                //Probably not the right order as of now so will need to be fixed later
                schedules.add(new ScheduleEntry(resultSet.getString(1),
                                            resultSet.getString(2),
                                            resultSet.getString(3),
                                            resultSet.getString(4),
                                            resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return schedules;
    }
    
    public static int getScheduledStudentCount(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int students = 0;
        resultSet = null;
        resultSetMetaData = null;
        try{
            getScheduledStudentCount = connection.prepareStatement("SELECT * FROM APP.SEMESTER"
                    + "WHERE SEMESTER=? AND COURSECODE=?");
            getScheduledStudentCount.setString(1, semester);
            getScheduledStudentCount.setString(2, courseCode);
            resultSet = getScheduledStudentCount.executeQuery();
            resultSetMetaData = resultSet.getMetaData();
            students = resultSetMetaData.getColumnCount();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    } 
}
