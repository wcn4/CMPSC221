
package programmingassignment3;

//The Loan Account
public class LoanAccount {
    //Set the data to be private for data encapsulation purposes
    
    //The annual interest rate of the loan
    private double annualInterestRate;
    
    //The number of months the loan is paid over
    private int months;
    
    //The starting amount of money put into the loan
    private final double principle;
    
    //Creates a loan account using the principle ammount, annual interest rate
    //And the number of months the loan is paid over
    public LoanAccount(double principle, double annualInterestRate, int months){
        this.principle = principle;     
        this.annualInterestRate = annualInterestRate;
        this.months = months;
    }
    
    
    //Using the number of months on the loan, calculates and returns the 
    //amount of money needed per month to pay off the loan within the 
    //number of payments given.
    public double calculateMonthlyPayment(){
        
        double monthlyInterest = annualInterestRate/(12 * 100);
        double monthlyPayment = principle * (monthlyInterest / (1- Math.pow(1 + monthlyInterest, -months)));
        return monthlyPayment;
    }
    
    //Getter function for Annual interest rate
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
    
    //Getter function for the number of months the loan is paid over
    public int getMonths(){
        return this.months;
    }
    
    @Override
    public String toString(){
        String message = String.format("Principle: $%.2f%n"
                + "Annual Interest Rate: %.2f%%%n"
                + "Term of Loan in Months: %d%n"
                + "Monthly Payment: $%.2f%n", 
                this.getPrinciple(), this.getAnnualInterestRate(), 
                this.getMonths(), this.calculateMonthlyPayment());
        return message;
    }
    
    
}
