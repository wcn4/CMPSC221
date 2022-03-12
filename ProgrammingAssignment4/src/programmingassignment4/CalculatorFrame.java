/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment4;

/**
 *
 * @author Yoshi
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame {
    
    //Create the attributes in this frame
    private final JLabel title;
    private JPanel line2;
    private final JLabel prompt;
    private final JTextField input;
    private final JButton button;
    private JLabel output;
    
    
    public CalculatorFrame(){
        //Create a JFrame and set title to "Pizza Servings Calculator"
        super("Pizza Servings Calculator");
        setLayout(new GridLayout(4,1));
        
        //Create a new JLabel, set the title, font, and color
        title = new JLabel();
        title.setText("Pizza Servings Calculator");
        Font font = new Font(Font.SERIF, Font.BOLD, 25);
        title.setFont(font);
        title.setForeground(Color.RED);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title);
        
        //Create a new JPanel, and put in a JLabel and JTextfield for the
        //prompt and input
        line2 = new JPanel();
        prompt = new JLabel();
        prompt.setText("Enter the size of the pizza in inches:");
        line2.add(prompt);
        input = new JTextField(4);
        line2.add(input);
        add(line2);
        
        //Create button
        button = new JButton();
        button.setText("Calculate Servings");
        //When the button is pressed, will grab the text in the input and 
        //format a message for the output label
        button.addActionListener(
                //Anonymous Inner Class 
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event){
                        double size = Double.parseDouble(input.getText());
                        double servings = Math.pow((size/8.0), 2);
                        //Inches is used solely for string formatting. If it is a whole number
                        //will not display decimal points. If it isn't, then will display 2 decimals
                        String inches = (size == (int)size) ? String.format("%.0f", size) : String.format("%.2f", size);
                        String message = String.format("A %s inch pizza will serve %.2f people.", inches, servings);
                        output.setText(message);
                    }
                }
            );
        
        add(button);
        
        //Create Output Label, align it to center, and have it blank at the start
        output = new JLabel();
        output.setHorizontalAlignment(JLabel.CENTER);
        add(output);
    }   
      
}
