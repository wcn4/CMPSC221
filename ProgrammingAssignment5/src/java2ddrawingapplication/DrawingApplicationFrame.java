/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    private final JPanel statusLabel;
    
    // create the widgets for the firstLine Panel.
    private final JPanel shapesPanel;
    private final JLabel firstLineText;
    private final JComboBox shapeSelection;
    private final JButton firstColor;
    private final JButton secondColor;
    private final JButton undo;
    private final JButton clear;
    //create the widgets for the secondLine Panel.
    private final JPanel optionsPanel;
    // Variables for drawPanel.

    // add status label
  
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
        super("Java 2D Drawings");
        
        mainLayout = new BorderLayout();
        setLayout(mainLayout);
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        
        // add widgets to panels
        shapesPanel = new JPanel();
        shapesPanel.setLayout(new FlowLayout());
        firstLineText = new JLabel("Shape:");
        String[] shapes = {"Line", "Rectangle", "Oval"};
        shapeSelection = new JComboBox(shapes);
        firstColor = new JButton("1st Color...");
        secondColor = new JButton("2nd Color...");
        undo = new JButton("Undo");
        clear = new JButton("Clear");
        
        shapesPanel.add(firstLineText);
        shapesPanel.add(shapeSelection);
        shapesPanel.add(firstColor);
        shapesPanel.add(secondColor);
        shapesPanel.add(undo);
        shapesPanel.add(clear);
        
        topPanel.add(shapesPanel);
        
        optionsPanel = new JPanel();
        
        topPanel.add(optionsPanel);
        
        
        drawPanel = new JPanel();
        
        statusLabel = new JPanel();
        
        
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
            }
        }

    }
}
