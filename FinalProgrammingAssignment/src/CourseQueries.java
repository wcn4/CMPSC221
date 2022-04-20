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
    
    public static void addCourse(CourseEntry course){
        connection = DBConnection.getConnection();
        try
        {
            addCourse = connection.prepareStatement("insert into app"); //Look at SQL code 
            
        }
        catch(SQLException e){
            
        }
    }
    
}
