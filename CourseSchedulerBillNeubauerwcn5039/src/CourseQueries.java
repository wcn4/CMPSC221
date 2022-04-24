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


public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement getAllCourses;
    private static PreparedStatement getAllCourseCodes;
    private static PreparedStatement getCourseSeats;
    private static PreparedStatement dropCourse;
    private static ResultSet resultSet;
    
    //Adds a course to the database
    public static void addCourse(CourseEntry course){
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("INSERT INTO app.courses"
                    + " (SEMESTER, COURSECODE, DESCRIPTION, SEATS) VALUES (?, ?, ?, ?)"); 
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setString(3, course.getDescription());
            addCourse.setInt(4, course.getSeats());
            addCourse.executeUpdate();
            
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
    }
    
    //Grabs all courses for a given semester
    public static ArrayList<CourseEntry> getAllCourses(String semester){
        connection = DBConnection.getConnection();
        ArrayList<CourseEntry> courses = new ArrayList<CourseEntry>();
        resultSet = null;
        try
        {
            getAllCourses = connection.prepareStatement("SELECT * FROM APP.COURSES "
                    + "WHERE SEMESTER=? ORDER BY SEATS");
            getAllCourses.setString(1, semester);
            resultSet = getAllCourses.executeQuery();
            //Create a CourseEntry for each row and insert into the ArrayList 
            while(resultSet.next()){
                courses.add(new CourseEntry(resultSet.getString(1),
                        resultSet.getString(2), 
                        resultSet.getString(3),
                        resultSet.getInt(4)));
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return courses;   
    }
    
    //Grabs all courseCodes for a given semester
    public static ArrayList<String> getAllCourseCodes(String semester){
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        resultSet = null;
        try{
            getAllCourseCodes = connection.prepareStatement("SELECT * FROM APP.COURSES "
            + "WHERE SEMESTER=? ORDER BY COURSECODE");
            getAllCourseCodes.setString(1, semester);
            resultSet = getAllCourseCodes.executeQuery();
            //Adds each string to the ArrayList
            while(resultSet.next()){
                courseCodes.add(resultSet.getString("COURSECODE"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return courseCodes;
    }
    
    //Get the amount of seats for a course in a given semester
    public static int getCourseSeats(String semester, String courseCode){
        connection = DBConnection.getConnection();
        resultSet = null;
        try{
            getCourseSeats = connection.prepareStatement("SELECT * FROM APP.COURSES"
                    + " WHERE SEMESTER=? AND COURSECODE=?" );
            getCourseSeats.setString(1, semester);
            getCourseSeats.setString(2, courseCode);
            resultSet = getCourseSeats.executeQuery();
            resultSet.next();
            return resultSet.getInt(4);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
    
    
    
    
}
