/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


/**
 *
 * @author acv
 */
public class DrawingApplicationFrame extends JFrame
{
    private final BorderLayout mainLayout;
    
    // Create the panels for the top of the application. One panel for each
    // line and one to contain both of those panels   
    private final JPanel topPanel;
    private final JPanel drawPanel;
    
    //The widgets for the firstLine Panel
    private final JPanel shapesPanel;
    private final JComboBox shapeSelectionBox;
    private final JButton firstColorButton;
    private final JButton secondColorButton;
    private final JButton undoButton;
    private final JButton clearButton;
    
    //The widgets for the secondLine Panel
    private final JPanel optionsPanel;
    private final JCheckBox filledBox;
    private final JCheckBox gradientBox;
    private final JCheckBox dashedBox;
    private final JSpinner lineWidthScroll;
    private final JSpinner dashLengthScroll;
    
    
    // Variables for drawPanel.
    private enum Shape{
        Line,
        Rectangle,
        Oval
    }
    private Shape shape = Shape.Line;
    private Color firstColor = Color.GRAY;
    private Color secondColor = Color.GRAY;
    private boolean filled = false;
    private boolean gradient = false;
    private boolean dashed = false;
    private int lineWidth = 1;
    private float[] dashLength = {1.0f };
    private ArrayList<MyShapes> shapesDrawn;
    
    //Status Label 
    private JLabel statusLabel;
    
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
        super("Java 2D Drawings");
        
        mainLayout = new BorderLayout();
        setLayout(mainLayout);
        
        //This is where all the options are created.
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        
        //This is for the first line of options.
        shapesPanel = new JPanel();
        shapesPanel.setBackground(Color.CYAN);
        shapesPanel.setLayout(new FlowLayout());
        String[] shapes = {"Line", "Rectangle", "Oval"};
        shapeSelectionBox = new JComboBox(shapes);
        shapeSelectionBox.addItemListener(
                new ItemListener(){
                    //Select the corresponding enum value based off of comboBox
                    @Override
                    public void itemStateChanged(ItemEvent event){
                        if(event.getStateChange() == ItemEvent.SELECTED){
                            switch(shapeSelectionBox.getSelectedIndex()){
                                case 0:
                                    shape = Shape.Line;
                                    break;
                                case 1:
                                    shape = Shape.Rectangle;
                                    break;
                                case 2:
                                    shape = Shape.Oval;
                                    break;
                                default:
                                   shape = Shape.Line;
                                   break;
                            }
                        }
                    }
                }
        );
        
        firstColorButton = new JButton("1st Color...");
        //Use JColorChooser to select the first color
        firstColorButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        firstColor = JColorChooser.showDialog(DrawingApplicationFrame.this, 
                                "Choose a Color", firstColor);
                        if (firstColor == null)
                            firstColor = Color.GRAY;
                    }
                }
        );
        secondColorButton = new JButton("2nd Color...");
        //Use JColorChooser to select the second color as well
        secondColorButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        secondColor = JColorChooser.showDialog(DrawingApplicationFrame.this, 
                                "Choose a Color", secondColor);
                        if (secondColor == null)
                            secondColor = Color.GRAY; 
                    }
                }
        );
        undoButton = new JButton("Undo");
        //Removes the most recently added element
        undoButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        shapesDrawn.remove(shapesDrawn.size()-1);
                        repaint();
                    }
                }
        );
        clearButton = new JButton("Clear");
        //Removes all elements in shapesDrawn
        clearButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        shapesDrawn.clear();
                        repaint();
                    }
                    
                }
        );
        
        
        //Add the components into the first line
        shapesPanel.add(new JLabel("Shape:"));
        shapesPanel.add(shapeSelectionBox);
        shapesPanel.add(firstColorButton);
        shapesPanel.add(secondColorButton);
        shapesPanel.add(undoButton);
        shapesPanel.add(clearButton);
        //Add the first line to the topPanel
        topPanel.add(shapesPanel);
        
        //Create the second line of options
        optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.CYAN);
        optionsPanel.setLayout(new FlowLayout());
        filledBox = new JCheckBox("Filled");
        //Add a checkbox for the filled option
        filledBox.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        filled = !filled;
                    }
                }
        );
        gradientBox = new JCheckBox("Use Gradient");
        //Add a checkbox for the gradient option
        gradientBox.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        gradient = !gradient;
                    }
                }
        );
        dashedBox = new JCheckBox("Dashed");
        //Add a checkbox for the dashed option
        dashedBox.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        dashed = !dashed;
                    }
                }
        );
        lineWidthScroll = new JSpinner();
        //Sets it such that initial value is 1, minimum is 1, max is 100, step is 1
        lineWidthScroll.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        lineWidthScroll.addChangeListener(
                //Since JSpinners do not use ActionListeners, use ChangeListeners
                //Instead to set the value of lineWidth
                new ChangeListener(){
                    @Override
                    public void stateChanged(ChangeEvent event){
                        lineWidth = (int)lineWidthScroll.getValue();
                    }
                }
        );
        dashLengthScroll = new JSpinner();
        //Sets it such that initial value is 1, minimum is 1, max is 100, step is 1
        dashLengthScroll.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        //Set the value of the dashLength
        dashLengthScroll.addChangeListener(
                new ChangeListener(){
                    @Override
                    public void stateChanged(ChangeEvent event){
                        //Ugly hack to get the conversions to work
                        dashLength[0] = (float)(int)(dashLengthScroll.getValue());
                    }
                }
        );
        
        //Add the components into the second line of the top Panel
        optionsPanel.add(new JLabel("Options:"));
        optionsPanel.add(filledBox);
        optionsPanel.add(gradientBox);
        optionsPanel.add(dashedBox);
        optionsPanel.add(new JLabel("Line Width:"));
        optionsPanel.add(lineWidthScroll);
        optionsPanel.add(new JLabel("Dash Length:"));
        optionsPanel.add(dashLengthScroll);
        //Add the second Line to the top panel.
        topPanel.add(optionsPanel);
        
        //Create the drawPanel
        drawPanel = new DrawPanel();

        //Create the status label
        statusLabel = new JLabel("(0, 0)");
        
        //Add all three panels to the main layout
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        
        //Create an empty array for shapesDrawn
        shapesDrawn = new ArrayList<MyShapes>();        
    }

    private class DrawPanel extends JPanel
    {
        //Set the background to white and add mouse handler
        public DrawPanel()
        {
            super.setBackground(Color.WHITE);
            MouseHandler handler = new MouseHandler();
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }
        
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            //loop through and draw each shape in the shapes arraylist
            for (MyShapes s:shapesDrawn){
                s.draw(g2d);
            }
            

        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {
            //Create a new shape everytime mouse is pressed according to the
            //settings
            public void mousePressed(MouseEvent event)
            {
                Paint paint;
                Stroke stroke;
                MyShapes newShape;
                Point pointA = new Point(event.getX(), event.getY());
                
                //If there is a gradient, change the paint.
                if (gradient)
                    paint = new GradientPaint(0, 0, firstColor, 50, 50, secondColor, true);
                else
                    paint = firstColor;
                
                //If it is dashed, change the stroke.
                if (dashed)
                    stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashLength, 0);
                else
                    stroke =  new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                
                //Create the corresponding Shape depending on the value of shape.
                switch(shape){
                    case Line:
                        newShape = new MyLine(pointA, pointA, paint, stroke);
                        break;
                    case Rectangle:
                        newShape = new MyRectangle(pointA, pointA, paint, stroke, filled);
                        break;
                    case Oval:
                        newShape = new MyOval(pointA, pointA, paint, stroke, filled);
                        break;
                    default:
                        newShape = new MyLine(pointA, pointA, paint, stroke);
                        break;
                }
                
                shapesDrawn.add(newShape);
                statusLabel.setText("(" + event.getX() + "," + event.getY() + ")");
                //System.out.println("Added the shape " + shape);
                repaint();
                    
            }
            
            //Update the final position once the mouse has been released
            public void mouseReleased(MouseEvent event)
            {
                Point pointB = new Point(event.getX(), event.getY());
                shapesDrawn.get(shapesDrawn.size() - 1).setEndPoint(pointB);
                statusLabel.setText("(" + event.getX() + "," + event.getY() + ")");
                repaint();
            }
            
            //Update the endpoint as the mouse is being dragged
            @Override
            public void mouseDragged(MouseEvent event)
            {
                Point pointB = new Point(event.getX(), event.getY());
                shapesDrawn.get(shapesDrawn.size() - 1).setEndPoint(pointB);
                statusLabel.setText("(" + event.getX() + "," + event.getY() + ")");
                repaint();
            }
            
            //Update the status label as the mouse moves
            @Override
            public void mouseMoved(MouseEvent event)
            {
                statusLabel.setText("(" + event.getX() + "," + event.getY() + ")");
            }
        }

    }
    
    
}
