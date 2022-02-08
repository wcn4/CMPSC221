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
    private double annualInterestRate = 0;
    private int months = 0;
    
    //The starting amount of money put into the loan
    private final double principle;
    
    public LoanAccount(double principle, double annualInterestRate, int months){
        this.principle = principle;     
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
    
    //Given a number of total payments, calculates and returns the 
    //amount of money needed per month to pay off the loan within the 
    //number of payments given.
    public double calculateMonthlyPayment(int numberOfPayments){
        
        double monthlyInterest = annualInterestRate/(12 * 100);
        double monthlyPayment = principle * (monthlyInterest / (1- Math.pow(1 + monthlyInterest, -numberOfPayments)));
        return monthlyPayment;
    }
    
    //Updates annualInterest Rates for all instances of LoanAccount
    //Recalculates monthlyInterest based off the value of annualInterestRate
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    //Getter function for principle
    public double getPrinciple(){
        return principle;
    }
}
