/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment2;

/**
 *
 * @author Yoshi
 */
public class CarLoan extends LoanAccount{
    
    private final String vehicleVIN;
    
    public CarLoan(double principle, double annualInterestRate, int months, String vehicleVIN){
        super(principle, annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;
    }
    
}
