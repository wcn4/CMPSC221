/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bill4
 */
public class StudentEntry {


    
    private final String studentID;
    private final String firstName;
    private final String lastName;
    
    public StudentEntry(String StudentID, String firstName, String lastName){
        this.studentID = StudentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
