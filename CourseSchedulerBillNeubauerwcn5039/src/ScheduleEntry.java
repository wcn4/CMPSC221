/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bill4
 */
import java.sql.Timestamp;

public class ScheduleEntry {
    
    private final String semester;
    private final String courseCode;
    private final String studentID;
    private final String status;
    private final Timestamp timeStamp;
    
    public ScheduleEntry(String semester, String courseCode, String studentID, String status, Timestamp timeStamp){
        this.semester = semester;
        this.courseCode = courseCode;
        this.studentID = studentID;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    
}
