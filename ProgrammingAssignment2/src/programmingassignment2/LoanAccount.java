/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignment2;

/**
 *
 * @author Yoshi
 */
public class LoanAccount {
    //Set the data to be private for data encapsulation purposes
    
    //These static variables will be shared across all classes
    //Will default to zero
    private static double annualInterestRate = 0;
    private static double monthlyInterest = 0;
    
    //The starting amount of money put into the loan
    private final double principle;
    
    public LoanAccount(double principle){
        this.principle = principle;      
    }
    
    
    //Given a number of total payments, calculates and returns the 
    //amount of money needed per month to pay off the loan within the 
    //number of payments given.
    public double calculateMonthlyPayment(int numberOfPayments){
        //double monthlyInterest = 0; //Update with the final payment amount
        double monthlyPayment = principle * (monthlyInterest / (1- Math.pow(1 + monthlyInterest, -numberOfPayments)));
        return monthlyPayment;
    }
    
    //Updates annualInterest Rates for all instances of LoanAccount
    //Recalculates monthlyInterest based off the value of annualInterestRate
    public static void setAnnualInterestRate(double newAnnualInterestRate){
        annualInterestRate = newAnnualInterestRate;
        monthlyInterest = annualInterestRate / 12;
    }
    
    //Getter function for principle
    public double getPrinciple(){
        return principle;
    }
}
