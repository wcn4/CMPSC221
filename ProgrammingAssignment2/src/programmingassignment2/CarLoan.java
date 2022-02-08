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
