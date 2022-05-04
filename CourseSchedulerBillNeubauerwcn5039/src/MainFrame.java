
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author acv
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String currentSemester; 
    
    public MainFrame() {
        initComponents();
        rebuildSemesterComboBoxes();
        //rebuildScheduleCourseComboBoxes();
        //rebuildDisplayScheduleComboBoxes();
        rebuildStudentComboBoxes();
        rebuildCourseComboBoxes();
        updateDisplayCourses();
        updateDisplaySchedule();
    }
    
    public void rebuildSemesterComboBoxes()
    {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        if (semesters.size() > 0)
        {
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        }
        else
        {
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }
    /*
    public void rebuildScheduleCourseComboBoxes(){
        //Grabs all courses and students and rebuilds comboboxes with that info
        ArrayList<String> courses = CourseQueries.getAllCourseCodes(currentSemester);
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        scheduleCoursesCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        scheduleCoursesStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
    }
    
    public void rebuildDisplayScheduleComboBoxes(){
        //Grabs all students and rebuilds comboboxes with that info
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        displayScheduleStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
    }
    */
    
    public void rebuildStudentComboBoxes(){
        ArrayList<StudentEntry> students = StudentQueries.getAllStudents();
        displayScheduleStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        scheduleCoursesStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray())); 
        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
        studentDropCourseStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(students.toArray()));
    }
    
    public void rebuildCourseComboBoxes(){
        ArrayList<String> courses = CourseQueries.getAllCourseCodes(currentSemester);
        scheduleCoursesCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray())); 
        displayCourseListComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        dropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
        studentDropCourseCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
    }
    
    public void updateDisplaySchedule(){
        //Take the selected Student in the combo box (uf there aren't any students, terminate)
        StudentEntry selectedStudent = (StudentEntry)displayScheduleStudentsComboBox.getSelectedItem();
        if (selectedStudent == null){
            displayScheduleTextArea.setText("Course Code\tStatus\n");
            return;
        }
        //Grab all scheduled courses for that student, and create a string containing
        //All their courses, and set that as the text
        ArrayList<ScheduleEntry> schedules = ScheduleQueries.getScheduleByStudent(currentSemester, selectedStudent.getStudentID());
        String message = "Course Code\tStatus\n";
        for (ScheduleEntry schedule:schedules){
            message = String.format("%s%s\t%s\n", message, schedule.getCourseCode(), 
                    (schedule.getStatus().equals("S")) ? "Scheduled":"Waitlisted");
        }
        displayScheduleTextArea.setText(message);
    }
    
    public void updateDisplayCourses(){
        //Grabs all courses for the current semester and creates a string to be
        //displayed in a text Area
        ArrayList<CourseEntry> courses = CourseQueries.getAllCourses(currentSemester);
        String message = "Course Code\tSeats\tDescription\n";
        
        for(CourseEntry course:courses){
            message = String.format("%s%s\t%d\t%s\n", message, course.getCourseCode(),
                    course.getSeats(), course.getDescription());
            
        }
        displayCoursesTextArea.setText(message);
    }
    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        courseCodeTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        seatsSpinner = new javax.swing.JSpinner();
        addCourseButton = new javax.swing.JButton();
        addCourseOutputLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();
        addStudentOutputLabel = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        displayCourseListComboBox = new javax.swing.JComboBox<>();
        displayScheduledStudentsButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scheduledStudentsTextArea = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        waitlistedStudentsTextArea = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        dropStudentComboBox = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        dropStudentTextArea = new javax.swing.JTextArea();
        dropStudentButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        dropCourseComboBox = new javax.swing.JComboBox<>();
        dropCourseButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        dropCourseTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        scheduleCoursesPanel = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayCoursesTextArea = new javax.swing.JTextArea();
        displayCoursesButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        scheduleCoursesCoursesComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        scheduleCoursesStudentsComboBox = new javax.swing.JComboBox<>();
        scheduleCourseButton = new javax.swing.JButton();
        scheduleCoursesOutputLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        displayScheduleStudentsComboBox = new javax.swing.JComboBox<>();
        displayScheduleButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayScheduleTextArea = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        studentDropCourseCourseComboBox = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        studentDropCourseStudentComboBox = new javax.swing.JComboBox<>();
        studentDropCourseButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        studentDropCourseTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Scheduler");

        jLabel3.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(addSemesterSubmitButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(addSemesterStatusLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Semester", jPanel3);

        jLabel4.setText("Course Code:");

        courseCodeTextField.setColumns(20);

        jLabel5.setText("Description:");

        descriptionTextField.setColumns(30);

        jLabel6.setText("Seats:");

        seatsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        addCourseButton.setText("Submit");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addCourseButton)
                            .addComponent(courseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addCourseOutputLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(courseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(seatsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseOutputLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Course", jPanel4);

        jLabel7.setText("Student ID:");

        studentIDTextField.setColumns(20);

        jLabel8.setText("First Name:");

        firstNameTextField.setColumns(20);

        jLabel9.setText("Last Name:");

        lastNameTextField.setColumns(20);

        addStudentButton.setText("Submit");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentButton)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addStudentOutputLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addStudentButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addStudentOutputLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Add Student", jPanel5);

        jLabel13.setText("Select Course:");

        displayCourseListComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        displayScheduledStudentsButton.setText("Display");
        displayScheduledStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduledStudentsButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Scheduled Students:");

        scheduledStudentsTextArea.setEditable(false);
        scheduledStudentsTextArea.setColumns(20);
        scheduledStudentsTextArea.setRows(5);
        jScrollPane3.setViewportView(scheduledStudentsTextArea);

        jLabel15.setText("Waitlisted Students:");

        waitlistedStudentsTextArea.setEditable(false);
        waitlistedStudentsTextArea.setColumns(20);
        waitlistedStudentsTextArea.setRows(5);
        jScrollPane4.setViewportView(waitlistedStudentsTextArea);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayCourseListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayScheduledStudentsButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayCourseListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayScheduledStudentsButton)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(60, 60, 60))
        );

        jTabbedPane2.addTab("Display Course List by Students", jPanel9);

        jLabel16.setText("Select Student:");

        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropStudentTextArea.setEditable(false);
        dropStudentTextArea.setColumns(20);
        dropStudentTextArea.setRows(5);
        jScrollPane5.setViewportView(dropStudentTextArea);

        dropStudentButton.setText("Display");
        dropStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropStudentButton))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(dropStudentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Student", jPanel10);

        jLabel17.setText("Select Course:");

        dropCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropCourseButton.setText("Drop Course");
        dropCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCourseButtonActionPerformed(evt);
            }
        });

        dropCourseTextArea.setEditable(false);
        dropCourseTextArea.setColumns(20);
        dropCourseTextArea.setRows(5);
        jScrollPane6.setViewportView(dropCourseTextArea);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dropCourseButton)))
                .addContainerGap(372, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(dropCourseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Drop Course", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Admin", jPanel1);

        displayCoursesTextArea.setEditable(false);
        displayCoursesTextArea.setColumns(20);
        displayCoursesTextArea.setRows(5);
        displayCoursesTextArea.setText("Course Code\tSeats\tDescription");
        jScrollPane1.setViewportView(displayCoursesTextArea);

        displayCoursesButton.setText("Display");
        displayCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCoursesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayCoursesButton)
                .addGap(0, 263, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(displayCoursesButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                        .addGap(40, 40, 40))))
        );

        scheduleCoursesPanel.addTab("Display Courses", jPanel6);

        jLabel10.setText("Select Course:");

        scheduleCoursesCoursesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Select Student: ");

        scheduleCoursesStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        scheduleCourseButton.setText("Submitt");
        scheduleCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleCourseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scheduleCourseButton)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scheduleCoursesCoursesComboBox, 0, 113, Short.MAX_VALUE)
                                .addComponent(scheduleCoursesStudentsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(scheduleCoursesOutputLabel))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scheduleCoursesCoursesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(scheduleCoursesStudentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleCourseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleCoursesOutputLabel)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        scheduleCoursesPanel.addTab("Schedule Courses", jPanel7);

        jLabel12.setText("Select Student");

        displayScheduleStudentsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        displayScheduleButton.setText("Display");
        displayScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayScheduleButtonActionPerformed(evt);
            }
        });

        displayScheduleTextArea.setEditable(false);
        displayScheduleTextArea.setColumns(20);
        displayScheduleTextArea.setRows(5);
        displayScheduleTextArea.setText("Course Code\tStatus");
        jScrollPane2.setViewportView(displayScheduleTextArea);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(displayScheduleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayScheduleStudentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 338, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayScheduleStudentsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayScheduleButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scheduleCoursesPanel.addTab("Display Schedule", jPanel8);

        jLabel18.setText("Select Course:");

        studentDropCourseCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Select Student:");

        studentDropCourseStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        studentDropCourseButton.setText("Drop Course");
        studentDropCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropCourseButtonActionPerformed(evt);
            }
        });

        studentDropCourseTextArea.setEditable(false);
        studentDropCourseTextArea.setColumns(20);
        studentDropCourseTextArea.setRows(5);
        jScrollPane7.setViewportView(studentDropCourseTextArea);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentDropCourseCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentDropCourseStudentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(studentDropCourseButton)))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(studentDropCourseCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(studentDropCourseStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentDropCourseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        scheduleCoursesPanel.addTab("Drop Course", jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scheduleCoursesPanel)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scheduleCoursesPanel)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        jLabel2.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(changeSemesterButton)
                                .addGap(80, 80, 80)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        //Creates semester and refreshes all info
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
        //rebuildScheduleCourseComboBoxes();
        //updateDisplayCourses();
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    //Requesting a course to be added to the database
    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseButtonActionPerformed
        //Grabs information about the course
        String courseCode = courseCodeTextField.getText();
        String description = descriptionTextField.getText();
        int seats = (int)seatsSpinner.getValue();
        //There is no current semester, display error message.
        if (currentSemester.length() <= 0){
            addCourseOutputLabel.setText("No semester selected");
            return;
        }
        try{
            //Create the course, and update comboboxes and info as needed
            CourseQueries.addCourse(new CourseEntry(currentSemester, courseCode,
                                description, seats));
            addCourseOutputLabel.setText(courseCode + " has been added.");
            //rebuildScheduleCourseComboBoxes();
            //rebuildDisplayScheduleComboBoxes();
            rebuildCourseComboBoxes();
            updateDisplayCourses();
            updateDisplaySchedule();
        }
        catch(Exception e){
            addCourseOutputLabel.setText("An error has occurred. ");
        }
        
    }//GEN-LAST:event_addCourseButtonActionPerformed

    //Updates the semester based on the value of the combo box
    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        String selected = (String)currentSemesterComboBox.getSelectedItem();
        if (selected.length() > 0)
        {
            currentSemesterLabel.setText(selected);
            currentSemester = selected;
        }
        //Updates the combo boxes as necessary
        updateDisplayCourses();
        //rebuildScheduleCourseComboBoxes();
        rebuildCourseComboBoxes();
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        //Grab info necessary about a student
        String studentID = studentIDTextField.getText();
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        if (currentSemester.length() <= 0){
            addStudentOutputLabel.setText("No semester selected");
            return;
        }
        //Create student and update labels as needed
        StudentQueries.addStudent(new StudentEntry(studentID, firstName, lastName));
        addStudentOutputLabel.setText(lastName + ", " + firstName + " has been added");
        //rebuildScheduleCourseComboBoxes();
        //rebuildDisplayScheduleComboBoxes();
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void displayCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCoursesButtonActionPerformed
        updateDisplayCourses();
    }//GEN-LAST:event_displayCoursesButtonActionPerformed

    private void scheduleCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleCourseButtonActionPerformed
        //Grabs the info necessary to create a schedule entry
        StudentEntry selectedStudent = (StudentEntry)scheduleCoursesStudentsComboBox.getSelectedItem();
        String courseCode = (String)scheduleCoursesCoursesComboBox.getSelectedItem();
        //If the amount of students scheduled in the course is less than the capacity
        //Then the student can schedule the course, otherwise they are waitlsited
        String status = (ScheduleQueries.getScheduledStudentCount(currentSemester, courseCode) < 
                CourseQueries.getCourseSeats(currentSemester, courseCode)) ? "S":"W"; 
        //Grab current time
        Timestamp time = new Timestamp(java.util.Calendar.getInstance().getTime().getTime());
        //Create Schedule
        ScheduleEntry schedule = new ScheduleEntry(currentSemester, courseCode, 
                selectedStudent.getStudentID(), status, time);
        String message = "";
        //Only create entry if the entry does not already exist
        if (!ScheduleQueries.checkIfEntryExists(currentSemester, courseCode, selectedStudent.getStudentID())){
            ScheduleQueries.addScheduleEntry(schedule);
            message = (status == "S") ? (selectedStudent + " has been scheduled for " + courseCode) : (selectedStudent + " has been waitlisted for " + courseCode);
            //rebuildScheduleCourseComboBoxes();
            //rebuildDisplayScheduleComboBoxes();
            updateDisplayCourses();
            updateDisplaySchedule();
            
        }
        else{
            message = selectedStudent + " has already requested to join " + courseCode;
        }
        
        scheduleCoursesOutputLabel.setText(message);
    }//GEN-LAST:event_scheduleCourseButtonActionPerformed

    private void displayScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduleButtonActionPerformed
        updateDisplaySchedule();
    }//GEN-LAST:event_displayScheduleButtonActionPerformed

    private void displayScheduledStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayScheduledStudentsButtonActionPerformed
        String courseCode = (String)displayCourseListComboBox.getSelectedItem();
        
        //Update the textboxes
        ArrayList<ScheduleEntry> scheduledStudents = ScheduleQueries.getScheduledStudentsByCourse(currentSemester, courseCode);
        ArrayList<ScheduleEntry> waitlistedStudents = ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, courseCode);
        String scheduledStudentsMessage = "Last Name\tFirst Name\tStudent ID\n";
        String waitlistedStudentsMessage = "Last Name\tFirst Name\tStudent ID\n";
        //For every student that has been scheduled, display their lastname, firstname, and student id
        for (ScheduleEntry schedule:scheduledStudents){
            StudentEntry student = StudentQueries.getStudent(schedule.getStudentID());
            scheduledStudentsMessage = String.format("%s%s\t%s\t%s\n", scheduledStudentsMessage,
                    student.getLastName(), student.getFirstName(), student.getStudentID());
        }
        //For every student that has been waitlisted, display their lastname, firstname, and student id
         for (ScheduleEntry schedule:waitlistedStudents){
            StudentEntry student = StudentQueries.getStudent(schedule.getStudentID());
            waitlistedStudentsMessage = String.format("%s%s\t%s\t%s\n", waitlistedStudentsMessage,
                    student.getLastName(), student.getFirstName(), student.getStudentID());
        }
        
        scheduledStudentsTextArea.setText(scheduledStudentsMessage);
        waitlistedStudentsTextArea.setText(waitlistedStudentsMessage);
    }//GEN-LAST:event_displayScheduledStudentsButtonActionPerformed

    private void dropStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentButtonActionPerformed
        //Get the Student Selected
        //For Each Semester
            //Drop all courses they are enrolled in
            //Drop all courses they are waitlisted in
            //Check if there are any students that can be enrolled after that student is dropped
        StudentEntry student = (StudentEntry)dropStudentComboBox.getSelectedItem();
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        String message = "";
        message = String.format("%s has been dropped from the list of students\n", student);
        
        //Drop the student from the queries
        StudentQueries.dropStudent(student.getStudentID());
        
        //For every semester that student was enrolled in 
        for (String semester:semesters){
            //Get every course they were enrolled or waitlisted in
            ArrayList<ScheduleEntry> schedules = ScheduleQueries.getScheduleByStudent(semester, student.getStudentID());
            message = String.format("%s\nFor Semester: %s\n", message, semester);
            
            for (ScheduleEntry schedule:schedules){
                //Drop the student from the course
                ScheduleQueries.dropStudentScheduleByCourse(semester, student.getStudentID(), schedule.getCourseCode());
                
                //Change label if they were on the waitlist
                if (schedule.getStatus().equals("W")){
                    message = String.format("%s%s has been dropped from the waitlist for %s\n", message, student, schedule.getCourseCode());
                    
                    continue;
                }
                
                message = String.format("%s%s has been dropped from %s\n", message, student, schedule.getCourseCode());
                
                ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudentsByCourse(semester, schedule.getCourseCode());
                //If there are waitlisted students and the amount of students scheduled is less than the course seats
                
                if (!waitlisted.isEmpty() && 
                        ScheduleQueries.getScheduledStudentCount(semester, schedule.getCourseCode()) < CourseQueries.getCourseSeats(semester, schedule.getCourseCode())){
                    //Create the updated schedule entry for the person at the top of the waitlist (such that they are scheduled)
                    ScheduleEntry updatedSchedule = new ScheduleEntry(semester, waitlisted.get(0).getCourseCode(), 
                            waitlisted.get(0).getStudentID(), "S", waitlisted.get(0).getTimeStamp());
                    //Update the table
                    ScheduleQueries.updateScheduleEntry(semester, updatedSchedule);
                    message = String.format("%s%s has been scheduled into %s\n", message, StudentQueries.getStudent(updatedSchedule.getStudentID()), updatedSchedule.getCourseCode());
                    
                }
                
                
                
            }
            
            rebuildStudentComboBoxes();
        }
        dropStudentTextArea.setText(message);
    }//GEN-LAST:event_dropStudentButtonActionPerformed

    private void dropCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropCourseButtonActionPerformed
        String courseCode = (String)dropCourseComboBox.getSelectedItem();
        //Grab the scheduled and waitlisted Entries
        ArrayList<ScheduleEntry> scheduledEntries = ScheduleQueries.getScheduledStudentsByCourse(currentSemester, courseCode);
        ArrayList<ScheduleEntry> waitlistedEntries = ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, courseCode);
        String message = "Scheduled Students dropped from the course:\n";
        //Drop the course
        CourseQueries.dropCourse(currentSemester, courseCode);
        
        //List out which students will be dropped
        for (ScheduleEntry schedule:scheduledEntries){
            StudentEntry student = StudentQueries.getStudent(schedule.getStudentID());
            message = String.format("%s%s\n", message, student);
        }
        message = String.format("%s\nWaitlisted students dropped from the course:\n", message);
        //List out which students from the waitlist will be dropped.
        for(ScheduleEntry schedule:waitlistedEntries){
            StudentEntry student = StudentQueries.getStudent(schedule.getStudentID());
            message = String.format("%s%s\n", message, student);
        }
        //Actually remove the course
        ScheduleQueries.dropScheduleByCourse(currentSemester, courseCode);
        dropCourseTextArea.setText(message);
        rebuildCourseComboBoxes();
    }//GEN-LAST:event_dropCourseButtonActionPerformed

    private void studentDropCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropCourseButtonActionPerformed
        StudentEntry student = (StudentEntry)studentDropCourseStudentComboBox.getSelectedItem();
        String courseCode = (String)studentDropCourseCourseComboBox.getSelectedItem();
        String message = "";
        
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, student.getStudentID(), courseCode);
        
        message = String.format("%s%s has been dropped from %s\n", message, student, courseCode);
                
        ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudentsByCourse(currentSemester, courseCode);
        //If there are waitlisted students and the amount of students scheduled is less than the course seats

        if (!waitlisted.isEmpty() && 
                ScheduleQueries.getScheduledStudentCount(currentSemester, courseCode) < CourseQueries.getCourseSeats(currentSemester, courseCode)){
            //Create the updated schedule entry for the person at the top of the waitlist (such that they are scheduled)
            ScheduleEntry updatedSchedule = new ScheduleEntry(currentSemester, waitlisted.get(0).getCourseCode(), 
                    waitlisted.get(0).getStudentID(), "S", waitlisted.get(0).getTimeStamp());
            //Update the table
            ScheduleQueries.updateScheduleEntry(currentSemester, updatedSchedule);
            message = String.format("%s%s has been scheduled into %s\n", message, StudentQueries.getStudent(updatedSchedule.getStudentID()), updatedSchedule.getCourseCode());

        }
        studentDropCourseTextArea.setText(message);
        
    }//GEN-LAST:event_studentDropCourseButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseButton;
    private javax.swing.JLabel addCourseOutputLabel;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel addStudentOutputLabel;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JTextField courseCodeTextField;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JComboBox<String> displayCourseListComboBox;
    private javax.swing.JButton displayCoursesButton;
    private javax.swing.JTextArea displayCoursesTextArea;
    private javax.swing.JButton displayScheduleButton;
    private javax.swing.JComboBox<String> displayScheduleStudentsComboBox;
    private javax.swing.JTextArea displayScheduleTextArea;
    private javax.swing.JButton displayScheduledStudentsButton;
    private javax.swing.JButton dropCourseButton;
    private javax.swing.JComboBox<String> dropCourseComboBox;
    private javax.swing.JTextArea dropCourseTextArea;
    private javax.swing.JButton dropStudentButton;
    private javax.swing.JComboBox<String> dropStudentComboBox;
    private javax.swing.JTextArea dropStudentTextArea;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton scheduleCourseButton;
    private javax.swing.JComboBox<String> scheduleCoursesCoursesComboBox;
    private javax.swing.JLabel scheduleCoursesOutputLabel;
    private javax.swing.JTabbedPane scheduleCoursesPanel;
    private javax.swing.JComboBox<String> scheduleCoursesStudentsComboBox;
    private javax.swing.JTextArea scheduledStudentsTextArea;
    private javax.swing.JSpinner seatsSpinner;
    private javax.swing.JButton studentDropCourseButton;
    private javax.swing.JComboBox<String> studentDropCourseCourseComboBox;
    private javax.swing.JComboBox<String> studentDropCourseStudentComboBox;
    private javax.swing.JTextArea studentDropCourseTextArea;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JTextArea waitlistedStudentsTextArea;
    // End of variables declaration//GEN-END:variables
}
