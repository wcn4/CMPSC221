/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment3;

/**
 *
 * @author Yoshi
 */
public class CarLoan extends LoanAccount{
    
    //vehicleVIN is final 
    private final String vehicleVIN;
    
    //Create a CarLoan by creating a loan account and initializing vehicleVIN
    public CarLoan(double principle, double annualInterestRate, int months, String vehicleVIN){
        super(principle, annualInterestRate, months);
        this.vehicleVIN = vehicleVIN;
    }
    
    //Getter function for Vehicle VIN
    public String getVehicleVIN(){
        return vehicleVIN;
    }
    
    
    @Override
    public String toString(){
        String message = super.toString();
        message = String.format("Car Loan with:%n%sVehicle VIN: %s%n%n", message, this.getVehicleVIN());
        return message;
    }
    
}
