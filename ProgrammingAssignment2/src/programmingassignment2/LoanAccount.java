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
    public double calculateMonthlyPayment(){
        
        double monthlyInterest = annualInterestRate/(12 * 100);
        double monthlyPayment = principle * (monthlyInterest / (1- Math.pow(1 + monthlyInterest, -months)));
        return monthlyPayment;
    }
    
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
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
    
    public int getMonths(){
        return this.months;
    }
    
    @Override
    public String toString(){
        String message = String.format("Principle: $%.2f%n", this.getPrinciple());
        message = String.format("%sAnnual Interest Rate: %.2f%%%n", message, this.getAnnualInterestRate());
        message = String.format("%sTerm of Loan in Months: %d%n", message, this.getMonths());
        message = String.format("%sMonthly Payment: $%.2f%n", message, this.calculateMonthlyPayment());
        return message;
    }
    
    
}
