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
    private static PreparedStatement checkIfEntryExists;
    private static PreparedStatement getScheduledStudents;
    private static PreparedStatement getWaitlistedStudents;
    private static PreparedStatement dropSpecificSchedule;
    private static PreparedStatement dropScheduleByCourse;
    private static PreparedStatement updateSchedule;
    
    //Adds a semester entry into the database
    public static void addScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try{
            addScheduleEntry = connection.prepareStatement("INSERT INTO APP.SCHEDULE"
                    + " (SEMESTER, STUDENTID, COURSECODE, STATUS, TIMESTAMP) VALUES (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTimeStamp());
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Grabs all the schedule entries for a given student in for a given semester
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        resultSet = null;
        try{
            getScheduleByStudent = connection.prepareStatement("SELECT * FROM APP.SCHEDULE "
                    + "WHERE SEMESTER=? AND STUDENTID=?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            resultSet = getScheduleByStudent.executeQuery();
            //Adds schedule Entries for each row of data into the arraylist
            while(resultSet.next()){
                schedules.add(new ScheduleEntry(resultSet.getString("SEMESTER"),
                                            resultSet.getString("COURSECODE"),
                                            resultSet.getString("STUDENTID"),
                                            resultSet.getString("STATUS"),
                                            resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return schedules;
    }
    
    //Get the amount of students scheduled in a given course in a semester
    public static int getScheduledStudentCount(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int students = 0;
        resultSet = null;
        resultSetMetaData = null;
        try{
            getScheduledStudentCount = connection.prepareStatement("SELECT count(studentID) FROM app.schedule WHERE semester = ? AND courseCode = ? AND STATUS =?");
            getScheduledStudentCount.setString(1, semester);
            getScheduledStudentCount.setString(2, courseCode);
            getScheduledStudentCount.setString(3, "S");
            resultSet = getScheduledStudentCount.executeQuery();
            resultSet.next();
            students = resultSet.getInt(1);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return students;
    } 
    
    //checks if an entry exists
    public static boolean checkIfEntryExists(String semester, String courseCode, String studentID){
        connection = DBConnection.getConnection();
        int students = 0;
        resultSet = null;
        resultSetMetaData = null;
        try{
            checkIfEntryExists = connection.prepareStatement("SELECT count(*) FROM app.schedule WHERE (semester = ? AND courseCode = ? AND studentID = ?)");
            checkIfEntryExists.setString(1, semester);
            checkIfEntryExists.setString(2, courseCode);
            checkIfEntryExists.setString(3, studentID);
            resultSet = checkIfEntryExists.executeQuery();
            resultSet.next();
            
            //If count is 1, then there must be at least 1 course
            //Only if it is 1 since cannot have duplicate keys
            return (resultSet.getInt(1) == 1);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        resultSet = null;
        try{
            getScheduledStudents = connection.prepareStatement("SELECT * FROM APP.SCHEDULE"
                    + " WHERE SEMESTER=? AND COURSECODE=? AND STATUS=?");
            getScheduledStudents.setString(1, semester);
            getScheduledStudents.setString(2, courseCode);
            getScheduledStudents.setString(3, "S");
            resultSet = getScheduledStudents.executeQuery();
            while(resultSet.next()){
                schedules.add(new ScheduleEntry(resultSet.getString("SEMESTER"),
                                            resultSet.getString("COURSECODE"),
                                            resultSet.getString("STUDENTID"),
                                            resultSet.getString("STATUS"),
                                            resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return schedules;
        
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedules = new ArrayList<ScheduleEntry>();
        resultSet = null;
        try{
            getWaitlistedStudents = connection.prepareStatement("SELECT * FROM APP.SCHEDULE"
                    + " WHERE SEMESTER=? AND COURSECODE=? AND STATUS=? ORDER BY TIMESTAMP ASC");
            getWaitlistedStudents.setString(1, semester);
            getWaitlistedStudents.setString(2, courseCode);
            getWaitlistedStudents.setString(3, "W");
            resultSet = getWaitlistedStudents.executeQuery();
            while(resultSet.next()){
                schedules.add(new ScheduleEntry(resultSet.getString("SEMESTER"),
                                            resultSet.getString("COURSECODE"),
                                            resultSet.getString("STUDENTID"),
                                            resultSet.getString("STATUS"),
                                            resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return schedules;
        
    }
    
    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode){
        connection = DBConnection.getConnection();
        try{
            dropSpecificSchedule = connection.prepareStatement("DELETE FROM APP.SCHEDULE"
                    + " WHERE SEMESTER=? AND STUDENTID=? AND COURSECODE=?");
            dropSpecificSchedule.setString(1, semester);
            dropSpecificSchedule.setString(2, studentID);
            dropSpecificSchedule.setString(3, courseCode);
            dropSpecificSchedule.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        try{
            dropScheduleByCourse = connection.prepareStatement("DELETE FROM APP.SCHEDULE"
                    + " WHERE SEMESTER=? AND COURSECODE=?");
            dropScheduleByCourse.setString(1, semester);
            dropScheduleByCourse.setString(2, courseCode);
            dropScheduleByCourse.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Sets Status to S
    public static void updateScheduleEntry(String semester, ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try{
            updateSchedule = connection.prepareStatement("UPDATE APP.SCHEDULE"
                    + " SET STATUS=? WHERE SEMESTER=? AND STUDENTID=? AND COURSECODE=?");
            updateSchedule.setString(1, "S");
            updateSchedule.setString(2, semester);
            updateSchedule.setString(3, entry.getStudentID());
            updateSchedule.setString(4, entry.getCourseCode());
            updateSchedule.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
