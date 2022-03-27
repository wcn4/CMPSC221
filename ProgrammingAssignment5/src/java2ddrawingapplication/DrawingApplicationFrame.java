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
    // line and one to contain both of those panels.
    
    private final JPanel topPanel;

    private final JPanel drawPanel;
    
    
    // create the widgets for the firstLine Panel.
    private final JPanel shapesPanel;
    private final JComboBox shapeSelectionBox;
    private final JButton firstColorButton;
    private final JButton secondColorButton;
    private final JButton undoButton;
    private final JButton clearButton;
    //create the widgets for the secondLine Panel.
    private final JPanel optionsPanel;
    private final JCheckBox filledBox;
    private final JCheckBox gradientBox;
    private final JCheckBox dashedBox;
    private final JSpinner lineWidthScroll;
    private final JSpinner dashLengthScroll;
    
    
    // Variables for drawPanel.
    private int xPos;
    private int yPos;
    private enum Shape{
        Line,
        Rectangle,
        Oval
    }
    private Shape shape;
    private Color firstColor;
    private Color secondColor;
    private boolean filled = false;
    private boolean gradient = false;
    private boolean dashed = false;
    private int lineWidth = 1;
    private int dashLength = 1;
    private ArrayList<Shape> shapesDrawn;
    
    // add status label
    private JLabel statusLabel;
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
        super("Java 2D Drawings");
        
        mainLayout = new BorderLayout();
        setLayout(mainLayout);
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        //topPanel.setBackground(new Color(50, 200, 200));
        //topPanel.setBackground(Color.CYAN);
        
        // add widgets to panels
        shapesPanel = new JPanel();
        shapesPanel.setBackground(Color.CYAN);
        shapesPanel.setLayout(new FlowLayout());
        String[] shapes = {"Line", "Rectangle", "Oval"};
        shapeSelectionBox = new JComboBox(shapes);
        shapeSelectionBox.addItemListener(
                new ItemListener(){
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
        firstColorButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        firstColor = JColorChooser.showDialog(DrawingApplicationFrame.this, 
                                "Choose a Color", firstColor);
                    }
                }
        );
        secondColorButton = new JButton("2nd Color...");
        secondColorButton.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        secondColor = JColorChooser.showDialog(DrawingApplicationFrame.this, 
                                "Choose a Color", secondColor);
                    }
                }
        );
        //Not sure what to do for these just yet.
        undoButton = new JButton("Undo");
        clearButton = new JButton("Clear");
        
        
        shapesPanel.add(new JLabel("Shape:"));
        shapesPanel.add(shapeSelectionBox);
        shapesPanel.add(firstColorButton);
        shapesPanel.add(secondColorButton);
        shapesPanel.add(undoButton);
        shapesPanel.add(clearButton);
        
        topPanel.add(shapesPanel);
        
        optionsPanel = new JPanel();
        optionsPanel.setBackground(Color.CYAN);
        optionsPanel.setLayout(new FlowLayout());
        filledBox = new JCheckBox("Filled");
        filledBox.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        filled = !filled;
                    }
                }
        );
        gradientBox = new JCheckBox("Use Gradient");
        gradientBox.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        gradient = !gradient;
                    }
                }
        );
        dashedBox = new JCheckBox("Dashed");
        lineWidthScroll = new JSpinner();
        //Sets it such that initial value is 1, minimum is 1, max is 100, step is 1
        lineWidthScroll.setModel(new SpinnerNumberModel(1, 1, 100, 1));
        lineWidthScroll.addChangeListener(
                //Since JSpinners do not use ActionListeners, use ChangeListeners
                //Instead
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
        dashLengthScroll.addChangeListener(
                new ChangeListener(){
                    @Override
                    public void stateChanged(ChangeEvent event){
                        dashLength = (int)dashLengthScroll.getValue();
                    }
                }
        );
        
        optionsPanel.add(new JLabel("Options:"));
        optionsPanel.add(filledBox);
        optionsPanel.add(gradientBox);
        optionsPanel.add(dashedBox);
        optionsPanel.add(new JLabel("Line Width:"));
        optionsPanel.add(lineWidthScroll);
        optionsPanel.add(new JLabel("Dash Length:"));
        optionsPanel.add(dashLengthScroll);
        topPanel.add(optionsPanel);
        
        
        drawPanel = new DrawPanel();
        drawPanel.setBackground(Color.WHITE);

        
        statusLabel = new JLabel("(0, 0)");
        
        
        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        
        
        
        
        
        
        // firstLine widgets

        // secondLine widgets

        // add top panel of two panels

        // add topPanel to North, drawPanel to Center, and statusLabel to South
            //Use a border layout for this
        //add listeners and event handlers
    }
    
    // Create event handlers, if needed

    // Create a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel
    {

        public DrawPanel()
        {
            MouseHandler handler = new MouseHandler();
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //loop through and draw each shape in the shapes arraylist

        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {

            public void mousePressed(MouseEvent event)
            {
                
            }

            public void mouseReleased(MouseEvent event)
            {
            }

            @Override
            public void mouseDragged(MouseEvent event)
            {
                
            }

            @Override
            public void mouseMoved(MouseEvent event)
            {
                xPos = event.getX();
                yPos = event.getY();
                statusLabel.setText("(" + xPos + "," + yPos + ") " + lineWidth);
            }
        }

    }
    
    
}
